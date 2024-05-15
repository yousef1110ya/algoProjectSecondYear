public class RNode {
    char name;
    int height;
    int width;
    RNode left;
    RNode right;

    public RNode(){}
    public RNode(char name,int height,int width){
        this.name=name;
        this.height=height;
        this.width=width;
        left=right=null;
    }
    public RNode(char name){
        this.name=name;
    }
}
