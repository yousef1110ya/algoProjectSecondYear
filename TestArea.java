import java.util.List;
import java.util.Stack;

public class TestArea {
    Stack<Character> stack = new Stack();//implemented a stack to add the values and then check them 
    public  Node importFromString(String text){
        for (int i =0; i<s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
    }   
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
}
