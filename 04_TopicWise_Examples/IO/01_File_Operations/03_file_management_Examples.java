
import java.io.File;
import java.io.IOException;


public class Test {

    public static void main(String... args){

        File file = new File("myFile.txt");
        if( file.exists() )
            System.out.println("File Exists");
        else {
            System.out.println("File doesn't exists");
            try{
                System.out.println("Let's then create the file");
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if( file.isFile() )
            System.out.println("This is a file not a folder");
        else if( file.isDirectory() )
            System.out.println("This is a directory not a file");

        File folder = file.getParentFile();
        try {
            if (folder != null && folder.isDirectory())
                System.out.println(folder.getCanonicalPath());
        }catch (IOException e){
            e.printStackTrace();
        }

        if( file.canRead() )
            System.out.println("We can read from the file");
        if( file.canWrite())
            System.out.println("We can actually wirte to the file");
        if( file.canExecute() )
            System.out.println("We can even execute it");

        File newFile = new File("Deneme/Inner/Directories/Deneme.txt");
        newFile.mkdirs();

        try {
            newFile.delete();
            file.delete();
            folder.delete();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

}
