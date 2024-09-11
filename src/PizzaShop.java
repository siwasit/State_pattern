/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

interface Pizza {
    String getDescription();
    double cost();
}

class SimplePizza implements Pizza {
    
    @Override
    public String getDescription() {
        return "SimplePizza";
    }
    
    @Override
    public double cost() {
        return 0.0;
    }
};

abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;
    
    public PizzaDecorator(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost();
    }
}

class PizzaDoughDecorator extends PizzaDecorator {
    public PizzaDoughDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Pizza Dough";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 20.0;
    }
}

class PineappleDecorator extends PizzaDecorator {
    public PineappleDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Pineapple";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 5.0;
    }
}

class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Cheese";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 8.0;
    }
}

class HamDecorator extends PizzaDecorator {
    public HamDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Ham";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 15.0;
    }
}

class PepperDecorator extends PizzaDecorator {
    public PepperDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Pepper";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 9.0;
    }
}

class ShrimpDecorator extends PizzaDecorator {
    public ShrimpDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Shrimp";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 7.0;
    }
}

class MusselsDecorator extends PizzaDecorator {
    public MusselsDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Mussels";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 4.0;
    }
}

class TomatoDecorator extends PizzaDecorator {
    public TomatoDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
    
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", with Tomato";
    }
    
    @Override
    public double cost() {
        return decoratedPizza.cost() + 3.0;
    }
}

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new SimplePizza();
        System.out.println(pizza.getDescription() + " $" + pizza.cost());
        
        Pizza hawaiian = new TomatoDecorator(new HamDecorator(new CheeseDecorator(new PineappleDecorator(new PizzaDoughDecorator(new SimplePizza())))));
        System.out.println(hawaiian.getDescription() + " $" + hawaiian.cost());
        
        Pizza Seafood = new TomatoDecorator(new MusselsDecorator(new ShrimpDecorator(new PepperDecorator(new CheeseDecorator(new PizzaDoughDecorator(new SimplePizza()))))));
        System.out.println(Seafood.getDescription() + " $" + Seafood.cost());
    }
}