package Algo1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Rectangle {
    public static int counter;

    public static int countUppercaseLetters(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean containSameCapitalLetters(String str1, String str2) {
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
        if (nodes.size() < 1) return false;

        int originalSize = nodes.size();
        HashSet<Node> combinations = new HashSet<>();

        for (int i = 0; i <=originalSize ; i++) {
            int currentSize = nodes.size();

            for (int q = 0; q < currentSize; q++) {
                for (int w = q + 1; w < currentSize; w++) {
                    if (!nodes.get(q).equals(nodes.get(w))) {
                        if (nodes.get(q).height == nodes.get(w).height && !containSameCapitalLetters(nodes.get(q).name, nodes.get(w).name)) {
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