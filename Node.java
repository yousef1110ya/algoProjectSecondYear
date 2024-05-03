public class Node {
    int length;
    int width;
    Node left;
    Node right;
    char name;


    public Node(char name , int width , int length){
        this.name = name;
        this.width = width;
        this.length = length;
        
    }
    public Node(char name){
        this.name = name;
        this.width = 0;
        this.length = 0;
    }


    public Node() {
        //TODO Auto-generated constructor stub
    }
}
