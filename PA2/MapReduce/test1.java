import java.io.IOException;
import java.util.Arrays;

public class test1 {
    
    public static void main(String[] args) throws Exception {
        String s = "09-Dec-18,6:00PM;#Hackatopia,Tribeca Film Hackathon: Code As A New Language For Content Creators Hackathon";
        String a[] = s.split("\\W");
        String[] keywords = {"hackathon", "Dec", "Chicago", "Java"};
        
        for (int i = 0; i < a.length; ++i){
            //System.out.println(a[i]);
            for (String keyword : keywords)
                if (a[i].toLowerCase().contains(keyword.toLowerCase()))
                    System.out.println(keyword + " " + "1" + "\n");
        }
    }
}