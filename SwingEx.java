import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class SwingEx {
    public static void main(String[] args) {
        JFrame frame = new JFrame("N-ary Tree Frame");
        //creating the N-ary Tree and some values for it
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
        //====================================================================================
        //==========adding the values to the tree=============================================
        //====================================================================================
        DefaultMutableTreeNode jRoot = new DefaultMutableTreeNode("Root");
        convertToJTree(root, jRoot);

        JTree tree = new JTree(jRoot);
        /*DefaultMutableTreeNode Proot = new DefaultMutableTreeNode(root.Name);
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("Parent 1");
        DefaultMutableTreeNode child1_1 = new DefaultMutableTreeNode("Child 1.1");
        DefaultMutableTreeNode child1_2 = new DefaultMutableTreeNode("Child 1.2");
        parent1.add(child1_1);
        parent1.add(child1_2);
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("Parent 2");
        DefaultMutableTreeNode child2_1 = new DefaultMutableTreeNode("Child 2.1");
        DefaultMutableTreeNode child2_2 = new DefaultMutableTreeNode("Child 2.2");
        parent2.add(child2_1);
        parent2.add(child2_2);
        Proot.add(parent1);
        Proot.add(parent2);
        JTree tree = new JTree(Proot);*/
        JButton button = new JButton("Click Me");

        // Create a panel to hold the tree and button
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 400));
        //panel.add(new JScrollPane(tree)); // Add the tree with a scroll pane
        panel.add(tree);
        panel.add(button); // Add the button

        frame.add(panel);
        
        //frame.add(new JScrollPane(tree));
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    static void convertToJTree(Node node, DefaultMutableTreeNode jNode) {
        jNode.setUserObject(node.Name); // Set the value as the user object

        for (Node child : node.children) {
            DefaultMutableTreeNode jChild = new DefaultMutableTreeNode();
            jNode.add(jChild);
            convertToJTree(child, jChild); // Recursively convert children
        }
    }
}