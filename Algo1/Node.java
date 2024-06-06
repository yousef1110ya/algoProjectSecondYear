package Algo1;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    int height;
    int width;
    int area;
    Node left;
    Node right;

    public Node(){}
    public Node(String name,int height,int width){
        this.name=name;
        this.height=height;
        this.width=width;
        this.area = height * width;
        left=right=null;
    }
    public Node(char name,int height,int width){
        this.name= String.valueOf(name);
        this.height=height;
        this.width=width;
        this.area = height * width;
        left=right=null;
    }
    public Node(String name){
        this.name=name;
    }
    public Node(char name){
        this.name= String.valueOf(name);
    }




    public List<Node> getNodesWithHeightAndWidth() {
        List<Node> nodes = new ArrayList<>();
        dfs(this, nodes);
        return nodes;
    }

    private void dfs(Node node, List<Node> nodes) {
        if (node == null) {
            return;
        }

        if (!node.name.equals("|") && !node.name.equals("-")) {
            nodes.add(node);
        }

        dfs(node.left, nodes);
        dfs(node.right, nodes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Node node = (Node) obj;

        if (width != node.width) return false;
        if (height != node.height) return false;
        return name != null ? name.equals(node.name) : node.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    public void calculateDimensions() {
        if (this.name.equals("|")) {
            if (this.left != null) this.left.calculateDimensions();
            if (this.right != null) this.right.calculateDimensions();
            this.height = (this.left != null ? this.left.height : 0) + (this.right != null ? this.right.height : 0);
            this.width = Math.max(this.left != null ? this.left.width : 0, this.right != null ? this.right.width : 0);
        } else if (this.name.equals("-")) {
            if (this.left != null) this.left.calculateDimensions();
            if (this.right != null) this.right.calculateDimensions();
            this.height = Math.max(this.left != null ? this.left.height : 0, this.right != null ? this.right.height : 0);
            this.width = (this.left != null ? this.left.width : 0) + (this.right != null ? this.right.width : 0);
        }
    }
}
