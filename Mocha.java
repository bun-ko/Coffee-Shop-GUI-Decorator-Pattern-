public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public double getCost(){
        return beverage.getCost() + 1.50;
    }

    public String getDescription(){
        return this.beverage.getDescription() + " with Mocha";
    }
}
