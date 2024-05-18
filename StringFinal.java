import java.util.Stack;

public class StringFinal {
    //==================================================
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
    //==================================================
    public static void main(String[] args) {
        String str = "(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))";
        Node tree = FullCase(str);
        prettyDisplay(tree);
        if(tree.left.left != null){
            System.out.println("the right is empty");
        }
    }
    
    public static boolean isRoot(char c) {
        return c == '|' || c == '-';
    }
    
    public static Node FullCase(String ans) {
        String input = ans.trim();
        int EndLeft = input.indexOf(')');
    
        if (EndLeft == -1) {
            System.out.println("No closing parenthesis found.");
            return null;
        }
    
        int RootIndex = EndLeft + 1;
        int StartRight = EndLeft + 2;
    
        Node root = new Node(input.charAt(RootIndex));
        String left = input.substring(1, EndLeft);
        String right = input.substring(StartRight, input.length() - 1);
        
        root.right = SubCase(right);
        root.left = SubCase(left);

        return root;
    }
    
    public static Node SubCase(String input) {
        if (input.charAt(1) == '[' && input.indexOf("(") != -1) {
            return secCase(input);
        } else if (input.charAt(0) == '(' && input.charAt(input.length() - 1) == ']') {
            return thirdCase(input);
        } else if (input.indexOf("(") == -1) {
            return fourthCase(input);
        } else if (input.indexOf("(") == 0 && input.charAt(input.length() - 1) == ')') {
            return FullCase(input);
        } else {
            return null;
        }
    }
    
    private static Node fourthCase(String input) {
        int RootIndex;
        if (input.indexOf("-") == -1) {
            RootIndex = input.indexOf("|");
        } else if (input.indexOf("|") == -1) {
            RootIndex = input.indexOf("-");
        } else {
            return null; // Invalid expression
        }
    
        Node root = new Node(input.charAt(RootIndex));
        root.right = createNode(input.substring(RootIndex, input.length() - 1));
        root.left = createNode(input.substring(0, RootIndex));
        
        return root;
    }
    
    private static Node thirdCase(String input) {
        int RootIndex = 0;
        for (int i = input.length() - 1; i > 0; i--) {
            if (input.charAt(i) == '|' || input.charAt(i) == '-') {
                RootIndex = i;
                break;
            }
        }
        Node root = new Node(input.charAt(RootIndex));
        root.right = createNode(input.substring(RootIndex + 1, input.length() - 1));
        root.left = SubCase(input.substring(0, RootIndex));
        return root;
    }
    private static Node secCase(String input) {
        int RootIndex = input.indexOf(']') + 1;
        Node root = new Node(input.charAt(RootIndex));
        root.left = createNode(input.substring(0,RootIndex));
        root.right = SubCase(input.substring(RootIndex , input.length()-1));
        return root;
    }
    public static Node createNode(String substring) {
        int openBracketIndex = substring.indexOf('[');
        int closeBracketIndex = substring.indexOf(']');
        char name = substring.charAt(0);
        String dimensions = substring.substring(openBracketIndex + 1, closeBracketIndex);
        String[] parts = dimensions.split(",");
        int length = Integer.parseInt(parts[0].trim());
        int width = Integer.parseInt(parts[1].trim());
        return new Node(name,width,length);
    }


    
}

