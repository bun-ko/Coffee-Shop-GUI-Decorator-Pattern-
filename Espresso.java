public class Espresso extends Beverage{
    public Espresso(){
        this.cost = 1.50;
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return "Espresso";
    }

    public double getTotal(){
        return totalCost;
    }
}
