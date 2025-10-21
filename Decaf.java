public class Decaf extends Beverage{
    public Decaf(){
        this.cost = 1.00;
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
