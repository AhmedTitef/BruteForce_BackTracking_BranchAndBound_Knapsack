import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algorithms {
	private int maxProfit = 0;
	private int nodesChecked = 0;
	
//	public void BruteForce(int maxWeight, ArrayList<Item> items) {
//		ArrayList<Integer> sets = new ArrayList<Integer>();
//
//		for (int i = 0; i < items.size(); i++) {
//			if (items.get(i).getWeight() < maxWeight) {
//				sets.add(items.get(i).getProfit());
//				if (items.get(i).getProfit() > maxProfit) {
//					maxProfit = items.get(i).getProfit();
//				}
//				nodesChecked++;
//				for (int j = i + 1; j < items.size(); j++) {
//					if (items.get(i).getWeight() + items.get(j).getWeight() <= maxWeight) {
//						int curProfit = items.get(i).getProfit() + items.get(j).getProfit();
//						if (curProfit > maxProfit) {
//							maxProfit = curProfit;
//						}
//						nodesChecked++;
//						sets.add(curProfit);
//						for (int k = j + 1; k < items.size() && items.get(k).getWeight() + items.get(j).getWeight() +
//							items.get(i).getWeight() <= maxWeight; k++) {
//							nodesChecked++;
//							int lastProfit = items.get(i).getProfit() + items.get(j).getProfit() +  items.get(k).getProfit();
//							if (lastProfit > maxProfit) {
//								maxProfit = lastProfit;
//							}
//							sets.add(lastProfit);
//						}
//					}
//				}
//			}
//			else if (items.get(i).getWeight() == maxWeight) {
//				sets.add(items.get(i).getProfit());
//				if (items.get(i).getProfit() > maxProfit) {
//					maxProfit = items.get(i).getProfit();
//				}
//				nodesChecked++;
//			}
//		}
//	}
//

//	private ArrayList<Item> bestSet = new ArrayList<Item>();
//	private ArrayList<Item> include = new ArrayList<Item>();
//
//	public void Backtrack(ArrayList<Item> items, int maxWeight) {
//		int i = 0;
//		int profit = 0;
//		int weight = 0;
//		W = maxWeight;
//		backtrack(items, i, profit, weight);
//		System.out.println("Max profit is " + maxProfit);
//		System.out.println("Total nodes visited = " + nodesChecked);
//		for (int j = 1; j < items.size(); j++) {
//			if (bestSet.contains(items.get(j)))
//				System.out.println("Stole Item " + items.get(j).getNumber());
//			else
//				System.out.println("Left Item " + items.get(j).getNumber());
//		}
//	}
//
//	private void backtrack(ArrayList<Item> items, int i, int profit, int weight) {
//		nodesChecked++;
//		if (weight <= W && profit > maxProfit) {
//			maxProfit = profit;
//			bestSet.clear();
//			for (int j = 0; j < include.size(); j++) {
//				bestSet.add(include.get(j));
//			}
//		}
//		if (promising(items, i, profit, weight)) {
//			for (int j = i + 1; j < items.size(); j++) {
//				include.add(items.get(j));
//				backtrack(items, j, profit + items.get(j).getProfit(), weight + items.get(j).getWeight());
//				if (j - 1 < include.size())
//					include.remove(include.get(j - 1));
//			}
//		}
//	}
//
//	private boolean promising(ArrayList<Item> items, int i, int profit, int weight) {
//		int bound, totWeight, j, k;
//		if (weight >= W) {
//			return false;
//		}
//		else {
//			j = i + 1;
//			bound = profit;
//			totWeight = weight;
//			while (j < items.size() && items.get(j).getWeight() <= W) {
//				bound += items.get(j).getProfit();
//				totWeight += items.get(j).getWeight();
//				j++;
//			}
//			k = j;
//			if (k < items.size()) {
//				bound = bound + ((W - totWeight) * (items.get(k).getProfit() / items.get(k).getWeight()));
//			}
//		}
//		return bound > maxProfit;
//	}
//
	public int BranchBound(ArrayList<Item> items, int maxWeight) {
		PriorityQueue<Node> PQ = new PriorityQueue<Node>();

		int p[] = new int[items.size()];
		int w[] = new int[items.size()];
		
		for (int i = 0; i < items.size(); i++) {
			p[i] = items.get(i).profit;
			w[i] = items.get(i).weight;
		}
		
		Node u = new Node();
		Node v = new Node();
	
		v.bound = (bound(v, p, w , maxWeight));
		PQ.add(v);
		
		while (!PQ.isEmpty()) {
			v = PQ.poll();
			if (v.bound > maxProfit) {					// see if node is still promising
				
				u.level = (v.level + 1);
				u.weight = (v.weight + w[u.weight]);
				u.profit = (v.profit + p[u.level ]);
				u.bound = (bound(u, p, w , maxWeight));
				
				if (u.weight <= maxWeight && u.profit > maxProfit)
					maxProfit = u.profit;
				if (u.bound > maxProfit)
					PQ.add(u);
				
				u = new Node();
				u.weight = (v.weight);
				u.profit = (v.profit);
				u.bound =(bound(u, p, w , maxWeight));
				
				if (u.bound > maxProfit) // add u to PQ if it is promising
					PQ.add(u);
			}
		}
		return maxProfit;
	}
	
	float bound (Node u, int[] p, int[] w , int maxWeight) {
		int j, k;
		int totweight;
		float result;
		if (u.weight >= maxWeight)
			return 0; 									// u is nonpromising. Return 0 for its bound
		else {
			result = u.profit;
			j = u.level + 1; 							// j = the first unconsidered item
			totweight = u.weight;
			while (j < p.length && totweight + w[j] <= maxWeight) {	// greedily grab as many items as possible
				totweight = totweight + w[j];
				result = result + p[j];
				j++;
			}
		}
		k = j;
		if (k < p.length)
			result = result + ((maxWeight - totweight) * (p[k] / w[k]));
		return result;
	}


}
