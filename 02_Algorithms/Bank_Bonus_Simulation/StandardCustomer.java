package PlayGround;

public class StandardCustomer extends Customer {

    public StandardCustomer(int id, String name, String surname, int points, int contractedShoppingCount) {
        super(id, name, surname, points, contractedShoppingCount);
    }

    @Override
    public void doShopping(int cost){
        gainPoints(2 * cost);
        decrementContractedShoppingCount();
    }

    @Override
    public String toString(){
        return "Standard Customer: " + super.toString();
    }
}
