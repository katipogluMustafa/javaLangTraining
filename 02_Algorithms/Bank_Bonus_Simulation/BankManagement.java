package PlayGround;

import java.util.List;

public class BankManagement {
    private Campaign bonusCampaign;

    public BankManagement(){
        bonusCampaign = new Campaign("Bonus", 3);
    }

    public void addCustomer(Customer customer) throws MaxCustomerCountException{
        if( !bonusCampaign.addCustomer(customer) )
            throw new MaxCustomerCountException("Max Customer Count Has Already Been Reached !");
    }

    public void addCustomer(List<Customer> collection) throws MaxCustomerCountException{
        if( !bonusCampaign.addCustomer(collection) )
            throw new MaxCustomerCountException("Max Customer Count Has Already Been Reached !");
    }

    public void addCustomer(Customer[] customers) throws MaxCustomerCountException{
        if( !bonusCampaign.addCustomer(customers) )
            throw new MaxCustomerCountException("Max Customer Count Has Already Been Reached !");
    }

    public void deleteCustomer(Customer customer) throws InefficientPointException, ContractTimeHasNotExpiredException{
        bonusCampaign.deleteCustomer(customer);
    }

    public void list(){
        bonusCampaign.printMembers();
    }

}
