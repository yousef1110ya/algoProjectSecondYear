import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameExample {
    public static void main(String[] args) {
        
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
        JFrame naryTreeFrame = new JFrame("N-ary Tree Display");
        // ... Add components to display the N-ary tree ...

        // Create the button to open the binary tree frame
        JButton openBinaryButton = new JButton("Show Binary Tree");
        openBinaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Convert N-ary tree to binary tree using Into_Binary method
                Node naryRoot = root;
                TreeNodee binaryRoot = Node.convertToBinaryTree(naryRoot);

                // Create the binary tree display frame
                JFrame binaryTreeFrame = new JFrame("Binary Tree Display");
                // ... Add components to display the binary tree ...

                binaryTreeFrame.pack();
                binaryTreeFrame.setVisible(true);
            }
        });

        // Add the button to the N-ary tree frame
        naryTreeFrame.add(openBinaryButton);
        naryTreeFrame.pack();
        naryTreeFrame.setVisible(true);
    }
}