package PlayGround;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        var words = new HashSet<String>();      //10ms
        //var words = new LinkedList<String>();  // 4ms

        long totalTime = 0;

        try (var in = new Scanner(System.in))
        {
            while (in.hasNext())
            {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }

}

