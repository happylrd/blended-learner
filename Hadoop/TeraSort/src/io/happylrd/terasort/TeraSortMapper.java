package io.happylrd.terasort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TeraSortMapper extends Mapper<Object, Text, IntWritable, NullWritable> {
    private static final IntWritable keyNumber = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        keyNumber.set(Integer.valueOf(value.toString()));
        context.write(keyNumber, NullWritable.get());
    }
}
