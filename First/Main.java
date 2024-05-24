package First;

import java.util.ArrayList;

public class Main {
    private static final Rectangle rectangleChecker = new Rectangle();
    private static  ArrayList<ArrayList<Node>> allGroups = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node("A", 20, 10));
        nodes.add(new Node("B", 20, 10));
        nodes.add(new Node("C", 30, 10));
        nodes.add(new Node("D", 30, 50));
        nodes.add(new Node("E", 40, 30));
        nodes.add(new Node("F", 40, 20));

        System.out.println();
        System.out.println(howMany(nodes));
        
        boolean canFormRectangle = rectangleChecker.canForm(nodes);
        System.out.println(canFormRectangle);
    }

    private static int howMany(ArrayList<Node> subgroup) {
        generateGroups(subgroup, new ArrayList<>(), 0);
        int rectangleCount = 0;
        for (ArrayList<Node> group : allGroups) {
            if (rectangleChecker.canForm(group)) {
                rectangleCount++;
//                for (Node n :group){
//                    System.out.print(n.name+",");
//                    //System.out.println();
//                }
//                System.out.println();
            }
        }
        return rectangleCount;
    }

    private static void generateGroups(ArrayList<Node> set, ArrayList<Node> currentGroup, int index) {
        if (index == set.size()) {
            allGroups.add(new ArrayList<>(currentGroup));
            return;
        }
        currentGroup.add(set.get(index));
        generateGroups(set, currentGroup, index + 1);
        currentGroup.remove(currentGroup.size() - 1);
        generateGroups(set, currentGroup, index + 1);
    }
}
