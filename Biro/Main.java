package Biro;

import java.util.ArrayList;

public class Main {
     private static final Rectangle rectangleChecker = new Rectangle();
    private static  ArrayList<ArrayList<Leaf>> allGroups = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Leaf> nodes = new ArrayList<>();
        nodes.add(new Leaf("A", 20, 10));
        nodes.add(new Leaf("B", 20, 10));
        nodes.add(new Leaf("C", 30, 10));
        nodes.add(new Leaf("D", 30, 50));
        nodes.add(new Leaf("E", 40, 30));
        nodes.add(new Leaf("F", 40, 20));

        System.out.println();
        System.out.println(howMany(nodes));
        
        boolean canFormRectangle = rectangleChecker.canForm(nodes);
        System.out.println(canFormRectangle);
    }

    private static int howMany(ArrayList<Leaf> subgroup) {
        generateGroups(subgroup, new ArrayList<>(), 0);
        int rectangleCount = 0;
        for (ArrayList<Leaf> group : allGroups) {
            if (rectangleChecker.canForm(group)) {
                rectangleCount++;
                for (Leaf n :group){
                    System.out.println(n.name+",");
                    //System.out.println("/t");
                }
                System.out.println();
            }
        }
        return rectangleCount;
    }

    private static void generateGroups(ArrayList<Leaf> set, ArrayList<Leaf> currentGroup, int index) {
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
