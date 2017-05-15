# TeraSort

## Overview

>A simple **TeraSort** Implementation that is based on *Hadoop MapReduce framework*.

## Preliminary knowledge

>Shuffle: data from map task to reduce task.

>Partition: decide the current output data should be passed to which reduce task to process according to key or value or the number of reduce tasks(Here, based on key and the number of reduce tasks).

## Key idea

**sample + partition**

Sample: get the split points according to the number of reduce tasks.

```java
InputFormat inputFormat = new TextInputFormat();
List<InputSplit> inputSplitList = inputFormat.getSplits(job);

int splitSize = inputSplitList.size();
int samplePerPartition =
        sampleNum / splitSize;
```

Notice **inputSplitList.size()** will be 1 if the file size below the block size of HDFS(64MB or 128MB).

Sample for the first *samplePerPartition* records

```java
List<Integer> sampleList = new ArrayList<>();
for (InputSplit split : inputSplitList) {
    TaskAttemptContext context = new TaskAttemptContextImpl(
            job.getConfiguration(), new TaskAttemptID()
    );
    RecordReader<Object, Text> reader =
            inputFormat.createRecordReader(split, context);
    Text text;
    reader.initialize(split, context);

    int count = 1;
    while (reader.nextKeyValue()) {
        if (count > samplePerPartition) {
            break;
        }
        text = reader.getCurrentValue();
        sampleList.add(
                Integer.parseInt(text.toString())
        );
        count++;
    }
    reader.close();
}
```

After Sort, get split points and write them into local file system, prepare for partition.

```java
FileSystem fs = FileSystem
        .get(job.getConfiguration());
DataOutputStream writer = fs
        .create(SPLIT_SAMPLE_PATH, true);

int stepLength =
        sampleList.size() / job.getNumReduceTasks();
int n = 0;
for (int i = stepLength; i < sampleList.size(); i += stepLength) {
    n++;
    if (n >= job.getNumReduceTasks()) {
        break;
    }
    new Text(sampleList.get(i) + "\r\n")
            .write(writer);
}

writer.close();
```

Partition: do partition according to the split points(namely the number of reduce tasks).

```java
@Override
public int getPartition(IntWritable key, NullWritable value, int reduceNum) {
    if (splitPoints == null) {
        splitPoints = TeraSortSampler.getSplitPoints(conf, reduceNum);
    }

    // just for print
    System.out.println("Key:" + key);

    int index = splitPoints.length;
    for (int i = 0; i < splitPoints.length; i++) {
        if (key.get() < splitPoints[i]) {
            index = i;
            break;
        }
    }
    return index;
}
```

## Execute Step

### 1.Produce Test Data

Run [DataGenerator](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/datagen/DataGenerator.java) to generate test data in input directory.

Result
![generate-data](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/generate-data.png)

### 2.Run Sort Algorithm
Run [TeraSort](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/terasort/TeraSort.java), it will output some files in output directory, the number is determined by the reduce number that you choose.

You can do it in two ways, one by shell, another by IDE.

#### By Shell
##### 1.Make directory in hdfs and put your input data file to it

Just execute
```
hdfs dfs -mkdir /user/happylrd/TeraSort
```

```
hdfs dfs -put /home/happylrd/MyCode/HadoopProjects/TeraSort/data/input/ /user/happylrd/TeraSort
```

Meanwhile, you can query for validation.
```
hdfs dfs -ls -R | grep TeraSort
```

![put-data](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/put-data.png)

##### 2.Run jar to do map reduce task

Just execute
```
hadoop jar /home/happylrd/MyCode/HadoopProjects/TeraSort/out/artifacts/terasort/terasort.jar io.happylrd.terasort.TeraSort /user/happylrd/TeraSort/input /user/happylrd/TeraSort/output
```

![run-jar](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/run-jar.png)

Result
![run-jar-result-1](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/run-jar-result-1.png)
![run-jar-result-2](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/run-jar-result-2.png)
![run-jar-result-3](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/run-jar-result-3.png)
![run-jar-result-4](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/run-jar-result-4.png)
![run-jar-result-5](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/run-jar-result-5.png)

Query for validation
![query-after-run](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/query-after-run.png)
Everything goes well.

##### 3.Get output file from hdfs to local file system

Just execute
```
hdfs dfs -get /user/happylrd/TeraSort/output /home/happylrd/MyCode/HadoopProjects/TeraSort/data/
```
![get-data](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/get-data.png)

Result

![get-data-result](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/get-data-result.png)

#### By IDE

##### Configure
Let org.apache.hadoop.util.RunJar as Main class.
![idea-conf-1](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/idea-conf-1.png)
Configure program arguments.
![idea-conf-2](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/idea-conf-2.png)

##### Just run it
Result

![idea-run-result-1](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/idea-run-result-1.png)
![idea-run-result-2](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/idea-run-result-2.png)
![idea-run-result-3](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/idea-run-result-3.png)

### 3.Merge Output files
Run [merge.sh](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/script/merge.sh) to merge the output files that the reduces produce.

Shell script is as follows
```shell
#!/usr/bin/env bash
cd ../data/output
cat part-* > ../mergeResult/all-result.txt
```

Result
![merge-result](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/merge-result.png)

### 4.Get Top K Value
Run [TopKImpl](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/topk/TopKImpl.java) to get the top k values.

Result
![topk-result](http://oj5if4v9b.bkt.clouddn.com/image/big-data/hadoop/topk-result.png)

## Thanks
Thanks to [Kubi Code](http://kubicode.me/2015/06/27/Hadoop/TeraSort-in-Hadoop/),you saved me a lot of time.

Meanwhile, I found one error in your code that I guessed it's probably because of the wrong hands.

You must add
```java
break;
```
to let three or more reduce tasks work fine. In essence, let partition process work fine.

Modified Code is as follows:
```java
int index = splitPoints.length;
for (int i = 0; i < splitPoints.length; i++) {
    if (key.get() < splitPoints[i]) {
        index = i;
        break;
    }
}
return index;
```

## Recommend
[Map/Reduce之间的shuffle,partition,combiner过程的详解](http://www.cnblogs.com/ljy2013/articles/4435657.html)

## License
[MIT](http://opensource.org/licenses/MIT)

Copyright &copy; 2016-2017 Diego Li
