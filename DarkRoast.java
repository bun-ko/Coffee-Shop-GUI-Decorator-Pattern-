public class DarkRoast extends Beverage {
    public DarkRoast(){
        this.cost = 1.50;
        this.description = "Dark roast";
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return this.description;
    }
}
