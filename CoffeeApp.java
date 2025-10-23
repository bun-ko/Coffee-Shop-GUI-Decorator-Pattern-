import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Main GUI application for the coffee shop.
 * Demonstrates the Decorator Pattern with an interactive interface.
 */
public class CoffeeApp extends JFrame
{
    private static final int WIDTH = 375;
    private static final int HEIGHT = 812;

    // GUI components
    private JComboBox<String> baseSelector;
    private JRadioButton smallSize, mediumSize, largeSize;
    private JCheckBox milkBox, mochaBox, soyBox, whipBox;
    private JTextArea orderSummary;
    private JLabel totalLabel;
    private JButton clearBtn, addToCartBtn, checkoutBtn, helpBtn;

    // Shopping cart to store multiple orders
    private ArrayList<String> cart = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("$0.00");

    // Track last selections
    private String lastBase = "";
    private String lastSize = "Medium";
    private boolean lastMilk, lastMocha, lastSoy, lastWhip;

    /**
     * Constructor - sets up the main window and components
     */
    public CoffeeApp() 
    {
        super("Coffee Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        add(createMainPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        updateSummary();
        setVisible(true);
    }

    /**
     * Creates the main panel with all input controls and order summary
     */
    private JPanel createMainPanel() 
    {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Base Beverage:"));
        baseSelector = new JComboBox<>(new String[]{"Select Here", "Espresso", "Dark Roast", "Decaf", "House Blend"});
        baseSelector.setSelectedItem(lastBase);
        panel.add(baseSelector);

        panel.add(new JLabel("Size:"));
        ButtonGroup sizeGroup = new ButtonGroup();
        smallSize = new JRadioButton("Small (1.0)");
        mediumSize = new JRadioButton("Medium (1.25)", true);
        largeSize = new JRadioButton("Large (1.5)");
        sizeGroup.add(smallSize);
        sizeGroup.add(mediumSize);
        sizeGroup.add(largeSize);
        panel.add(smallSize);
        panel.add(mediumSize);
        panel.add(largeSize);

        panel.add(new JLabel("Add Condiments:"));
        milkBox = new JCheckBox("Milk (+$0.50)");
        mochaBox = new JCheckBox("Mocha (+$1.00)");
        soyBox = new JCheckBox("Soy (+$1.50)");
        whipBox = new JCheckBox("Whip (+$1.50)");
        panel.add(milkBox);
        panel.add(mochaBox);
        panel.add(soyBox);
        panel.add(whipBox);

        panel.add(new JLabel("Order Summary:"));
        orderSummary = new JTextArea(6, 20);
        orderSummary.setEditable(false);
        orderSummary.setLineWrap(true);
        orderSummary.setWrapStyleWord(true);
        panel.add(new JScrollPane(orderSummary));

        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(totalLabel);

        ItemListener listener = e -> updateSummary();
        baseSelector.addItemListener(listener);
        milkBox.addItemListener(listener);
        mochaBox.addItemListener(listener);
        soyBox.addItemListener(listener);
        whipBox.addItemListener(listener);
        smallSize.addActionListener(e -> updateSummary());
        mediumSize.addActionListener(e -> updateSummary());
        largeSize.addActionListener(e -> updateSummary());

        return panel;
    }

    /**
     * Creates the bottom button panel
     */
    private JPanel createButtonPanel() 
    {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        clearBtn = new JButton("Clear");
        addToCartBtn = new JButton("Add to Cart");
        checkoutBtn = new JButton("Checkout");
        helpBtn = new JButton("Help");

        clearBtn.addActionListener(e -> clearSelections());
        addToCartBtn.addActionListener(e -> addToCart());
        checkoutBtn.addActionListener(e -> checkout());
        helpBtn.addActionListener(e -> showHelp());

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(clearBtn);
        buttonPanel.add(addToCartBtn);
        buttonPanel.add(checkoutBtn);
        buttonPanel.add(helpBtn);

        return buttonPanel;
    }

    /**
     * Updates the order summary and total cost based on current selections.
     * This is where the Decorator Pattern is applied - condiments wrap the base beverage.
     */
    private void updateSummary() 
    {
        String base = (String) baseSelector.getSelectedItem();
        if (base == null || base.isEmpty()) 
        {
            orderSummary.setText("Please select a base beverage.");
            totalLabel.setText("Total: $0.00");
            return;
        }

        // Create the base beverage
        double cost = 0;
        Beverage drink;
        switch (base) 
        {
            case "Espresso" -> drink = new Espresso();
            case "Dark Roast" -> drink = new DarkRoast();
            case "Decaf" -> drink = new Decaf();
            case "House Blend" -> drink = new HouseBlend();
            default -> { orderSummary.setText("Invalid base."); return; }
        }
        cost = drink.getCost();

        StringBuilder desc = new StringBuilder(base);

        // Apply decorators (condiments) to the beverage
        if (milkBox.isSelected()) { new Milk(drink); desc.append(", milk"); }
        if (mochaBox.isSelected()) { new Mocha(drink); desc.append(", mocha"); }
        if (soyBox.isSelected()) { new Soy(drink); desc.append(", soy"); }
        if (whipBox.isSelected()) { new Whip(drink); desc.append(", whip"); }

        // Calculate final price with size multiplier
        double multiplier = smallSize.isSelected() ? 1.0 : mediumSize.isSelected() ? 1.25 : 1.5;
        double subtotal = drink.getCost();
        double total = subtotal * multiplier;

        orderSummary.setText(desc + " (" +
                (smallSize.isSelected() ? "small" :
                mediumSize.isSelected() ? "medium" : "large") + ")\n\n" +
                "Base + Condiments: " + df.format(subtotal) + "\n" +
                "Size Multiplier: " + multiplier + "\n" +
                "----------------------\nFinal: " + df.format(total));

        totalLabel.setText("Total: " + df.format(total));

        lastBase = base;
        lastMilk = milkBox.isSelected();
        lastMocha = mochaBox.isSelected();
        lastSoy = soyBox.isSelected();
        lastWhip = whipBox.isSelected();
        lastSize = smallSize.isSelected() ? "Small" : mediumSize.isSelected() ? "Medium" : "Large";
    }

    /**
     * Resets all selections to default
     */
    private void clearSelections() 
    {
        baseSelector.setSelectedIndex(0);
        smallSize.setSelected(false);
        mediumSize.setSelected(true);
        largeSize.setSelected(false);
        milkBox.setSelected(false);
        mochaBox.setSelected(false);
        soyBox.setSelected(false);
        whipBox.setSelected(false);
        updateSummary();
    }

    /**
     * Adds the current order to the shopping cart
     */
    private void addToCart() 
    {
        String base = (String) baseSelector.getSelectedItem();
        if (base == null || base.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please select a base beverage first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cart.add(orderSummary.getText());
        JOptionPane.showMessageDialog(this, "Added to cart!", "Cart", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays all items in the cart and clears it
     */
    private void checkout() 
    {
        if (cart.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Your cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        StringBuilder receipt = new StringBuilder("Your Order:\n\n");
        for (String item : cart) receipt.append(item).append("\n\n");
        JOptionPane.showMessageDialog(this, receipt.toString(), "Checkout", JOptionPane.INFORMATION_MESSAGE);
        cart.clear();
    }

    /**
     * Shows help dialog explaining the Decorator Pattern
     */
    private void showHelp() 
    {
        JOptionPane.showMessageDialog(this,
            """
            Each add-on (Milk, Mocha, Soy, Whip) wraps your base drink.
            This demonstrates the Decorator Design Pattern — 
            where each condiment decorates the beverage by 
            adding new behavior (cost, description).
            """,
            "Help | Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(CoffeeApp::new);
    }
}
