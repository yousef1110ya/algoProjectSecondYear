//this is only the second question not any more 

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondQ {
    public static void prettyDisplay(Node result){ 
        prettyDisplay(result , 0); 
    } 
    private static void prettyDisplay(Node node , int level){ 
        if(node == null) return; 
 
        prettyDisplay(node.right , level +1); 
 
        if(level != 0){ 
            for(int i=0 ; i<level-1 ; i++){ 
                System.out.print("|\t\t"); 
            } 
            System.out.println("|=====>" + node.name); 
        }else{ 
            System.out.println(node.name); 
        } 
        prettyDisplay(node.left, level+1); 
    }

    public static void main(String[] args) {
        String input = "(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))";
        Node result = splitIndex(input);
        prettyDisplay(result);
    }

    /**
     * @param input
     * @return
     */
    public static Node splitIndex(String input) {
        int firstOpenParen = input.indexOf('(');
        //int firstOpenParen = 0;
        int firstCloseParen = input.indexOf(')');
        int secondOpenParen = input.indexOf('(', firstCloseParen);

        Node root = new Node();
        String left = input.substring(firstOpenParen + 1, firstCloseParen);
        root.left = Creater(left);
        String Root = input.substring(firstCloseParen + 1, secondOpenParen);
        root = Creater(Root);
        String right = input.substring(secondOpenParen + 1, input.length() - 1);
        root.right = Creater(right);
        // Recursively split the left and right substrings
        //Node leftParts = splitIndex(left);
        //Node rightParts = splitIndex(right);

        // Combine the root with the recursive results
        //String combinedRoot = root + leftParts[1] + rightParts[1];
        return root;
        //return new String[]{leftParts[0], combinedRoot, rightParts[2]};
    }

    public static Node Creater(String input){
        if (input.indexOf("(") != -1){
            splitIndex(input);
        }else{
            Pattern pattern = Pattern.compile("([A-Z])\\[(\\d+),(\\d+)\\]");
            Matcher matcher = pattern.matcher(input);

            
                String character = matcher.group(1);
                int width = Integer.parseInt(matcher.group(2));
                int height = Integer.parseInt(matcher.group(3));
            
            // Create the separate string for each character
                String result = character + " [" + width + "," + height + "]";
                System.out.println(result);
                return new Node(character, width, height);
        
    }
        return null;
    }

    public static Node createNode(String substring) {
        // Extract name, length, and height from the substring
        int openBracketIndex = substring.indexOf('[');
        int closeBracketIndex = substring.indexOf(']');
        String name = substring.substring(0, openBracketIndex);
        String dimensions = substring.substring(openBracketIndex + 1, closeBracketIndex);
        String[] parts = dimensions.split(",");
        int length = Integer.parseInt(parts[0].trim());
        int height = Integer.parseInt(parts[1].trim());

        return new Node(name, length, height);
    }
    
}