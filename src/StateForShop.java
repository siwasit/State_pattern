public class StateForShop {

    public static void main(String[] args) {

        State order = new State();
        order.orderFoodDrink("Latte"); 
        order.produceProductState();    
        order.serveState();   
        // order.serveState();
        // order.printStatus();
        // order.printStatus();          
        System.out.println("-------------------------------");
        order.orderFoodDrink("Seafood");
        order.produceProductState();    
        order.serveState(); 
    }
}