/**
 * Whip condiment decorator - wraps a beverage and adds whip cost/description.
 */
public class Whip extends CondimentDecorator{
    Beverage beverage;

    // Wraps the beverage and adds whip cost and description
    public Whip(Beverage beverage){
        this.beverage = beverage;
        this.beverage.cost += 1.50;
        this.beverage.description += " with Whip";
    }

    public double getCost(){
        return 1.50;
    }

    public String getDescription(){
        return "Whipped condiment decorator";
    }
}
