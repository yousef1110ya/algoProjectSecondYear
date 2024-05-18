import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TestArea {

   /* public static boolean canFormRectangle(List<Node> nodes) {
        int bigWidth = 0;
        int bigHeight = 0;
        List<Node> aside = new LinkedList<>();

        for (Node node : nodes) {
            if (bigHeight == 0) {
                bigHeight += node.length;
                bigWidth += node.width;
                continue;
            }

            if (node.length == bigHeight) {
                bigWidth += node.width;
            } else if (node.width == bigWidth) {
                bigHeight += node.length;
            } else {
                aside.add(node);
            }
        }

        Node smallRec = canFormSmallerRectangle(aside);
        if (smallRec == null) {
            System.out.println("The remaining rectangles cannot form a rectangle.");
            return false;
        }

        return smallRec.length == bigHeight || smallRec.width == bigWidth;
    }

    private static Node canFormSmallerRectangle(List<Node> aside) {
        int width = 0;
        int height = 0;

        for (Node node : aside) {
            width += node.width;
            height += node.length;
        }
        return new Node('g', width, height);
    }*/

    public static void main(String[] args) {
        
        List<Node> rectangles = List.of(
            new Node('R', 4, 4),
            new Node('e', 4, 3),
            new Node('t', 4, 4),
            new Node('q', 3, 4)
        );

        boolean canForm = canFormRectangle(rectangles);
        System.out.println("Can form a rectangle: " + canForm);
    }
  
   /* Stack<Character> stack = new Stack();//implemented a stack to add the values and then check them 
    public  Node importFromString(String text){
        for (int i =0; i<s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
    }   
        }
        */

    /**
     * @param Nodes
     * @return
     */
   /* public static void main(String[] args) {
        // Example usage
        List<Node> rectangles = List.of(
            new Node('R', 4, 4),
            new Node('e', 4, 4),
            new Node('t', 3, 4),
            new Node('q', 4, 4)
        );
        

        boolean canForm = canFormRectangle(rectangles);
        System.out.println("Can form a rectangle: " + canForm);
    }*/
    public static boolean canFormRectangle(List<Node> Nodes){
        int big_Width = 0;
        int big_Height = 0;
        int index;
        int available_Height,available_Width;
        List<Node> Aside = new LinkedList<>();
        for (Node node : Nodes) {
            if(big_Height == 0 ){
                System.out.println("made the width and height");
                big_Height += node.length;
                big_Width += node.width;
                continue;
            }

            if(node.length == big_Height){
                System.out.println("checkeing the length");
                System.out.println("the length we are adding to the code is  " + node.length);
                System.out.println("thw lengh we are comparin to  " + big_Height);
                big_Width += node.width;
                
            }else if(node.width == big_Width){
                System.out.println("the height is ckecked");
                big_Height += node.length;
                System.out.println("the total height now is" + big_Height);
            }else if(node.width != big_Width || node.length != big_Height){
                Aside.add(node);
                System.out.println("A node was added to the code");
            }
        }
        
        Node Small_Rec = new Node();
        if (!Aside.isEmpty()) {
            Small_Rec = Can_Form(Aside);
            Aside.removeAll(Aside);
            if (Small_Rec == null) {
                System.out.println("ths aside annot form a rectangle");
                return false;
            }
            if (Small_Rec.length == big_Height || Small_Rec.width == big_Width) {
                return true;
                
            }   
        }else if(Aside.isEmpty()){
            return true;
        }
        return false;
    }
    private static Node Can_Form(List<Node> aside) {
        int width =0;int height =0 ;
        if(canFormRectangle(aside)){
            for (Node node : aside) {
                width += node.width;
                height += node.length;
            }
            return new Node(aside.get(0).name, width , height);
        }
        return null;   
    }
    /*
    public boolean LessChecker(int all_width,int all_Length ,int index , List<Node> Nodes){
        int available_Width , available_Height;
        if(Nodes.get(index).width < all_width ){
            available_Height = Nodes.get(index).length;
            available_Width = all_width - Nodes.get(index).width;
        }
        if(Nodes.get(index).length < all_Length){
            available_Width = Nodes.get(index).width;
            available_Height = all_Length - Nodes.get(index).length;
        }
        for(int i=index ; i<Nodes.size();i++){
            
            if(Nodes.get(index).length == available_Height && Nodes.get(index).width == available_Width){
                return true;
            }

        }
        return false;
    }
    public static boolean canFormBigRectangle(List<Node> Nodes) {
        // لحتى نحنا نحسب المساحة الكلية لكل الصغار مع بعض
        int totalArea = 0;
        for (Node node : Nodes) {
            totalArea += node.length * node.width;
        }
    
        // نشوف اذا فينا نشكل مستطيل من هالمساحة
        for (int length = 1; length <= totalArea; length++) {
        //هون عم نزيد الحجم وحدة وحدة لنقدر نحسب اذا الطول بيتناسب مع المساحة
            if (totalArea % length == 0) {
        //اذا تحقق هاد الشرط معناها لقينا كول مناسب للمساحة بيشكل مستطيل 
                int width = totalArea / length;
                //حسبنا العرض من الططول
                boolean valid = true;
                //ينسمحلنا انو ننتقل للمرحلة اللي بعدها 
                //التحقق من اذا كان عنا شي مستطيل بينزع الترتيب
                for (Node node : Nodes) {
                    //مشينا على المستطيلات كلها
                    if (node.length > length || node.width > width) {
                    //اذا طلع عنا اي وحدة بتعمل خلل بالحالة تبعنا بيطلع من الكود
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    System.out.println("the biggest number of samll recs is");
                    System.out.println(Nodes.size());
                    System.out.println("Dimensions: " + length + " x " + width);
                    return true;
                    //لما رجعنا ترو معنا نحنا عملنا المستطيل الكبير صح
                }
            }
        }
    
        System.out.println("this test case you gave us is not valid you punk");
        return false;
    }

    */
}

