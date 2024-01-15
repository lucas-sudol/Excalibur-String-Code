import java.io.*;
import java.util.*;

public class ExcaliburCodePractice
{
  public static void main (String [] args) throws IOException
  { 
    File input = new File ("/Users/lucassudol/Desktop/Java 12U/Review/Excalibur Code/input.txt");
    PrintWriter output = new PrintWriter(new FileWriter ("/Users/lucassudol/Desktop/Java 12U/Review/Excalibur Code/output.txt"));
    
    Scanner inFile = new Scanner(input);
    
    String line = "";
    String password = "";
    String inputLine = "";
    
    String firstHalf, seccondHalf, backWardSeccond;
    //new
    int ctr;
    
    while(inFile.hasNextLine())
    {
      line = inFile.nextLine();
      
      if (!line.startsWith("<") && !line.endsWith(">"))
      {
        password = line;
      }
      else
      {
        inputLine = line;
      }
      
      if (!inputLine.isEmpty())
      {
        inputLine = inputLine.substring (1, inputLine.length()-1);
        
        //new
        ctr = 0;
        while (!inputLine.startsWith(password))
        {
          firstHalf = "";
          seccondHalf = "";
          backWardSeccond = "";
          //new
          ctr = ctr +1;
          
          for(int i = 0; i < inputLine.length(); i++)
          {
            if (i % 2 == 0)
            {
              seccondHalf = seccondHalf + inputLine.charAt(i);
            }
            else
            {
              firstHalf = firstHalf + inputLine.charAt(i);
            }
          }
          
          //Reversing seccond half
          for (int wordLength = seccondHalf.length(); wordLength > 0; wordLength--)
          {
            backWardSeccond = backWardSeccond.concat(Character.toString(seccondHalf.charAt(wordLength-1)));
          }
          
          inputLine = firstHalf + backWardSeccond;    
        }
        
        inputLine = inputLine.substring(password.length(), inputLine.length());
        //new
        inputLine = inputLine + " ctr:" + ctr;
        
        output.println(inputLine);
        output.println("");
      }
      
    }
    
    output.close();                                      
  } 
}