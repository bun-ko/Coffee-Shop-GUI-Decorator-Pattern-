public class Milk extends CondimentDecorator{
    Beverage beverage;

    public Milk(Beverage beverage){ //IS THIS NOT A CONSTRUCTOR>???? JAVA WHAT
        System.out.println(getCost());
        System.out.println(getDescription());
    }

    public double getCost(){
        return this.beverage.getCost() + .99; //whatever price this is
    }

    public String getDescription(){
        return this.beverage.getDescription() + " with Milk";
    }

}
