public class Whip extends CondimentDecorator{
    Beverage beverage;

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
