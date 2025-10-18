public class Milk extends CondimentDecorator{
    Beverage beverage;

    public double getCost(){
        return this.beverage.getCost() + .99; //whatever price this is
    }

    public String getDescription(){
        return this.beverage.getDescription() + " with Milk";
    }

}
