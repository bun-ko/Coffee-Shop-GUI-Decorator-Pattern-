/**
 * Abstract decorator class for condiments.
 * Extends Beverage so decorators can wrap other beverages.
 */
public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}
