import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Node {
    char Name;
    LinkedList<Node> children;
    public Node(char Name) {
        this.Name = Name;
        children = new LinkedList<>();
    }
    private static void prettyDisplay(TreeNodee node , int level){ 
        if(node == null) return; 
 
        prettyDisplay(node.right , level +1); 
 
        if(level != 0){ 
            for(int i=0 ; i<level-1 ; i++){ 
                System.out.print("|\t\t"); 
            } 
            System.out.println("|=====>" + node.data); 
        }else{ 
            System.out.println(node.data); 
        } 
        prettyDisplay(node.left, level+1); 
    }
    public void printTree() {
        printTreeHelper(this, 0);
    }

    private void printTreeHelper(Node node, int depth) {
        if (node == null) return;

        // Print indentation based on depth
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        // Print the current node's name
        System.out.println(node.Name);

        // Recursively print children
        for (Node child : node.children) {
            printTreeHelper(child, depth + 1);
        }
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
        TreeNodee btree = convertToBinaryTree(root);
        prettyDisplay(btree , 0);

        //writeStringToFile(treeText);
        
        /*Node ans =Importing_File(gettingAllNodes());
        ans.printTree();*/
    }
    //===============================================================================================
    //==========this is the fenish of the file creation =============================================
    //===============================================================================================
    
    public static LinkedList<Node> gettingAllNodes(){
        LinkedList<Node> all_nodes = new LinkedList<>();
        LinkedList<Node> awnser = new LinkedList<>();
          
        //all_nodes = replaceNodes(all_nodes.get(0).children, all_nodes);
        return all_nodes;
    }
    public static Node Text_Node(String input){
        Node ans = new Node(input.charAt(0));
        for(int i=4 ; i<input.length();i++){
            if (input.charAt(i) == ',' || input.charAt(i) == ' ' || input.charAt(i) == '-' || input.charAt(i) == '>')  {
               continue;
            }else{
                ans.children.add(new Node(input.charAt(i)));
            }
        }
        for (Node node : ans.children) {
            System.out.println("the children nodes are  " + node.Name);
        }
        return ans;
    }
    public static LinkedList<Node> replaceNodes(LinkedList<Node> childreno, LinkedList<Node> all) {
        for (Node node1 : childreno) {
            for (Node node2 : all) {
                if (node1.Name == node2.Name && !node2.children.isEmpty()) {
                    // Replace node1 with node2
                    childreno.remove(node1);
                    childreno.add(node2);
                    //break; // No need to continue searching
                }
            }
        }
        for (Node node : childreno) {
            if (!node.children.isEmpty()) {
                node.children = replaceNodes(node.children, all);
                return node.children;
            }
        }
        return childreno;
        
    }
    /*public static Node Get_the_Node(Node current_Node ,LinkedList<Node> all_nodes){
        for (Node node : current_Node.children) {
            for (Node node2 : all_nodes) {
                if (node.Name == node2.Name && !node2.children.isEmpty()) {
                    current_Node = Get_the_Node(node2, all_nodes) ;
                }
            }   
        }
        return current_Node;
    }*/
    public static Node Get_the_Node(Node current_Node, LinkedList<Node> all_nodes) {
        if (current_Node.children.isEmpty()) {
            return current_Node;
        }
        for (Node node : current_Node.children) {
            for (Node node2 : all_nodes) {
                if (node.Name == node2.Name ) {
                    // Recursively search for the node
                    current_Node = Get_the_Node(node2, all_nodes);
                }
            }
        }
        return current_Node;
    }
    
    public static Node Importing_File(LinkedList<Node> all_nodes){
        for (Node node : all_nodes) {
            System.out.println("======" + node.Name);
        }
        Node root = all_nodes.get(0);
        int index = 1;
        for (Node node : root.children) {
            for (Node node2 : all_nodes) {
                if (node.Name == node2.Name) {
                    root.children.set(index, node2);
                }
            }
        }
        return root;
    }
    //================================================================================================================
    //==============this code is for turning the Nary tree into a binary tree ========================================
    //================================================================================================================
    public static TreeNodee convertToBinaryTree(Node naryRoot) {
        if (naryRoot == null) {
            return null;
        }
        TreeNodee binaryRoot = new TreeNodee(naryRoot.Name);

        if (!naryRoot.children.isEmpty()) {
            binaryRoot.right = convertToBinaryTree(naryRoot.children.getFirst());
        }

        TreeNodee currentBinaryNode = binaryRoot.right;
        for (int i = 1; i < naryRoot.children.size(); i++) {
            currentBinaryNode.left = convertToBinaryTree(naryRoot.children.get(i));
            currentBinaryNode = currentBinaryNode.left;
        }

        return binaryRoot;
    }






}
