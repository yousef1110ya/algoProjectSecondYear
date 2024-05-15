import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSplitter {
    public static void main(String[] args) {
        String str = "(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))";
        Node tree = FullCase(str);
        prettyDisplay(tree);
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
        root.left = SubCase(left);
        root.right = SubCase(right);

        return root;
    }

    public static Node SubCase(String input) {
        Stack<Node> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(new Node(c));
            } else if (c == '|') {
                if (stack.size() < 2) {
                    System.out.println("Invalid expression: Not enough operands for '|'");
                    return null;
                }
                Node right = stack.pop();
                Node left = stack.pop();
                Node orNode = new Node('|');
                orNode.left = left;
                orNode.right = right;
                stack.push(orNode);
            } else if (c == '-') {
                if (stack.size() < 2) {
                    System.out.println("Invalid expression: Not enough operands for '-'");
                    return null;
                }
                Node right = stack.pop();
                Node left = stack.pop();
                Node minusNode = new Node('-');
                minusNode.left = left;
                minusNode.right = right;
                stack.push(minusNode);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Invalid expression: Empty stack");
            return null;
        }
        return stack.pop();
    }

    public static void prettyDisplay(Node result) {
        prettyDisplay(result, 0);
    }

    private static void prettyDisplay(Node node, int level) {
        if (node == null) return;

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|=====>" + node.name);
        } else {
            System.out.println(node.name);
        }
        prettyDisplay(node.left, level + 1);
    }
}

