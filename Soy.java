public class Soy extends CondimentDecorator{
    Beverage beverage;

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
