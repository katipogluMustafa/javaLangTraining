package PlayGround;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MemoryManagement {
    private static int nextAddr = 0;
    private Queue<Integer> availableAddr;
    private Map<Integer,Process> processes;

    public MemoryManagement(){
        availableAddr = new ArrayDeque<>();
        processes = new HashMap<>();
    }

    public void addProcess(Process p){
        Integer nextAddress;
        if( availableAddr != null)
            nextAddress = availableAddr.poll();

        if( nextAddress != null)
            processes.put( nextAddress ,p);
        else
            processes.put(nextAddr++, p);
    }

    public Process removeProcess(Integer id){
        Process s;
        if( processes != null)
            s = processes.remove(id);
        if( s != null && availableAddr != null)
            availableAddr.add(id);
        System.out.println("******************************************** " + id + " nolu adresteki process çıkarıldi");
        return s;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Boş Yerler: ");
        availableAddr.forEach( i->{
            s.append(i);
            s.append(", ");
        } );
        s.append("\nDolu Yerler: \n");
        for( Map.Entry<Integer, Process> e : processes.entrySet() ){
            s.append(e.getKey());
            s.append(" -> ");
            s.append(e.getValue().getName());
            s.append(" numaralı process bellekte\n");
        }
        return s.toString();
    }




}
