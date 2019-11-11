import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class WordCount{
    
    public static void main(String[] args) throws IOException{
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        
        String[] keywords = {"hackathon", "Dec", "Chicago", "Java"};
        int[] counts = {0, 0, 0, 0};
        String line;
        
        while ((line = reader.readLine()) != null){
            for (int i = 0; i < keywords.length; ++i){
                if (line.toLowerCase().contains(keywords[i].toLowerCase())){
                    ++counts[i];
                }
            }
        }
        
        for (int i = 0; i < keywords.length; ++i){
            writer.write(keywords[i] + " " + counts[i] + "\n");
            System.out.println(keywords[i] + " " + counts[i] + "\n");
        }
        
        reader.close();
        writer.close();
    }
}
        