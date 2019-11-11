import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageRankMapper extends Mapper<LongWritable, Text, Text, Text> {
    
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] words = line.split("\\s");
        int numOfLinks = words.length - 2;
        String source = words[0];
        double probability = Double.parseDouble(words[words.length-1]);
        double contribution = probability / numOfLinks;
        String destinations = "";
        for (int i = 1; i < words.length - 1; ++i){
            String destination = words[i];
            destinations = destinations + destination + " ";
            context.write(new Text(destination), new Text(String.valueOf(contribution)));
        }
        context.write(new Text(source), new Text(destinations));
    }
}