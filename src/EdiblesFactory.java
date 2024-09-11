interface edibles {
    void make();
    String getDetail();
}

class Latte implements edibles {

    Coffee CaffeLatte = new SimpleCoffee();

    @Override
    public void make() {
        CaffeLatte = new MilkDecorator(new EspressoShotDecorator(new SimpleCoffee()));
        System.out.println(CaffeLatte.getDescription() + " " + CaffeLatte.cost() + " baht" + "\n");
        System.out.println("Latte successfully done");
    }

    @Override
    public String getDetail() {
        return "A Latte which worth "+ CaffeLatte.cost() + " baht" ;
    }
}

class Seafood implements edibles {

    Pizza Seafood = new SimplePizza();

    @Override
    public void make() {
        Seafood = new TomatoDecorator(new MusselsDecorator(new ShrimpDecorator(new PepperDecorator(new CheeseDecorator(new PizzaDoughDecorator(new SimplePizza()))))));
        System.out.println(Seafood.getDescription() + " " + Seafood.cost() + " baht" + "\n");
        System.out.println("Seafood successfully done");
    }

    @Override
    public String getDetail() {
        return "A Seafood which worth "+ Seafood.cost() + " baht" ;
    }
}

class Americano implements edibles { //americano
    
    Coffee Americano = new SimpleCoffee();

    @Override
    public void make() {
        Americano = new HotWaverDecorator(new EspressoShotDecorator(new SimpleCoffee()));
        System.out.println(Americano.getDescription() + " " + Americano.cost() + " baht" + "\n");
        System.out.println("Americano successfully done");
    }

    @Override
    public String getDetail() {
        return "A Americano which worth "+ Americano.cost() + " baht" ;
    }
}

class EdiblesFactory  {

    // use getedibles method to get object of type edibles
    public edibles getEdibles(String fob) {
        if (fob == null) {
            return null;
        }
        if (fob.equalsIgnoreCase("Americano")) {
            return new Americano();

        } else if (fob.equalsIgnoreCase("Latte")) {
            return new Latte();

        } else if (fob.equalsIgnoreCase("Seafood")) {
            return new Seafood();
        }

        return null;
    }
}

// public class FactoryPatternDemo {

//     public static void main(String[] args) {
//         ediblesFactory ediblesFactory = new ediblesFactory();

//         // get an object of Circle and call its draw method.
//         edibles americanoFactory = ediblesFactory.getEdibles("Americano");

//         // call draw method of Circle
//         americanoFactory.make();

//         // get an object of Rectangle and call its draw method.
//         edibles latteFactory = ediblesFactory.getEdibles("Latte");

//         // call draw method of Rectangle
//         latteFactory.make();

//         // get an object of Square and call its draw method.
//         edibles seafoodFactory = ediblesFactory.getEdibles("Seafood");

//         // call draw method of square
//         seafoodFactory.make();
//     }
// }