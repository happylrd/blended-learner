package io.happylrd.terasort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeraSortSampler {
    private static final String SPLIT_SAMPLE_PATH_STR
            = "/home/happylrd/MyCode/HadoopProjects/TeraSort/data/sample/SplitSample";
    private static final Path SPLIT_SAMPLE_PATH =
            new Path(SPLIT_SAMPLE_PATH_STR);

    public static void doSample(Job job, int sampleNum) throws Exception {

        InputFormat inputFormat = new TextInputFormat();
        List<InputSplit> inputSplitList = inputFormat.getSplits(job);

        int splitSize = inputSplitList.size();
        int samplePerPartition =
                sampleNum / splitSize;

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

        // just for print
        System.out.println("SampleNumber: " + sampleNum);
        System.out.println("SampleList elements: ");
        for (Integer sample : sampleList) {
            System.out.print(sample + " ");
        }
        System.out.println();

        Collections.sort(sampleList);

        // to write in local fs /tmp/SplitSample
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

        // add cache, but isn't useful
        job.addCacheFile(new URI(SPLIT_SAMPLE_PATH.toString()));
    }

    public static int[] getSplitPoints(Configuration conf, int reduceNum) {
        FileSystem fs;
        DataInputStream reader = null;
        int[] points = new int[reduceNum - 1];

        try {
            fs = FileSystem.get(conf);
            reader = fs.open(SPLIT_SAMPLE_PATH);

            for (int i = 0; i < points.length; i++) {
                points[i] = Integer.parseInt(reader.readLine().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return points;
    }
}
