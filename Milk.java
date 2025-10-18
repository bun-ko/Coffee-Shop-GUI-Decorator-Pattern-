public class Milk extends CondimentDecorator{
    Beverage beverage;

    public Milk(Beverage beverage){
        
    }
    public String getDescription(){
        return this.beverage.getDescription() + " with Milk";
    }

}
