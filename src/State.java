class State {
    private OrderState state = new OrderedState();

    // getter
    public OrderState getState() {
        return state;
    }

    // setter
    public void setState(OrderState state) {
        this.state = state;
    }

    public void waitingForOrderState() {
        state.waitingForOrder(this);
    }

    public void produceProductState() {
        state.produceProduct(this);
    }

    public void serveState() {
        state.serve(this);
    }

    public void orderFoodDrink(String foodOrDrink) {
        if (state instanceof OrderedState) {
            ((OrderedState) state).orderFoodDrink(this, foodOrDrink);
        }
    }

    public void printStatus() {
        state.printStatus();
    }
}

interface OrderState {
    void waitingForOrder(State pkg);
    void produceProduct(State pkg);
    void serve(State pkg);
    void printStatus();
}

class OrderedState implements OrderState {

    @Override
    public void waitingForOrder(State pkg) {
        System.out.println("The state is in its default state.");
    }

    @Override
    public void produceProduct(State pkg) {
        System.out.println("Cannot produce, the product is not yet ordered.");
    }

    @Override
    public void serve(State pkg) {
        System.out.println("Cannot serve, the product is not yet produced.");
    }

    public void orderFoodDrink(State pkg, String foodOrDrink) {
        System.out.println("Order received: " + foodOrDrink);
        pkg.setState(new MakeState(foodOrDrink)); // Pass the order to the MakeState
    }

    @Override
    public void printStatus() {
        System.out.println("Order placed, waiting for production.");
    }
}

class MakeState implements OrderState {

    private EdiblesFactory factory = new EdiblesFactory();
    private String foodOrDrink;
    private String finishedProduct;

    public MakeState(String foodOrDrink) {
        this.foodOrDrink = foodOrDrink;
        this.finishedProduct = "There is no order has been produced";
    }

    @Override
    public void waitingForOrder(State pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void produceProduct(State pkg) {
        System.out.println("Producing " + foodOrDrink);
        edibles product = factory.getEdibles(foodOrDrink);
        if (product != null) {
            product.make();
            finishedProduct = product.getDetail(); // Ensure this gets the correct detail
            pkg.setState(new ServeState(finishedProduct));
        } else {
            System.out.println("No such product available.");
        }
    }

    @Override
    public void serve(State pkg) {
        // System.out.println(foodOrDrink + " is ready to be served.");
        // pkg.setState(new ServeState(finishedProduct));
        System.out.println("Cannot serve, the product is producing.");
    }

    @Override
    public void printStatus() {
        System.out.println(foodOrDrink + " is being produced.");
    }
}

class ServeState implements OrderState {
    private String finishedProduct;

    public ServeState(String finishedProduct) {
        this.finishedProduct = finishedProduct;
    }
    @Override
    public void waitingForOrder(State pkg) {
        // System.out.println(finishedProduct + " is already served.");
        System.out.println("Cannot wait for order, product is already served.");
    }

    @Override
    public void produceProduct(State pkg) {
        System.out.println("Cannot produce, product is already served.");
    }

    @Override
    public void serve(State pkg) {
        System.out.println(finishedProduct + " has been served to the customer.");
        pkg.setState(new OrderedState()); // Reset to OrderedState after serving
        System.out.println("State has been reset to OrderedState.");
    }

    @Override
    public void printStatus() {
        System.out.println(finishedProduct + " has been served to the customer.");
    }

    // public void back
}
