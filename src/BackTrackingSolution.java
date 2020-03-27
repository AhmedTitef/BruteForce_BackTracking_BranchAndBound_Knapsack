import java.util.ArrayList;
import java.util.Collections;

class BacktrackingKnapsack {
    public static String[] bestset = new String[]{};
    public static String[] include = new String[100];


    public static int nodesChecked = 0;

    public static int maxprofit = 0;


    public static void knapsack(int i, int profit, int weight, int[] w, int[] p, int W, ArrayList<Item> itemsforArrayList) {

        for (int x = 0; x < p.length; x++) {

            p[i] = (int) itemsforArrayList.get( i ).profit;

            w[i] = (int) itemsforArrayList.get( i ).weight;


        }


        nodesChecked++;

        if (weight <= W && profit > maxprofit) {

            maxprofit = profit;
            int numBest = i;
            bestset = include;

        }
        if (promising( i, profit, weight, w, p, W )) {

            include[i + 1] = "yes"; //include item i+1

            knapsack( i + 1, profit + p[i + 1], weight + w[i + 1], w, p, W, itemsforArrayList );

            include[i + 1] = "no"; //Do not include item i+1;
            knapsack( i + 1, profit, weight, w, p, W, itemsforArrayList );

        }
    }

    public static boolean promising(int i, int profit, int weight, int[] w, int[] p, int W) {
        int j, k, totalWeight;
        float bound;
        int n = (p.length);

        if (weight >= W) {
            return false;
        } else {
            j = i + 1;
            bound = profit;
            totalWeight = weight;
        }

        while ((j < n) && ((totalWeight + w[j]) <= W)) {
            totalWeight = totalWeight + w[j];
            bound = bound + p[j];
            j++;
        }
        k = j;
        if (k < n) {
            bound = bound + (W - totalWeight) * (p[k] / w[k]);
        }


        return bound > maxprofit;

    }

}