import java.util.Stack;

public class StringFinal {
    public boolean isRoot(char c){
        if(c == '|' || c== '-') return true;
        else return false;
    }

    
    /**
     * @param input
     * @return
     */
    public Node FullCase(String input){ // case (-----) + (------)
        input = input.trim();
        int StartLeft = 0;
        int EndLeft = 0;
        int RootIndex = 0;
        int StartRight = 0;
        Stack<Character> temp  = new Stack<>();
        for (int i=0 ; i<input.length();i++){
            char c = input.charAt(i);
            char next = input.charAt(i+1);
            if(c =='('){temp.add(c);}
            else if (c == ')' && !temp.isEmpty() && isRoot(next)){
                EndLeft = i;
                RootIndex = i+1;
                StartRight = i+2;
                temp.pop();
                break;
            }

        }
        Node root =  new Node(input.charAt(RootIndex));
        String left = input.substring(StartLeft+1 , EndLeft);
        String right = input.substring(RootIndex+1 , input.length());
        root.left = SubCase(left);
        root.right = SubCase(right);

        return root;


    }
    public Node SubCase(String input){//testing all other cases
        if(input.charAt(1) == '[' && input.indexOf("(") != -1 ){ // val[]+(------)
            return secCase(input);
        }else if(input.charAt(0) == '(' && input.charAt(input.length()) == ']'){//(-------)+val[]
            return thirdCase(input);
        }else if (input.indexOf("(") == -1){//va;[]+val[]
            return fourthCase(input);
        }else if (input.indexOf("(") == 0 && input.charAt(input.length()) == ')'){//(-------)+(--------)
            return FullCase(input);
        }else{
            return null;
        }
    }


    private Node fourthCase(String input) {
        int RootIndex = 0;
        if(input.indexOf("-") == -1)
        RootIndex = input.indexOf("|");
        else if(input.indexOf("|") == -1){
        RootIndex = input.indexOf("-");
        }
        Node root = new Node(input.charAt(RootIndex));
        root.left = createNode(input.substring(0, RootIndex));
        root.right = createNode(input.substring(RootIndex, input.length()));
        return root;
    }


    private Node thirdCase(String input) {
        int RootIndex = 0;
        for(int i = input.length();i>0 ; i--){
            if (input.charAt(i) == '|' || input.charAt(i) == '-' ) {
                RootIndex = i;
                break;
                
            }
        }
        Node root = new Node(input.charAt(RootIndex));
        root.left = createNode(input.substring(RootIndex+1, input.length()));
        root.right= SubCase(input.substring(0, RootIndex));
        return root;
    }


    private Node secCase(String input) {// case val[] + (--------)
        // TODO Auto-generated method stub
        int RootIndex = input.indexOf(']')+1;
        Node root = new Node(input.charAt(RootIndex));
        root.left = createNode(input.substring(0,RootIndex));
        root.right = SubCase(input.substring(RootIndex , input.length()));
        return root;
    }
    public Node createNode(String substring) {
        // Extract name, length, and height from the substring
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