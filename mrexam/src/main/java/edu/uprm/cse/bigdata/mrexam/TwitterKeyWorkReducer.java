package edu.uprm.cse.bigdata.mrexam;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by julian_cuevas1 on 10/17/18.
 */
public class TwitterKeyWorkReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

	String ids = "";

        for (Text value : values){
            ids += ", " + value.toString();
        }

        context.write(key, new Text(ids));
    }
}
