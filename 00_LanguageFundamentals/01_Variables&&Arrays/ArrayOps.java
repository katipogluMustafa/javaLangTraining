
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,6,4,2,5,3,1};
        Arrays.sort(arr);
        printArr(arr);

        arr = new int[10];
        Arrays.fill(arr,5);
        printArr(arr);

        int[] newArr = new int[arr.length];
        System.arraycopy(arr,0,newArr,0,arr.length);
        printArr(newArr);

        if( Arrays.equals(arr,newArr) )
            System.out.println("Arrays are Equal to each other");
        else
            System.out.println("Arrays are not equal to each other");

        if( Arrays.binarySearch(newArr,5) >= 0 )
            System.out.println("Found");
        else
            System.out.println("Not Found");

    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
