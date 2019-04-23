import java.io.File;
import java.io.IOException;


public class Test {

    public static void main(String... args){
        File oldFile = new File("myOldFile.txt");
        File newFile = new File("myNewlyNamedFile.txt");
        try{
            oldFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        if( oldFile.renameTo(newFile) )
            System.out.println(oldFile.getName() + " file renamed. New Name is: " +  newFile.getName());
        else
            System.out.println("Error, can't rename");

    }

}
