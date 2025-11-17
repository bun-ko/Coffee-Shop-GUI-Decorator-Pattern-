/**
 * Console demo showing how the Decorator Pattern works.
 * Creates a beverage and wraps it with multiple condiments.
 */
public class CoffeShopMain {    
    public static void main(String[] args){
        // Create base espresso
        Espresso espressoDemo = new Espresso();
        System.out.println("Espresso object made, display initial cost and description");
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
        
        // Wrap espresso with milk decorator
        Milk addMilk = new Milk(espressoDemo);
        System.out.println("Milk object made with espresso object, display espresso's new cost and description");
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
        
        // Wrap with mocha decorator
        System.out.println("now add mocha to the espresso");
        Mocha addMocha = new Mocha(espressoDemo);
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
        
        // Wrap with another milk decorator
        System.out.println("Add more milk!");
        Milk addMoreMilk = new Milk(espressoDemo);
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
    }
}
