package Algo1;

import java.util.List;

public class FileWriting {
    
    public Node EnterNode(Node awnser){
        return awnser;
    }

    public int[][] filling_array(Node to_file){
       Node temp = to_file;
       temp.calculateDimensions();
       int rows = temp.height;
       int columns = temp.width;
       int[][] File_char = new int[rows][columns];
       return File_char;
    }

    public String File_shape(Node root, Node parent){
        String ans = null;
        if (root == null) {
            return ans;
            
        }
        File_shape(root.left , root);
        ans = make_space(root);
    }
    public void test(List<Node> all_tree , int total_width , int total_height){
        int index =0;
        int[][] File_char = new int[total_height][total_width];
        int current_width =0;
        int current_height = 1;
        int temp_height =0;
        int temp_width =0;
        for (int i = 0; i < total_width; i++) {
            File_char[0][i] = '_';
        }
        while (all_tree.get(index) != null) {
            index ++;
            if (index > 0 && all_tree.get(index) != null) {
                if (all_tree.get(index).name == "|" ) {
                    index ++;
                    while (all_tree.get(index) != null && all_tree.get(index).name != "_") {
                        File_char[current_height][current_width] = (char) all_tree.get(index).name;
                        for (int i = current_height + 1; i < all_tree.get(index).height -1 ; i++) {
                            for (int j = current_width + 1; j < all_tree.get(index).width -1 ; j++) {
                                File_char[i][j] = ' ';
                            }
                            
                        }
                        current_height += all_tree.get(index).height;
                        current_width += all_tree.get(index).width; 
                        index ++;
                    }
                    
                }else if (all_tree.get(index).name == "_") {
                    
                }
            }else{
                File_char[current_height][current_width] = (char) all_tree.get(index).name;
                for (int i = current_height + 1; i < all_tree.get(index).height -1 ; i++) {
                    for (int j = current_width + 1; j < all_tree.get(index).width -1 ; j++) {
                        File_char[i][j] = ' ';
                    }
                    
                }
                if (all_tree.get(index + 1 ).name == "_") {
                    current_height += all_tree.get(index).height;
                    temp_width += all_tree.get(index).width;
                }else if (all_tree.get(index + 1 ).name == "|") {
                    temp_height += all_tree.get(index).height;
                    current_width += all_tree.get(index).width;   
                }
            }

        }
    }
    

}
