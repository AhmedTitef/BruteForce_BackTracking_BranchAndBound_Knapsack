
public class Item implements Comparable<Item>
{

    public int number;
    public int profit;
    public int weight;

    public Item(int number, int profit, int weight)
    {
        this.number=number;
        this.profit=profit;
        this.weight=weight;
    }
    @Override

    public int compareTo(Item i) {
        float ratio = (float)this.profit/this.weight;
        float secondRatio = (float)i.profit/i.weight;
        if(ratio > secondRatio) {
            return -1;
        }
        else if(ratio < secondRatio) {
            return 1;
        }
        return 0;

    }
    public String toString()
    {
        return "Item: " + (this.number + 1) + " Profit: " + this.profit + " Weight: " + this.weight;
    }

}