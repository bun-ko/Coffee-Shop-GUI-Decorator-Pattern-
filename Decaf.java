public class Decaf extends Beverage{
    public Decaf(){
        this.cost = 1.25;
        this.description = "Decaf";
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return this.description;
    }
}
