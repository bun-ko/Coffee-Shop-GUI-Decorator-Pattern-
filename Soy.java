/**
 * Soy condiment decorator - wraps a beverage and adds soy cost/description.
 */
public class Soy extends CondimentDecorator{
    Beverage beverage;

    // Wraps the beverage and adds soy cost and description
    public Soy(Beverage beverage){
        this.beverage = beverage;
        this.beverage.cost += 1.50;
        this.beverage.description += " with Soy";
    }

    public double getCost(){
        return 1.50;
    }

    public String getDescription(){
        return "Soy condiment decorator";
    }
}
