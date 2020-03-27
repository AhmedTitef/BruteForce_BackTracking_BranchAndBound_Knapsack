import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BrandAndBoundSolution {


    public static int nodesChecked = 1;

    public static int knapsack3(int n, final int p[], final int w[], int W, ArrayList<Item> items) {
        PriorityQueue<Node> PQ = new PriorityQueue<Node>();


        for (int i = 0; i < n; i++) {
            p[i] = (int) items.get( i ).profit;
            w[i] = (int) items.get( i ).weight;
        }


        Node u = new Node();
        Node v = new Node();
        // System.out.println(v.toString() + "test");
        v.level = 0;
        v.profit = v.weight = 0;
        int maxProfit = 0;

        v.bound = bound( v, W, n, p, w );

        PQ.add( v );


        while (!PQ.isEmpty()) {
            v = PQ.poll();
            PQ.remove( v );
            if (v.bound > maxProfit) {

                u.level = v.level + 1;
                u.weight = v.weight + w[u.level];
                u.profit = v.profit + p[u.level];
                nodesChecked++;
                u.bound = bound( u, W, n, p, w );


            }
            if (u.weight <= W && u.profit > maxProfit) {
                nodesChecked++;
                maxProfit = u.profit;
            }

//                if (v.level == -1) {
//                    u.level = 0;
//
//                } else if (v.level != (n - 1)) {
//                    u.level = v.level + 1;
//                }
            if (u.bound > maxProfit) {

                PQ.add( u );

            }
            u = new Node();
            u.weight = v.weight;
            u.profit = v.profit;

            u.bound = bound( u, W, n, w, p );


            if (u.bound > maxProfit) {
                PQ.add( u );
            }


        }
        return maxProfit;


    }

    static float bound(Node u, int W, int n, int[] w, int[] p) {
        int j, k;
        int totalweight;
        float result;

        if (u.weight >= W) {
            return 0;

        } else {
            result = u.profit;
            j = u.level + 1;
            totalweight = u.weight;
            while (j < n && totalweight + w[j] <= W) {
                totalweight = totalweight + w[j];
                result = result + p[j];
                j++;
            }
        }
        k = j;
        if (k < n) {
            result = result + (W - totalweight) * p[k] / w[k];

        }
        return result;

    }


}

