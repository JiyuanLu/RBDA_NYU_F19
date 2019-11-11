import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class BadWordCount{
    
    public static void main(String[] args) throws IOException {
        String[] keywords = {"hackathon", "Dec", "Chicago", "Java"};
        int[] counts = {0, 0, 0, 0};
        
        Path inputFile = Paths.get("input.txt");
        Path outputFile = Paths.get("output.txt");
        List<String> lines  = Files.readAllLines(inputFile);
        
        for (String line : lines){
            for (int i = 0; i < keywords.length; ++i){
                if (line.toLowerCase().contains(keywords[i].toLowerCase()))
                    ++counts[i];        
            }
        }
        
        for (int i = 0; i < keywords.length; ++i)
            Files.write(outputFile, (keywords[i] + " " + counts[i] + '\n').getBytes(), StandardOpenOption.APPEND);
    }
}
        
        
        