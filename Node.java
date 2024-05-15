import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Node {
    char Name;
    LinkedList<Node> children;
    public Node(char Name) {
        this.Name = Name;
        children = new LinkedList<>();
    }

    //=========================================================================================================
    //==================the code to put the tree into a file as a text=========================================
    //=========================================================================================================
    public String lineCreator() {
        StringBuilder sb = new StringBuilder();
        sb.append(Name).append(" -> ");
        for (Node son : children) {
            sb.append(son.Name).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); 
        //هون نحنا شلنا اخر اندكسين لانو الحلقة رح تضيف فاصلة لاخر شي رح ينطبع 
        return sb.toString();
    }

    public static String exportedText(Node node) {
        //هاد التابع بيخلينا نلاقي النص اللي بدنا نحطو على الملف
        StringBuilder result = new StringBuilder();
        exportedTextHelper(node, result, 0);
        //هاد التابع بيساعدنا شوي نطلع كلشي لنقدر 
        return result.toString();
    }

    public static void exportedTextHelper(Node node, StringBuilder result, int depth) {
        if (node == null || node.children.isEmpty()) {
            return; //اذا ما كان عنا ابناء او النود فاضية 
        }
        result.append(node.lineCreator());
        boolean isDown = false;//هي كرمال ما يحط فراغات بالفاضي 
        for (Node son : node.children) {
            if(isDown == false){
            result.append("\n");
            isDown = true;
            }
            exportedTextHelper(son, result, depth + 1);
        }
    }


    public static void writeStringToFile(String content) {
        try (FileWriter writer = new FileWriter("Question2.txt")) {
            writer.write(content);
            System.out.println("Content written to Question2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //this main is for testing creating the tree and putting the file inside it
    public static void main(String[] args) {
        // Example usage
        Node root = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node j = new Node('J');
        Node k = new Node('K');

        root.children.add(b);
        root.children.add(c);
        root.children.add(d);
        d.children.add(j);
        j.children.add(k);

        String treeText = exportedText(root);
        System.out.println(treeText);
        writeStringToFile(treeText);
    }
    //===============================================================================================
    //==========this is the fenish of the file creation =============================================
    //===============================================================================================
}
