public class Soy extends CondimentDecorator{
    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public double getCost(){
        return beverage.getCost() + 1.00;
    }

    public String getDescription(){
        return this.beverage.getDescription() + " with Soy";
    }
}
