import java.io.File;
import java.io.IOException;


public class Test {

    public static void main(String... args){
        File file = new File("myNewFile.txt");
        try{
            if( file.createNewFile() )
                System.out.println("File Successfully created");
            else
                System.out.println("Error, File Already Exists");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
