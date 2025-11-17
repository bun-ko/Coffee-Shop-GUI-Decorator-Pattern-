/**
 * Base component for all beverages in the coffee shop.
 * Subclasses define specific beverage types.
 */
public abstract class Beverage {
    // Price of the beverage
    protected double cost;
    
    // Name/description of the beverage
    protected String description;
    
    // Returns the beverage description
    abstract String getDescription();
    
    // Returns the beverage cost
    abstract double getCost();
}