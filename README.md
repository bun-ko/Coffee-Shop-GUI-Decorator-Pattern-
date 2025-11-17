# Coffee Shop GUI - Decorator Pattern

A Java Swing application that demonstrates the Decorator Design Pattern through a coffee shop ordering system.

## What This Does

This is a coffee shop app where you can:
- Pick a base coffee (Espresso, Dark Roast, Decaf, or House Blend)
- Choose a size (Small, Medium, or Large)
- Add condiments (Milk, Mocha, Soy, Whip)
- See the price update in real-time
- Add items to a cart and checkout

## How to Run

```bash
javac *.java
java CoffeeApp
```

## How to Use the GUI

1. Select a base beverage from the dropdown
2. Pick a size (affects the price multiplier)
3. Check any condiments you want to add
4. The order summary shows your current drink and total cost
5. Click "Add to Cart" to save it
6. Click "Checkout" to see your full cart
7. Click "Clear" to reset and start a new drink

## Decorator Pattern Implementation

### How It Works

The Decorator Pattern lets you add features to objects dynamically. In this coffee shop:

- **Base Component**: `Beverage` - abstract class for all drinks
- **Concrete Components**: `Espresso`, `DarkRoast`, `Decaf`, `HouseBlend` - the actual coffee types
- **Decorator**: `CondimentDecorator` - abstract class that wraps beverages
- **Concrete Decorators**: `Milk`, `Mocha`, `Soy`, `Whip` - condiments that wrap around beverages

### Why This Pattern?

Instead of creating a separate class for every possible combination (EspressoWithMilk, EspressoWithMilkAndMocha, etc.), decorators let you:
- Start with a base beverage
- Wrap it with condiments one at a time
- Each decorator adds its own cost and description to the beverage

### Example

```java
Beverage drink = new Espresso();           // Start with espresso
drink = new Milk(drink);                    // Wrap with milk
drink = new Mocha(drink);                   // Wrap with mocha
// Now drink.getCost() returns the total cost
```

## File Structure

- `Beverage.java` - Abstract base class
- `Espresso.java`, `DarkRoast.java`, `Decaf.java`, `HouseBlend.java` - Coffee types
- `CondimentDecorator.java` - Abstract decorator
- `Milk.java`, `Mocha.java`, `Soy.java`, `Whip.java` - Condiment decorators
- `CoffeeApp.java` - GUI application
- `CoffeShopMain.java` - Console demo of the pattern