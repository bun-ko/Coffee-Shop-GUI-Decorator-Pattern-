public class Whip extends CondimentDecorator{
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public double getCost(){
        return beverage.getCost() + 1.50;
    }

    public String getDescription(){
        return this.beverage.getDescription() + " with Whip";
    }
}
