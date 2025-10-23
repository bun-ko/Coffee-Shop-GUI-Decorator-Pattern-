/**
 * Mocha condiment decorator - wraps a beverage and adds mocha cost/description.
 */
public class Mocha extends CondimentDecorator{
    Beverage beverage;

    // Wraps the beverage and adds mocha cost and description
    public Mocha(Beverage beverage){
        this.beverage = beverage;
        this.beverage.cost += 1.00;
        this.beverage.description += " with Mocha";
    }

    public double getCost(){
        return 1.00;
    }

    public String getDescription(){
        return "Mocha condiment decorator";
    }
}
