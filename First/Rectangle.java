package First;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Rectangle {
    public static int counter;

    public static int countUppercaseLetters(String str) {
        //هون هاد التابع بيشوف عدد المستطيلات الكلي من السترينغ المطلوب
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                //هاد الشرط هو اذا كان الحرف اللي نحنا عندو هو حرف كبير معناها زيد العداد
                count++;
            }
        }
        return count;
    }

    public static boolean containSameCapitalLetters(String str1, String str2) {
        //هاد التابع بيشوف اذا كان النصين فيهم نفس النودات المطلوبة
        String upperCaseStr1 = str1.toUpperCase();
        String upperCaseStr2 = str2.toUpperCase();

        for (int i = 0; i < upperCaseStr1.length(); i++) {
            char ch = upperCaseStr1.charAt(i);
            if (Character.isUpperCase(ch) && upperCaseStr2.indexOf(ch) != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean canForm(ArrayList<Node> nodes) {
        //هاد هو التابع اللي بيشوف اذا اللي دخلناهم بيشكلو مستطيل
        //واستخدمنا هون الليست بالادخال والتعامل لانو فيها الاندكس ومفاهيم تانية افضل شوي من المصفوفة
        if (nodes.size() < 1) return false;//اذا فاضية رجع لاء 

        int originalSize = nodes.size();
        //عدد العناصر الكلي اللي عم ندخلو
        HashSet<Node> combinations = new HashSet<>();
        //هي الهاش سيت استخدمناها كرمال نشوف شو الحالات اللي نحنا عم نختبرها او الحالات اللي نحنا اصلا اختبرناها 

        for (int i = 0; i <=originalSize ; i++) {
            //حلقة لنمشي على كافة العناصر 

            int currentSize = nodes.size();

            for (int q = 0; q < currentSize; q++) {
                //عم نعيدها كرمال ما نمشي بالعودية 
                //بحيث نكون مشينا على كلشي وارجعنا اتأكدنا من كلشي مطلوب مننا وهيك
                for (int w = q + 1/*هون بلشنا من بعد الاولى */; w < currentSize; w++) {
                    //هون مشينا من بعد الحالة اللي بلشنا فيها 
                    if (!nodes.get(q).equals(nodes.get(w))) {
                        //هون شفنا اذا كان q != w
                        //يعني العنصرين اللي نحنا عم نشوفهم مختلفين
                        if (nodes.get(q).height == nodes.get(w).height && !containSameCapitalLetters(nodes.get(q).name, nodes.get(w).name)) {//هاد الشرط للتعامل مع موضوع الاسم اذا كان سترينغ ولا تشار
                            combinations.add(new Node(
                                    "(" + nodes.get(q).name + "-" + nodes.get(w).name + ")",
                                    nodes.get(q).height,
                                    nodes.get(q).width + nodes.get(w).width
                            ));
                        }
                    }
                }
            }

            for (int q = 0; q < currentSize; q++) {
                for (int w = q + 1; w < currentSize; w++) {
                    if (!nodes.get(q).equals(nodes.get(w))) {
                        if (nodes.get(q).width == nodes.get(w).width && !containSameCapitalLetters(nodes.get(q).name, nodes.get(w).name)) {
                            combinations.add(new Node(
                                    "(" + nodes.get(q).name + "|" + nodes.get(w).name + ")",
                                    nodes.get(q).height + nodes.get(w).height,
                                    nodes.get(q).width
                            ));
                        }
                    }
                }
            }

            nodes.addAll(combinations);
            combinations.clear();
            //--------------------------------------------------
            // Use a HashSet to remove duplicates
            Set<Node> set = new HashSet<>(nodes);

            // Clear the list and add all elements back from the set
           nodes.clear();
            nodes.addAll(set);
            //-------------------------------------------------
        }

        counter = nodes.size();

        for (Node node : nodes) {
            if (countUppercaseLetters(node.name) == originalSize) {
                //System.out.println(node.name);
                return true;
            }
        }

        return false;
    }
}
