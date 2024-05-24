package First;

public class Node {
    String name;
    int width;
    int height;
    int area;

    Node(String name, int height, int width) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.area = height * width;//هون نحنا حددنا المساحة لنتعامل معها
    }

    @Override
    public boolean equals(Object obj) {//تابع ليشوف اذا كان العنصر اللي نحنا مدخلينو هو نفسو ولا غير 
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Node node = (Node) obj;

        if (width != node.width) return false;
        if (height != node.height) return false;
        return name != null ? name.equals(node.name) : node.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }
}