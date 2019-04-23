package PlayGround;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String... args){
        File file = new File("Input.txt");
        if( file.exists() )
            System.out.println(getContent(file));
    }

    public static String getContent(File file){
        StringBuilder s = new StringBuilder();
        try{
            Scanner scan = new Scanner(file);
            while( scan.hasNextLine())
                s.append(scan.nextLine()).append("\n");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return s.toString();
    }

}
