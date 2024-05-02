//this is only the second question not any more 
public class SecondQ {

    public static void main(String[] args) {
        String input = "(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))";
        Node result = splitIndex(input);
    }

    /**
     * @param input
     * @return
     */
    public static Node splitIndex(String input) {
        int firstOpenParen = input.indexOf('(');
        int firstCloseParen = input.indexOf(')');
        int secondOpenParen = input.indexOf('(', firstCloseParen);

        Node root;
        String left = input.substring(firstOpenParen + 1, firstCloseParen);
        if(left.indexOf("(") != -1){
            Node root.left.left = splitIndex(left);
        }
        root.left = 
        String Root = input.substring(firstCloseParen + 1, secondOpenParen);
        String right = input.substring(secondOpenParen + 1, input.length() - 1);

        // Recursively split the left and right substrings
        Node leftParts = splitIndex(left);
        Node rightParts = splitIndex(right);

        // Combine the root with the recursive results
        //String combinedRoot = root + leftParts[1] + rightParts[1];

        //return new String[]{leftParts[0], combinedRoot, rightParts[2]};
    }

    public static Node Creater(String input){
        if(input.indexOf("(") > 3){
            

        }
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