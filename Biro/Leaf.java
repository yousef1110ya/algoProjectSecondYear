package Biro;

public class Leaf {
    int length;
    int width;   
    int size;
    String name;//ما بعرف اي واحد هو الصح هوناو شو مستعملين  
    char name2;
    public Leaf (String name,int length,int width){
        this.length = length;
        this.name = name;     
        this.width = width;
        this.size = length*width;
    }
}
