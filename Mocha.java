public class Mocha extends CondimentDecorator{
    Beverage beverage;

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
