package Algo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



public class Algorithm extends JFrame {
static Node root;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("the first");
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        JLabel label2 = new JLabel();
        label2.setText("enter the text:");
        label2.setForeground(new Color(0xFFFfff));
        label2.setBounds(600, 70, 150, 50);
        Font font4 = new Font("Monotype Corsiva", Font.BOLD, 21);
        label2.setFont(font4);
        frame.add(label2);

        JLabel label3 = new JLabel();
        label3.setText("click convert to convert the tree into a text");
        label3.setForeground(new Color(0x416D19));
        label3.setBounds(500, 325, 450, 50);
        Font font5 = new Font("Monotype Corsiva", Font.BOLD, 15);
        label3.setFont(font5);
        frame.add(label3);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(300, 200));
        textArea.setVisible(true);
        textArea.setBounds(600, 130, 300, 100);
        textArea.setBackground(new Color(0x416D19));
        textArea.setForeground(new Color(0xFFFfff));
        textArea.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
        frame.add(textArea);

        ImageIcon image1 = new ImageIcon("bb.jpg");
        JLabel label4 = new JLabel();
        label4.setBounds(900, 520, 100, 140);
        label4.setForeground(new Color(0xFEC5BB));
        Font font6 = new Font("Lucida Sans", Font.BOLD, 15);
        label4.setFont(font6);
        label4.setIcon(image1);
        frame.add(label4);



        JButton b1 = new JButton();
        b1.setText("submit");
        b1.setBounds(800, 270, 100, 25);
        b1.setForeground(new Color(0xFFFfff));
        b1.setBackground(new Color(0X9BCF53));
        b1.setFocusable(false);
        b1.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        frame.add(b1);

        JButton b2 = new JButton();
        b2.setText("convert");
        b2.setBounds(800, 300, 100, 25);
        b2.setForeground(new Color(0xFFFfff));
        b2.setBackground(new Color(0X9BCF53));
        b2.setFocusable(false);
        b2.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        b2.setEnabled(false);
        frame.add(b2);
b2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String s=stringifyTree(root);
        if(s.charAt(0)=='('){
            s=s.substring(1);
            s=s.substring(0,s.length()-1);
        }
        label3.setText(s);


    }
});

        JButton b3 = new JButton();
        b3.setText("Forth");
        b3.setBounds(800, 370, 100, 25);
        b3.setForeground(new Color(0xFFFfff));
        b3.setBackground(new Color(0X9BCF53));
        b3.setFocusable(false);
        b3.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        b3.setEnabled(false);
        frame.add(b3);

        JLabel labelForth = new JLabel();
        labelForth.setText("");
        labelForth.setForeground(new Color(0x416D19));
        labelForth.setBounds(550, 355, 450, 50);
        Font fontForth = new Font("Monotype Corsiva", Font.BOLD, 15);
        labelForth.setFont(fontForth);
        frame.add(labelForth);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                labelForth.setText("Calculating...");
                ArrayList<Node> nodes = (ArrayList<Node>) root.getNodesWithHeightAndWidth();
                boolean canFormRectngle= rectangleChecker.canForm(nodes);
                labelForth.setText(String.valueOf(canFormRectngle));
                allGroups.clear();
            }
        });



        JButton b4 = new JButton();
        b4.setText("Fifth");
        b4.setBounds(800, 420, 100, 25);
        b4.setForeground(new Color(0xFFFfff));
        b4.setBackground(new Color(0X9BCF53));
        b4.setFocusable(false);
        b4.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        b4.setEnabled(false);
        frame.add(b4);

        JLabel labelFifth = new JLabel();
        labelFifth.setText("");
        labelFifth.setForeground(new Color(0x416D19));
        labelFifth.setBounds(550, 405, 450, 50);
        Font fontFifth = new Font("Monotype Corsiva", Font.BOLD, 15);
        labelForth.setFont(fontFifth);
        frame.add(labelFifth);

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                labelFifth.setText("Calculating...");
                ArrayList<Node> nodes = (ArrayList<Node>) root.getNodesWithHeightAndWidth();
                labelFifth.setText(String.valueOf(howMany(nodes)));
                allGroups.clear();
            }
        });

        frame.getContentPane().setBackground(new Color(0X9BCF53));
        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                String inputText = textArea.getText();
                Map<String, Pair<Integer, Integer>> L_and_W = new HashMap<>();

                String before = inputText;
                String after = "";
                String length = "";
                int L;
                String width = "";
                int W;
                char c = ' ';
                for (int i = 0; i < before.length(); i++) {
                    if (before.charAt(i) == '[') {
                        c = before.charAt(i - 1);
                        length = "";
                        width = "";
                        i++;
                        while (before.charAt(i) != ',') {
                            length += before.charAt(i);
                            i++;
                        }
                        i++;
                        while (before.charAt(i) != ']') {
                            width += before.charAt(i);
                            i++;
                        }
                        i++;
                        L = Integer.parseInt(length);
                        W = Integer.parseInt(width);
                        L_and_W.put(String.valueOf(c), new Pair<>(L, W));
                    }
                    after += before.charAt(i);
                }

                after = after.replace(" ", "");

                root = findRoot(after);
                fillNode(root, L_and_W);

                BinaryTreePanel tree = new BinaryTreePanel(root);
                tree.setBounds(0, 0, 500, 650);
                tree.setBackground(new Color(0x416D19));
                frame.add(tree);
                frame.repaint(); // Repaint the frame to reflect changes
            }
        });
    }


    public static Node findRoot(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        int balance = 0;
        int minBalance = Integer.MAX_VALUE;
        int minIndex = -1;
        char minChar = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            } else if ((c == '-' || c == '|') && balance <= minBalance) {
                minBalance = balance;
                minIndex = i;
                minChar = c;
            }
        }
        if (minIndex != -1) {
            Node node = new Node(minChar);
            String left = s.substring(0, minIndex);

            if (left.charAt(0) == '(') {
                left = left.substring(1, left.length() - 1);
            }

            String right = s.substring(minIndex + 1);

            if (right.charAt(0) == '(') {
                right = right.substring(1, right.length() - 1);
            }
            node.left = findRoot(left);
            node.right = findRoot(right);
            return node;
        }
        char c = s.charAt(0);
        if (Character.isLetter(c) || c == '-' || c == '|') {
            return new Node(c);
        }
        return null;
    }

    static void fillNode(Node node, Map<String, Pair<Integer, Integer>> map) {
        if (node == null) {
            return;
        }

        if (map.containsKey(node.name)) {
            Pair<Integer, Integer> pair = map.get(node.name);
            node.height = pair.length;
            node.width = pair.width;
        }

        fillNode(node.left, map);
        fillNode(node.right, map);
    }

//Export:::
    static String stringifyTree(Node node) {
        if (!node.name.equals("|") && !node.name.equals("-")) {
            return node.name + "[" + node.height + "," + node.width + "]";
        }

        String leftStr = node.left != null ? stringifyTree(node.left) : "";
        String rightStr = node.right != null ? stringifyTree(node.right) : "";

        if (Objects.equals(node.name, "|") || Objects.equals(node.name, "-"))
            return "(" + leftStr + node.name + rightStr + ")";
        return leftStr + " " + node.name + " " + rightStr;
    }

//Tanner Methods:
private static final Rectangle rectangleChecker = new Rectangle();
    private static  ArrayList<ArrayList<Node>> allGroups = new ArrayList<>();

    private static int howMany(ArrayList<Node> subgroup) {
        generateGroups(subgroup, new ArrayList<>(), 0);
        int rectangleCount = 0;
        for (ArrayList<Node> group : allGroups) {
            if (rectangleChecker.canForm(group)) {
                rectangleCount++;
//                for (Node n :group){
//                    System.out.print(n.name+",");
//                    //System.out.println();
//                }
//                System.out.println();
            }

        }
        final int count = rectangleCount;
        rectangleCount=0;
        return count;
    }

    private static void generateGroups(ArrayList<Node> set, ArrayList<Node> currentGroup, int index) {
        if (index == set.size()) {
            allGroups.add(new ArrayList<>(currentGroup));
            return;
        }
        currentGroup.add(set.get(index));
        generateGroups(set, currentGroup, index + 1);
        currentGroup.remove(currentGroup.size() - 1);
        generateGroups(set, currentGroup, index + 1);
    }

//to calculate the height and width of every root and fill it in the node
    static void fillCalculations(Node root){
        if(root==null)
            return;
        if(Objects.equals(root.name, "-")){
            root.calculateDimensions();
        }
        if(Objects.equals(root.name, "|")){
            root.calculateDimensions();
        }
        fillCalculations(root.left);
        fillCalculations(root.right);
    }

    //to rotate the rectangle by swapping the height and width of the node
    //Note: I need to call the fillCalculations method before calling this method so i can fill the root's height and width
    static void rotatingRec(Node root) {
        if (root == null) {
            return;
        }
        if (root.height > 0 && root.width > 0) {
            int temp = root.height;
            root.height = root.width;
            root.width = temp;
        }
        rotatingRec(root.left);
        rotatingRec(root.right);
    }
}