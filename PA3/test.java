import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class test{
    
    public static void main(String[] args) throws IOException{
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        String line;
        
        while ((line=reader.readLine()) != null){
            String[] words = line.split("\\s");
            String source = words[0];
            String probability = words[words.length-1];
            //System.out.println("source:" + source);
            //System.out.println("destination:");
            int numOfLinks = words.length - 2;
            double contribution = Double.parseDouble(probability) / numOfLinks;
            String destinations = " ";
            for (int i = 1; i < words.length-1; ++i){
                String destination = words[i];
                //System.out.println(destination);
                destinations = destinations + destination + " ";
            }
            //System.out.println("probability:" + probability);
            //System.out.println("contribution:" + contribution);
            //System.out.println(source + destinations);
        }
        System.out.println("0.123456".matches("\\d.*"));
        System.out.println("1.123456".matches("\\d.*"));
        System.out.println(" C J ".matches("\\d.*"));
        
        //System.out.println("0.123456".matches("\\s.*"));
        //System.out.println("1.123456".matches("\\s.*"));
        //System.out.println(" C J ".matches("\\s.*"));
    }
}