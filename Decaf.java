public class Decaf extends Beverage{
    public Decaf(){
        this.cost = 1.25;
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return "Decaf";
    }

    public double getTotal(){
        return totalCost;
    }
}
