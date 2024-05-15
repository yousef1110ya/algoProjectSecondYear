import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class RecFile {
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
    public static RNode get_node_width(List<String> allLines , int Line_index , int Start_index){
        RNode Root = new RNode();
        for (int i = Start_index; i < allLines.get(Line_index).length(); i++) {
            if (allLines.get(Line_index).charAt(i) != '|' && allLines.get(Line_index).charAt(i) != ' ' && allLines.get(Line_index).charAt(i) != '_')  {
                char Name = allLines.get(Line_index).charAt(i);  
                int width = 0;
                int height = get_node_height(allLines , Line_index , Start_index);
                while (allLines.get(Line_index).charAt(i) == '_') {
                    width += 10;
                    Start_index ++;                    
                }
                Root.left = new RNode(Name, height, width);
            }
            
        }
        return Root;

    }
    private static int get_node_height(List<String> allLines, int line_index, int start_index) {
        int height =0;
       for (int i = line_index; i < allLines.size(); i++) {
        height += 10;
        if(allLines.get(i).charAt(start_index) == '_' || allLines.get(i).charAt(start_index) != ' '){
            break;
        }
       }
       return height;
    }
    static void printInorder(RNode RNode) {
        if (RNode == null) return;
        printInorder(RNode.left);
        System.out.print(RNode.name + " ");
        if (RNode.name == '_') {
            System.out.println("/n");
            
        }
        printInorder(RNode.right);
    }
    
    public static void main(String[] args) {
        RNode node0 = new RNode('-');
        RNode node1 = new RNode('|');
        RNode node2 = new RNode('|');
        RNode node3 = new RNode('|');
        RNode node4 = new RNode('-');
        RNode nodeA = new RNode('A',20,10);
        RNode nodeB = new RNode('B',20,10);
        RNode nodeC = new RNode('C',30,10);
        RNode nodeD = new RNode('D',30,50);
        RNode nodeE = new RNode('E',40,30);
        RNode nodeF = new RNode('F',40,20);
        node0.left = node1;
        node0.right = node2;
        node1.left=nodeA;
        node1.right=node3;
        node3.left=nodeB;
        node3.right=nodeC;
        node2.left=nodeD;
        node2.right=node4;
        node4.left=nodeE;
        node4.right=nodeF;
        printInorder(node0);
        List<String> temp = importFile();
    }
    
}
