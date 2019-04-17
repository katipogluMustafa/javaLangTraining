public class InitArray {
    // create and output two-dimensional arrays
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for(int i = 0; i < arr.length; i++)
            for( int j = 0; j < arr[i].length; j++)
                arr[i][j] = i+j;

        System.out.println("Using For");
        for (int i = 0; i < arr.length;i++) {
            for (int j = 0; j < arr[i].length;j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }



        System.out.println("\nUsing for-each");
        for(int[] rows : arr) {
            for (int i : rows)
                System.out.print( i + " ");
            System.out.println();
        }
    }


}