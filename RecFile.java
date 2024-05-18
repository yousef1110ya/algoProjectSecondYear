import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

















    public static RNode get_Nodes_from_Rec (List<String> allLines ){
        List<RNode> root = new LinkedList<>();
        List<RNode> ans = new LinkedList<>();
        int total_width_of_rec = allLines.get(0).replace(" ", "").length();// to get the total width of the big rectangle
        int current_height =0;
        int current_width = 0;
        for (int i = 1; i < allLines.size(); i++) {
            String current_line = allLines.get(i);
            current_line = current_line.replace("|", "");// removed all the | to get right readings
            RNode node = get_nodes_from_line(allLines , current_line , i,total_width_of_rec,allLines.size());//the finction to return all the nodes you see in the Line 
            // we are reading
            root.add(node);//added the nodes from every line to this list so we can make it into aa tree after a while
        }
        for (RNode rNode : root) {
            if (rNode != null) {
                ans.add(rNode);
            }
        }

        RNode Returned_node = new RNode('_');
        Returned_node.left = ans.get(0);
        Returned_node.right = ans.get(1);
        return Returned_node;
    }
    private static RNode get_nodes_from_line(List<String> allLines, String current_line, int current_line_index,int total_width_of_rec,int total_height) {
        List<RNode> root = new LinkedList<>();
        Stack<RNode> on_hold_till_finding_root = new Stack<>();//this stack is to find the root of a sub tree 
        int total_width_of_current_Nodes =0;
        int biggeest_height_of_the_current_Nodes =0;
        for (int i = 0; i < current_line.length(); i++) {
            if (current_line.charAt(i) != ' ' && current_line.charAt(i) != '_' && on_hold_till_finding_root.empty() ) {//this condition is for finding the Name of the Node
                int width = find_width_of_node(current_line,i);
                int height = get_node_height(allLines, current_line_index, i);
                RNode node = new RNode(current_line.charAt(i), height, width);//created the node 
                total_width_of_current_Nodes += width;
                if(height > biggeest_height_of_the_current_Nodes){
                    biggeest_height_of_the_current_Nodes = height;
                }
                root.add(node);//added the node to this list because it is possible to have more than one node in the same line
            }
            if (current_line.charAt(i) != ' ' && current_line.charAt(i) != '_' && !root.isEmpty()) {//for defining a node and the line already has a node before it
                int width = find_width_of_node(current_line,i);
                int height = get_node_height(allLines, current_line_index, i);
                RNode node = new RNode(current_line.charAt(i), height, width);
                if (width + total_width_of_current_Nodes < total_width_of_rec) {//this condition if to finde if there is another node in the line
                    on_hold_till_finding_root.add(node);// added to the stack because we want to find the rooot of the rest 
                    if (height < biggeest_height_of_the_current_Nodes) {
                        RNode sub_tree_root = new RNode('_');
                        sub_tree_root.left = on_hold_till_finding_root.pop();
                        sub_tree_root.right = get_vertical_Nodes(allLines,sub_tree_root.left.height+1,i,total_width_of_rec,total_height);
                        root.add(sub_tree_root);//created a sub tree to add to the node we want to return
                    }else{
                        RNode sub_tree_root = new RNode('|');
                        sub_tree_root.left = on_hold_till_finding_root.pop();
                        int sub_width = find_width_of_node(current_line,total_width_of_current_Nodes);
                        int sub_height = get_node_height(allLines, current_line_index, total_width_of_current_Nodes);
                        sub_tree_root.right = new RNode(current_line.charAt(i), sub_height, sub_width);
                        root.add(sub_tree_root);//also created a sub tree to add to the node we want to add to the return
                    }                
                }            
            }
        }
        RNode Big_root = null;
        if (total_width_of_current_Nodes < total_width_of_rec) {
             Big_root = new RNode('|');//thr root of the final tree we want to return 
            Big_root.left = root.get(0);
            Big_root.right = root.get(1);
            
        }
        if (biggeest_height_of_the_current_Nodes < total_height) {
             Big_root = new RNode('_');
            Big_root.left = root.get(0);
            Big_root.right = root.get(1);
            
        }
        return Big_root;
    }
    private static RNode get_vertical_Nodes(List<String> allLines, int current_line_index, int vertical_index,
            int total_width_of_rec, int total_height) {
                String current_line = allLines.get(current_line_index);
                int width = find_width_of_node(current_line,vertical_index);
                int height = get_node_height(allLines, current_line_index, vertical_index);
                RNode node = new RNode(current_line.charAt(vertical_index), height, width);


                return node;
       
    }

    private static int find_width_of_node(String current_line, int start_index) {
        int width =0;
        boolean condition = true;
        if (current_line.length() > start_index) {
        while (condition) {
            start_index ++;
            width ++;   
            if (current_line.charAt(start_index) != ' ') {
                condition = false;
                
            }
        }   
        }
        return width;
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




















    /*public static RNode get_node(List<String> allLines ,int Line_index , int Start_index ){
        if (allLines.get(Line_index) == null) {
            return null;            
        }
        RNode Root = new RNode();
        Root.left = get_node(allLines , Line_index, Start_index+1);
        if (allLines.get(Line_index).charAt(Start_index) != '|' && allLines.get(Line_index).charAt(Start_index) != ' ' && allLines.get(Line_index).charAt(Start_index) != '_')  {

            char Name = allLines.get(Line_index).charAt(Start_index);  
            int width = 0;
            int height = get_node_height(allLines , Line_index , Start_index);
            while (allLines.get(Line_index).charAt(Start_index) == '_') {
                width += 10;
                Start_index ++;                    
            }
            
        }
    }*/
    
    
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
