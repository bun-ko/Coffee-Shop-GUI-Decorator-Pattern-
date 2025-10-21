public abstract class Beverage {
    protected double cost;
    protected double totalCost;
    abstract String getDescription();
    abstract double getCost();
    abstract double getTotal();
}