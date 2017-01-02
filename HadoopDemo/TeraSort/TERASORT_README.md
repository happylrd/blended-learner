# TeraSort

## Overview
>A simple **TeraSort** Implementation that is based on *Hadoop MapReduce framework*.

## Execute Step
### 1.Produce Test Data
Run [DataGenerator](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/datagen/DataGenerator.java) to generate test data in input directory.

Result
![generate-data](/assets/generate-data.png)

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

![put-data](/assets/put-data.png)

##### 2.Run jar to do map reduce task

Just execute
```
hadoop jar /home/happylrd/MyCode/HadoopProjects/TeraSort/out/artifacts/terasort/terasort.jar io.happylrd.terasort.TeraSort /user/happylrd/TeraSort/input /user/happylrd/TeraSort/output
```

![run-jar](/assets/run-jar.png)

Result
![run-jar-result-1](/assets/run-jar-result-1.png)
![run-jar-result-2](/assets/run-jar-result-2.png)
![run-jar-result-3](/assets/run-jar-result-3.png)
![run-jar-result-4](/assets/run-jar-result-4.png)
![run-jar-result-5](/assets/run-jar-result-5.png)

Query for validation
![query-after-run](/assets/query-after-run.png)
Everything goes well.

##### 3.Get output file from hdfs to local file system

Just execute
```
hdfs dfs -get /user/happylrd/TeraSort/output /home/happylrd/MyCode/HadoopProjects/TeraSort/data/
```
![get-data](/assets/get-data.png)

Result

![get-data-result](/assets/get-data-result.png)

#### By IDE

##### Configure
Let org.apache.hadoop.util.RunJar as Main class.
![idea-conf-1](/assets/idea-conf-1.png)
Configure program arguments.
![idea-conf-2](/assets/idea-conf-2.png)

##### Just run it
Result

![idea-run-result-1](/assets/idea-run-result-1.png)
![idea-run-result-2](/assets/idea-run-result-2.png)
![idea-run-result-3](/assets/idea-run-result-3.png)

### 3.Merge Output files
Run [merge.sh](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/script/merge.sh) to merge the output files that the reduces produce.

Shell script is as follows
```shell
#!/usr/bin/env bash
cd ../data/output
cat part-* > ../mergeResult/all-result.txt
```

Result
![merge-result](/assets/merge-result.png)

### 4.Get Top K Value
Run [TopKImpl](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/topk/TopKImpl.java) to get the top k values.

Result
![topk-result](/assets/topk-result.png)

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
