public class DarkRoast extends Beverage {
    public DarkRoast(){
        this.cost = 1.00;
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return "Dark Roast";
    }

    public double getTotal(){
        return totalCost;
    }
}
