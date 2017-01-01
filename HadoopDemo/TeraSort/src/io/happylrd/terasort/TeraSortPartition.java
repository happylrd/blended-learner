package io.happylrd.terasort;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class TeraSortPartition
        extends Partitioner<IntWritable, NullWritable>
        implements Configurable {
    private Configuration conf = null;
    private int[] splitPoints = null;

    @Override
    public int getPartition(IntWritable key, NullWritable value, int reduceNum) {
        if (splitPoints == null) {
            splitPoints = TeraSortSampler.getSplitPoints(conf, reduceNum);
        }

        // just for print
        System.out.println("Key:" + key);
        for (int splitPoint : splitPoints) {
            System.out.print(splitPoint + " ");
        }
        System.out.println();

        int index = splitPoints.length;
        for (int i = 0; i < splitPoints.length; i++) {
            if (key.get() < splitPoints[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Configuration getConf() {
        return this.conf;
    }

    @Override
    public void setConf(Configuration conf) {
        this.conf = conf;
    }
}