import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TreeNodee {
    public char data;
    public TreeNodee left;
    public TreeNodee right;

    public TreeNodee(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
/*public static void writeStringToFile(String content) {
        try (FileWriter writer = new FileWriter("Question2.txt")) {
            writer.write(content);
            System.out.println("Content written to Question2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

public static List<String> importFile(){
    try {
        List<String> allLines = Files.readAllLines(Paths.get("Question2.txt"));
        for (String line : allLines) {
            System.out.println(line);
        }
        
        return   allLines;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
    
}
public static void main(String[] args) {
    //writeStringToFile("This is Test String");
    List<String> Temp = importFile();
    
}
}