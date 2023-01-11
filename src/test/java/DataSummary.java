import java.io.BufferedReader;
import java.io.FileReader;

public class DataSummary
{
  public static void main(String[] args)
  {
    String filePath = "C:\\Users\\Daniel\\Desktop\\PlaniSense\\PlaniSense-daniel\\les-arbres.csv";
    
    try
    {
      BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
      
      String lineText = lineReader.readLine();
      String[] headers = lineText.split(";");
      
      int count = 0;
      int minAtt = headers.length;
      int[] max = new int[headers.length];
      
      while ((lineText = lineReader.readLine()) != null)
      {
        System.out.println(lineText);
        
        String[] data = lineText.split(";");
        if (data.length < headers.length)
        {
          String nextLine = lineReader.readLine();
          String completeLine = nextLine == null ? lineText : lineText + nextLine;
          System.out.println("incomplete line : " + lineText);
          System.out.println("replaced by : " + completeLine);
          System.out.println("");
          data = completeLine.split(";");
        }
        if (minAtt > data.length)
        {
          minAtt = data.length;
        }
        for (int i = 0; i < data.length; i++)
        {
          if (max[i] < data[i].length())
          {
            max[i] = data[i].length();
          }
        }
        count++;
      }
      lineReader.close();
      System.out.println("number of lines: " + count);
      System.out.println("min line has " + minAtt + " columns");
      for (int i = 0; i < max.length; i++)
      {
        System.out.println(headers[i] + " max length is " + max[i]);
      }
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }
}
