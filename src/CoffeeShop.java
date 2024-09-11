interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    
    @Override
    public String getDescription() {
        return "SimpleCoffee";
    }
    
    @Override
    public double cost() {
        return 0.0;
    }
};

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    
    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
    
    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

class EspressoShotDecorator extends CoffeeDecorator {
    public EspressoShotDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", with Espresso shot";
    }
    
    @Override
    public double cost() {
        return decoratedCoffee.cost() + 10.0;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", with Milk";
    }
    
    @Override
    public double cost() {
        return decoratedCoffee.cost() + 5.0;
    }
}

class HotWaverDecorator extends CoffeeDecorator {
    public HotWaverDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", with Hot Waver";
    }
    
    @Override
    public double cost() {
        return decoratedCoffee.cost() + 3.0;
    }
}

public class CoffeeShop {
    public static void main(String[] args) throws Exception {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " " + coffee.cost() + " baht");

        Coffee Americano = new HotWaverDecorator(new EspressoShotDecorator(new SimpleCoffee()));
        System.out.println(Americano.getDescription() + " " + Americano.cost() + " baht");

        Coffee CaffeLatte = new MilkDecorator(new EspressoShotDecorator(new SimpleCoffee()));
        System.out.println(CaffeLatte.getDescription() + " " + CaffeLatte.cost() + " baht");

    }
}
