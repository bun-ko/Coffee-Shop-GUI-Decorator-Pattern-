/**
 * House Blend - a concrete beverage implementation.
 */

public class HouseBlend extends Beverage{
    public HouseBlend(){
        this.cost = 1.00;
        this.description = "House blend";
    }

    public double getCost(){
        return this.cost;
    }

    public String getDescription(){
        return this.description;
    }
}
