package Algo1;
import javax.swing.*;
import java.awt.*;
public class BinaryTreePanel extends JPanel{
    private Node root;

    public BinaryTreePanel(Node root) {
        this.root = root;

    }
    public BinaryTreePanel(){}

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawTree(g, root, getWidth() / 2, 30, getWidth() / 4, 40);


    }

    private void drawTree(Graphics g, Node node, int x, int y, int xOffset, int yOffset) {

        if (node == null) {
            return;
        }


        g.drawOval(x - 15, y - 15, 30, 30);

        g.drawString(String.valueOf(node.name), x - 5, y + 5);


        if (node.left != null) {
            g.drawLine(x - 10, y + 10, x - xOffset + 10, y + yOffset - 10);
            drawTree(g, node.left, x - xOffset, y + yOffset, xOffset / 2, yOffset);
        }


        if (node.right != null) {
            g.drawLine(x + 10, y + 10, x + xOffset - 10, y + yOffset - 10);
            drawTree(g, node.right, x + xOffset, y + yOffset, xOffset / 2, yOffset);
        }


    }
}