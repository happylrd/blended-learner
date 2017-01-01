package io.happylrd.terasort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class TeraSort {
    private static final int REDUCE_TASK_NUM = 4;

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args)
                .getRemainingArgs();

        if (otherArgs.length != 2) {
            System.err.println("Usage:terasort<in><out>");
            System.exit(2);
        }

        Path inputPath = new Path(otherArgs[0]);
        Path outputPath = new Path(otherArgs[1]);

        FileSystem fs = FileSystem.get(conf);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath, true);
        }

        Job job = Job.getInstance(conf, "TeraSort");
        job.setJarByClass(TeraSort.class);

        job.setPartitionerClass(TeraSortPartition.class);
        job.setMapperClass(TeraSortMapper.class);
        job.setReducerClass(TeraSortReducer.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.addInputPath(job, inputPath);
        FileOutputFormat.setOutputPath(job, outputPath);

        job.setNumReduceTasks(REDUCE_TASK_NUM);

        TeraSortSampler.doSample(job, 100);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
