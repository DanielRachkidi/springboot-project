import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImportCSVtoSQL
{
  public static void main(String[] args)
  {
    
    String jdbcUrl = "jdbc:postgresql://localhost:5555/dev";
    String username = "postgres";
    String password = "password";
    
    String filePath = "C:\\Users\\Daniel\\Desktop\\PlaniSense\\PlaniSense-daniel\\les-arbres.csv";
    
    Connection connection = null;
    
    try
    {
      connection = DriverManager.getConnection(jdbcUrl, username, password);
      connection.setAutoCommit(false);
      
      String sql =
        "insert into tree(idbase, type_emplacement, domanialite, arrondissement, complement_adress, numero, address, idemplacement, libell_francais, genre, espece) " +
        "values(?,?,?,?,?,?,?,?,?,?,?) on conflict (idbase) do nothing";
      
      PreparedStatement statement = connection.prepareStatement(sql);
      BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
      
      String lineText = lineReader.readLine();
      String[] headers = lineText.split(";");
      int count = 0;
      
      while ((lineText = lineReader.readLine()) != null)
      {
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
        count++;
        
        statement.setInt(1, Integer.parseInt(data[0]));
        for (int i = 2; i <= 11; i++)
        {
          statement.setString(i, data.length < i ? null : data[i - 1]);
        }
        statement.addBatch();
        
        if (count % 20000 == 0)
        {
          statement.executeBatch();
          connection.commit();
        }
      }
      statement.executeBatch();
      connection.commit();
      lineReader.close();
      connection.close();
      
      System.out.println(count + " data has been insert successfully.");
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }
}
