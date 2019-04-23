package PlayGround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Campaign {
    private String name;
    private final int participationLimit;
    private List<Customer> members;

    public Campaign(String name, int participationLimit){
        this.name = name;
        this.participationLimit = participationLimit;
        members = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer){
        if( availableSpace() < 0 )
            return false;

        members.add(customer);

        return true;
    }

    public boolean addCustomer(List<Customer> customers){
        if( customers.size() > availableSpace() )
            return false;

        members.addAll(customers);

        return true;
    }

    public boolean addCustomer(Customer[] customers){
        if( customers.length > availableSpace() )
            return false;

        members.addAll(Arrays.asList(customers));
        return true;
    }

    public boolean deleteCustomer(Customer customer) throws InefficientPointException, ContractTimeHasNotExpiredException {
        if( customer.getContractedShoppingCount() != 0)
            throw new ContractTimeHasNotExpiredException( customer.getName() + " has not reached to given contract count!");
        else{
            int pointsToDelete = customer.getPointsGained();
            if( !customer.deletePoints(pointsToDelete) )
                throw new InefficientPointException( customer.getName() + " doesn't have enough points to quit the campaign!");
            else{
                // Successfully deleted and points has been taken from the user
                return true;
            }
        }

    }

    private int availableSpace(){
        return participationLimit - members.size();
    }

    public int getParticipationLimit() {
        return participationLimit;
    }

    public String getName() {
        return name;
    }

    public List<Customer> getMembers() {
        return members;
    }

    public void printMembers(){
        for( Customer c : members )
            System.out.println(c);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(getName()).append(" Campaign\nMembers of the campaign: \n");
        members.forEach( s::append );
        return s.toString();
    }

}
