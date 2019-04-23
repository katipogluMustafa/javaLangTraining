package PlayGround;

public abstract class Customer {
    private int id;
    private String name;
    private String surname;
    private int points;
    private int contractedShoppingCount;
    private int pointsGained = 0;

    public Customer(int id, String name, String surname, int points, int contractedShoppingCount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.points = points;
        this.contractedShoppingCount = contractedShoppingCount;
    }

    public abstract void doShopping(int cost);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPoints() {
        return points;
    }

    public int getContractedShoppingCount() {
        return contractedShoppingCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public boolean deletePoints(int pointsToDelete){
        if( pointsToDelete > this.points ) {
            return false;
        }

        this.points -= pointsToDelete;
        return true;
    }

    public void decrementContractedShoppingCount() {
        this.contractedShoppingCount -= 1;
    }

    public int getPointsGained() {
        return pointsGained;
    }

    public void gainPoints(int point){
        addPoints(point);
        this.pointsGained += points;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("ID= ").append(id).append(" Name = ").append(name).append(" Surname = ").append(surname).append(" ").append(points).append(" Points").append("Contracted Shopping Count = ").append(contractedShoppingCount);
        return s.toString();
    }


}
