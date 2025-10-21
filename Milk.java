public class Milk extends CondimentDecorator{
    Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    public double getCost(){
        return beverage.getCost() + .50;
    }

    public String getDescription(){
        return this.beverage.getDescription() + " with Milk";
    }
}
