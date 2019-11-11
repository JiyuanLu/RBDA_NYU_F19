import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper
      extends Mapper<LongWritable, Text, Text, IntWritable> {
          
    @Override
    public void map(LongWritable key, Text value, Context context)
          throws IOException, InterruptedException {
        String[] keywords = {"hackathon", "Dec", "Chicago", "Java"};
        String line = value.toString();
        String[] wordArray = line.toLowerCase().split("\\W");
        List<String> wordList = Arrays.asList(wordArray);
        
        for (String keyword : keywords)
            if (wordList.contains(keyword.toLowerCase()))
                context.write(new Text(keyword), new IntWritable(1));
            else
                context.write(new Text(keyword), new IntWritable(0));
    }
}
        
        