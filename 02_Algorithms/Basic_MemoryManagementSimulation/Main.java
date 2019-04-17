package PlayGround;

public class Main {
    public static void main(String[] args) {
        MemoryManagement d = new MemoryManagement();
        Process pA = new Process ( "Process-A" ) ;
        Process pB = new Process ( "Process-B" ) ;
        Process pC = new Process ( "Process-C" ) ;
        Process pD = new Process ( "Process-D" ) ;
        d . addProcess ( pA ) ;
        d . addProcess ( pB ) ;
        d . addProcess ( pC ) ;
        d . addProcess ( pD ) ;

        System.out.println(d);
        d.removeProcess(2);
        System.out.println(d);
        d.removeProcess(3);
        System.out.println(d);
        d.removeProcess(1);
        System.out.println(d);

        d.addProcess(pD);
        System.out.println(d);
        d.addProcess(pB);
        System.out.println(d);

    }
}

