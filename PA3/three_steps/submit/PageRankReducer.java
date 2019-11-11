import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageRankReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        double probability = 0.0;
        String output = "";
        for (Text value : values){
            if (value.toString().matches("\\d.*"))
                probability += Double.parseDouble(value.toString());
            else
                output += value.toString();
        }
        output += String.valueOf(probability);
        context.write(key, new Text(output));
    }
}
        
        
        
                
                