package edu.uprm.cse.bigdata.mrexam;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by julian_cuevas1 on 10/17/18.
 */
public class TwitterKeyWorkDriver {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: TwitterKeyWorkDriver <input path> <output path>");
            System.exit(-1);
        }
        Job job = new Job();
        job.setJarByClass(edu.uprm.cse.bigdata.mrexam.TwitterKeyWorkDriver.class);
        job.setJobName("Count Retweets");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(edu.uprm.cse.bigdata.mrexam.TwitterKeyWordMapper.class);
        job.setReducerClass(edu.uprm.cse.bigdata.mrexam.TwitterKeyWorkReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
	System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
