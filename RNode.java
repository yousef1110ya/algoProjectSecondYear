public class RNode {
    char name;
    int length;
    int width;
    RNode left;
    RNode right;

    public RNode(){}
    public RNode(char name,int length,int width){
        this.name=name;
        this.length=length;
        this.width=width;
        left=right=null;
    }
    public RNode(char name){
        this.name=name;
    }
    /*public int sub_width(RNode root){
        int width = 0;
        int height =0;
        if (root.name == '|') {
            width += sub_width(root.left);
            width += sub_width(root.right);
        }
        else if (root.name == '_') {
            return 0;
        }
    }*/
}
