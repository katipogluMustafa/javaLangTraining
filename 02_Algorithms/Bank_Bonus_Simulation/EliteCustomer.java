package PlayGround;

public class EliteCustomer extends Customer {

    public EliteCustomer(int id, String name, String surname, int points, int contractedShoppingCount){
        super(id,name,surname,points,contractedShoppingCount);
    }

    @Override
    public void doShopping(int cost){
        gainPoints(4 * cost);
        decrementContractedShoppingCount();
    }
    @Override
    public String toString(){
        return "Elite Customer: " + super.toString();
    }
}
