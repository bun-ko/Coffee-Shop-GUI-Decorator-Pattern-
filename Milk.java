/**
 * Milk condiment decorator - wraps a beverage and adds milk cost/description.
 */
public class Milk extends CondimentDecorator{
    Beverage beverage;

    // Wraps the beverage and adds milk cost and description
    public Milk(Beverage beverage){
        this.beverage = beverage;
        this.beverage.cost += .50;
        this.beverage.description += " with Milk";
    }

    public double getCost(){
        return .50;
    }

    public String getDescription(){
        return "Milk condiment decorator";
    }
}
