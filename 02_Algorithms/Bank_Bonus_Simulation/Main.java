package PlayGround;

public class Main {

    public static void main(String[] args){
        Customer[] m = new Customer[4];
        m[0] = new StandardCustomer(1,"Ali" ,"Ertas",100,10);
        m[1] = new StandardCustomer(1,"Ayse" ,"Genc",100,15);
        m[2] = new EliteCustomer(1,"Ahmet" ,"Yilmaz",100,20);
        m[3] = new EliteCustomer(1,"Fatma" ,"Ozturk",100,25);

        BankManagement b = new BankManagement();
        try{
            b.addCustomer(m[0]);
            b.addCustomer(m[1]);
            b.addCustomer(m[2]);
            b.addCustomer(m[3]);
        }catch (MaxCustomerCountException e){
            e.printStackTrace();
        }

        try{
            b.addCustomer(m);
        }catch (MaxCustomerCountException e){
            e.printStackTrace();
        }

        m[0].doShopping(100);

        try{
            b.deleteCustomer(m[1]);
        }catch (ContractTimeHasNotExpiredException | InefficientPointException e) {
            e.printStackTrace();
        }

        b.list();

    }

}
