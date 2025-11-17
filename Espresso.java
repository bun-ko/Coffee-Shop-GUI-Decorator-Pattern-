/**
 * Espress - a concrete beverage implementation.
 */
public class Espresso extends Beverage{
    public Espresso(){
        this.cost = 1.50;
        this.description = "Espresso";
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return this.description;
    }
}
