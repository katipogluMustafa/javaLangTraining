import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Serializable{
    private static final long serialVersionUID = 1L;
    private static int nextID = 0;
    private String name, surname;
    private int id;
    private List<Contact> friends;
    private int friendsCount;

    public Contact(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.id = nextID++;
        this.friendsCount = 0;
        this.friends = new ArrayList<>();
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public List<Contact> getFriends(){return friends;}
    public int getFriendsCount(){return friendsCount;}

    public boolean updateName(String name){
        if(name == null || !name.matches("[A-Za-z]+"))
            return false;
        this.name = name;
        return true;
    }

    public boolean updateSurname(String surname){
        if(surname == null || !surname.matches("[A-Za-z]+"))
            return false;
        this.surname = surname;
        return true;
    }

    public boolean addFriend(Contact friend){
        if(id < 0 || id >= Contact.nextID )
            return false;
        friends.add(friend);
        return true;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(id).append(" ").append(name).append(" ").append(surname).append(" has ").append(friendsCount).append(" friends");
        return s.toString();
    }

}
