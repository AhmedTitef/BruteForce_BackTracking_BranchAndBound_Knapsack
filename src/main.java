import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class main {

    public static void main(String args[]) {


        Scanner scanner = new Scanner( System.in );
        System.out.println( "How many items are there to potentially take?" );
        int numItems = scanner.nextInt();
        int[] p = new int[numItems];
        int[] w = new int[numItems];
        System.out.println( "What is the weight and profit of each item?" );
        for (int i = 0; i < numItems; i++) {
            System.out.println( "Enter profit for Item " + (i + 1) );
            p[i] = scanner.nextInt();
            System.out.println( "Enter weight for Item " + (i + 1) );
            w[i] = scanner.nextInt();
        }
        System.out.println( "What is the max weight the bag can hold?" );
        int W = scanner.nextInt();

/////////////////////////////////////
        ArrayList<Item> items = new ArrayList<Item>();

        for (int i = 0; i < p.length; i++) {
            items.add( new Item( i, p[i], w[i] ) );
        }
        Collections.sort( items );

//
//        String A[] = new String[p.length + 1];
//        Arrays.fill( A, "no" );
///////////////////////////////
//        int[] backtrackp = new int[numItems + 1];
//        backtrackp[0] = 0; // dummy node in profit
//
//        int[] backtrackw = new int[numItems + 1];
//        backtrackw[0] = 0; // dummy node in weight
//        for (int i = 1; i <= p.length; i++) {
//            backtrackp[i] = p[i - 1];
//
//            backtrackw[i] = w[i - 1];
//
//        }
//        //Items made for Backtracking with a dummy node at the begining of 0 profit and 0 weight
//        ArrayList<Item> itemsforBacktrack = new ArrayList<Item>();
//
//        for (int i = 0; i < backtrackp.length; i++) {
//            itemsforBacktrack.add( new Item( i, backtrackp[i], backtrackw[i] ) );
//        }
//        Collections.sort( itemsforBacktrack );
//
///////////////////////////////////////
//
//        final long startTime = System.nanoTime();
//        BacktrackingKnapsack.knapsack( 0, 0, 0, backtrackw, backtrackp, W, itemsforBacktrack );
//        System.out.println( "Maximum Profit for BackTracking: " +
//                BacktrackingKnapsack.maxprofit );
//        System.out.println( " Nodes Checked: " + BacktrackingKnapsack.nodesChecked );
//        final long duration = System.nanoTime() - startTime;
//        System.out.println( "Duration for BackTracking: " + duration );
//        System.out.println( "----------------------------" );
//        System.out.println( "----------------------------" );
///////////////////////////////////////
//        final long startTime1 = System.nanoTime();
//        System.out.println( "Maximum Profit for Branch and Bound: " +
//                BrandAndBoundSolution.knapsack3( p.length, p, w, W, items ) );
//        System.out.println( " Nodes Checked: " + BrandAndBoundSolution.nodesChecked );
//        final long duration1 = System.nanoTime() - startTime1;
//        System.out.println( "Duration for Branch and Bound: " + duration1 );
//        System.out.println( "----------------------------" );
//        System.out.println( "----------------------------" );
//
///////////////////////////////////////
//        final long startTime2 = System.nanoTime();
//        BruteForceSolution brr = new BruteForceSolution();
//        brr.bruteforce( w, p, A, W, items );
//        System.out.println( "Maximum Profit for BruteForce: " + brr.maxprofit );
//        System.out.println( " Nodes Checked: " + brr.nodesChecked );
//        final long duration2 = System.nanoTime() - startTime2;
//        System.out.println( "Duration for Brute Force : " + duration2 );
//        System.out.println( "----------------------------" );
//        System.out.println( "----------------------------" );
/////////////////////////


        ///test for Algorithms

        Algorithms algorithms = new Algorithms();
        System.out.println( algorithms.BranchBound( items , W ) );;


    }

/////////////////
}