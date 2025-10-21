public class CoffeShopMain {    
    public static void main(String[] args){
        Espresso espressoDemo = new Espresso();
        System.out.println("Espresso object made, display initial cost and description");
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
        Milk addMilk = new Milk(espressoDemo);
        System.out.println("Milk object made with espresso object, display espresso's new cost and description");
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
        System.out.println("now add mocha to the espresso");
        Mocha addMocha = new Mocha(espressoDemo);
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
        System.out.println("Add more milk!");
        Milk addMoreMilk = new Milk(espressoDemo);
        System.out.println(espressoDemo.getCost());
        System.out.println(espressoDemo.getDescription());
    }
}
