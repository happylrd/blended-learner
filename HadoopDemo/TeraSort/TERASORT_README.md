# TeraSort

***
## Overview
>A simple **TeraSort** Implementation that is based on *Hadoop MapReduce framework*.

***
## Execute Step
### 1.Produce Test Data
Run [DataGenerator](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/datagen/DataGenerator.java) to generate test data in input directory.

***
### 2.Run Sort Algorithm
Run [TeraSort](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/terasort/TeraSort.java), it will output some files in output directory, the number is determined by the reduce number that you choose.

***
### 3.Merge Output files
Run [merge.sh](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/script/merge.sh) to merge the output files that the reduces produce.
***

### 4.Get Top K Value
Run [TopKImpl](https://github.com/happylrd/blended-learner/blob/master/HadoopDemo/TeraSort/src/io/happylrd/topk/TopKImpl.java) to get the top k values.

***
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

***
## Recommend
[Map/Reduce之间的shuffle,partition,combiner过程的详解](http://www.cnblogs.com/ljy2013/articles/4435657.html)

## License
[MIT](http://opensource.org/licenses/MIT)


Copyright &copy; 2016-2017 Diego Li
