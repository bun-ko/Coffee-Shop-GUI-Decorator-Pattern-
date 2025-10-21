public class Milk extends CondimentDecorator{
    Beverage beverage;

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
