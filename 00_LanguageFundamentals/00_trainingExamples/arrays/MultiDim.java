public class MultiDim{

public static int M = 20;
public static int N = 15;

  public static void main(String[] args){
  
  int[][] a = new int[M][N];

  for(int i = 0; i < M; i++) 
    for(int j = 0; j < N; j++)
      a[i][j] = i*j;

  for(int i = 0; i < M; i++){ 
    for(int j = 0; j < N; j++)
      System.out.printf("%d   ",a[i][j]);
    System.out.printf("\n");
  }
 
  }
  

}
