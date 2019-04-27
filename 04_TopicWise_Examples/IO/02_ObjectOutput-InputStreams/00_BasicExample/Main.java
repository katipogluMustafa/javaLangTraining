import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args){
        Contact contact = new Contact("Mustafa","Katipoglu");
        contact.addFriend(new Contact("Ahmet","Koca"));
        contact.addFriend(new Contact("Yusuf","Sertan"));
        contact.addFriend(new Contact("Mert","Oz"));
        contact.addFriend(new Contact("Ali","Asaf"));
        List<Contact> friends;

        writeAsList(contact.getFriends(), "friendsAsList.dat");

        System.out.println("Reading one by one\n");

        System.out.println("Reading as List\n");
        friends = readAsList("friendsAsList.dat");
        if(friends != null)
            friends.forEach( System.out::println);
        else
            System.out.println("Friends list is null");

    }

    @SuppressWarnings("unchecked")
    private static List<Contact> readAsList(String s) {
        ArrayList<Contact> contacts;

        try( ObjectInputStream reader = new ObjectInputStream( new FileInputStream(s)) ){
            contacts = (ArrayList<Contact>)reader.readObject();
            if(contacts == null)
                return null;
            else
                return contacts;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }
    private static void writeAsList(List<Contact> friends, String fileName) {
        System.out.println("Writing As List\n");
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName,true))){
            writer.writeObject(friends);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Writing as List is done\n");
    }

}
