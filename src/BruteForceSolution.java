import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BruteForceSolution {
    String[] bestSet = new String[100];
    int maxprofit = 0;
    int bestWeight = 0;
    int nodesChecked = 1;


    public String[] bruteforce(int[] w, int[] p, String[] include, int W, ArrayList<Item> items) {
        int n = p.length;

        for (int i = 0; i < n; i++) {
            p[i] = (int) items.get( i ).profit;
            w[i] = (int) items.get( i ).weight;
        }


        for (int i = 0; i < Math.pow( 2, n ); i++) {
            nodesChecked++;
            int j = n - 1;
            int tempWeight = 0;
            int tempprofit = 0;

            while (!include[j].equals( "no" ) && j > 0) {
                nodesChecked++;
                include[j] = "no";

                j = j - 1;

            }


            include[j] = "yes";



            for (int k = 0; k < n; k++) {

                if (include[k].equals( "yes" )) {
                    tempWeight = tempWeight + w[k];
                    tempprofit = tempprofit + p[k];

                }


            }
            if ((tempprofit > maxprofit) && (tempWeight <= W)) {
                maxprofit = tempprofit;
                bestWeight = tempWeight;


            }

            bestSet = include;
        }
        return bestSet;
    }


}
