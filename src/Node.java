import java.util.ArrayList;

public class Node implements Comparable<Node> {

    //Instance variables
    public int level;
    public ArrayList<Item> items;
    public float bound;
    public int profit;
    public int weight;

    public Node() {
        int level;
        int profit;
        int weight;
        float bound;
    }


    public int compareTo(Node n) {
        if (this.bound > n.bound)
            return 1;
        else if (this.bound < n.bound)
            return -1;
        return 0;
    }

}
