public class HouseBlend extends Beverage{
    public HouseBlend(){
        this.cost = 1.00;
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return "House blend";
    }

    public double getTotal(){
        return totalCost;
    }
}
