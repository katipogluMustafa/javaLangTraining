
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Member> members = new HashMap<>();
        Member mustafa = new Member("Mustafa", "Katipoglu",20);
        Member ayse = new Member("Ayse", "Terim",35);
        Member gokhan = new Member("Gokhan", "Unknown",40);
        Member banu = new Member("Banu", "Unknown",60);
        Member ahmet = new Member("Ahmet", "Ko",25);
        Member yusuf = new Member("Yusuf", "Sertan",20);
        Member mert = new Member("Mert", "Oz",20);
        Member ugur = new Member("Ugur", "Gun",19);
        Member muhammed = new Member("Muhammed", "Demirci",32);
        Member abdullah = new Member("Abdullah", "Yaz",35);
        Member memhet = new Member("Mehmet", "Korkmaz",57);

        for(Member m: getMembers())
            members.put(m.getId(), m);

        // Map Traversal 1
        System.out.println("\nTraversal using Map.Entry:\n");
        for(Map.Entry<Integer,Member> entry : members.entrySet()){
            Member m = entry.getValue();
            System.out.println(entry.getKey() + " " + m.getName() + " " + m.getSurname() + " " + m.getAge() + " ");
        }

        // Map Traversal 2
        System.out.println("\nTraversal using Lambda Expression:\n");
        members.forEach( (i,m)->{
            System.out.println( i + " " + m.getName() + " " + m.getSurname() + " " + m.getAge() + " ");
        });

        // Map Traversal 3
        System.out.println("\nTraversal using get method of Map:\n");
        int maxId = Member.getNextId();
        for( int i = 0; i < maxId; i++){
            Member m = members.get(i);
            System.out.println( i + " " + m.getName() + " " + m.getSurname() + " " + m.getAge() + " ");
        }

        // Map Traversal 4
        System.out.println("\nTraversal using keySet:\n");
        for( Integer id : members.keySet() ) {
            Member m = members.get(id);
            System.out.println( id + " " + m.getName() + " " + m.getSurname() + " " + m.getAge() + " ");
        }


    }

    public static List<Member> getMembers(){
        return Member.getMembers();
    }

}

class Member{
    private static List<Member> members;

    static{
        members = new LinkedList<>();
    }

    private static int nextId = 0;
    private int id;

    private String name;
    private String surname;
    private int age;
    private String profile_photo;

    private boolean isDoctor = false;

    private int friendsCount = 0;
    private int[] friends;

    public Member(String name, String surname, int age) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.age = age;
        members.add(this);
    }

    public Member(String name, String surname, int age, String profile_photo) {
        this(name,surname,age);
        this.profile_photo = profile_photo;
    }

    public Member(String name, String surname, int age, String profile_photo, boolean isDoctor) {
        this(name,surname,age,profile_photo);
        this.isDoctor = isDoctor;
    }

    public void addFriend(int id){
        if( Member.nextId > id)
            friends[friendsCount++] = id;
    }

    public Member getMember(int id){
        for(Member m : members)
            if(m.getId() == id)
                return m;

        return null;
    }

    public void printFriends(){
        for(int i = 0; i < friendsCount; i++){
            Member m = getMember(this.friends[i]);
            System.out.println( m.getId() + " " + m.getName() + " " + m.getSurname() + " " + m.getAge() + "Number Of Friends: " + m.friendsCount);
        }
    }

    public int[] getFriends() {
        return friends;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean updateName(String name) {
        if( name.length() < 6)
            return false;

        this.name = name;
        return true;
    }

    public String getSurname() {
        return surname;
    }

    public boolean updateSurname(String surname) {
        if( surname.length() < 6)
            return false;

        this.surname = surname;
        return true;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if( age < 0 || age > 150 )
            return false;

        this.age = age;
        return true;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    public static List<Member> getMembers() {
        return members;
    }

    public static int getNextId() {
        return nextId;
    }
}