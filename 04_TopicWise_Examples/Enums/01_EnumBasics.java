package PlayGround;

import java.util.Random;

public class Main {

    enum Level{
        LOW,
        MIDDLE,
        HIGH
    }

    public static void main(String[] args) {
        System.out.print("Difficulty Options: ");
        for(Level level : Level.values())
            System.out.print(level + " ");

        System.out.print("\nCurrent ");
        Level difficulty = getRandomLevel();
        switch(difficulty){
            case LOW:
                System.out.println("Difficulty: " + Level.LOW);
                break;
            case MIDDLE:
                System.out.println("Difficulty: " + Level.MIDDLE);
                break;
            case HIGH:
                System.out.println("Difficulty: " + Level.HIGH);
                break;
            default:
                System.out.println("Error");
        }

        System.out.println("Value of HIGH is " + Level.valueOf("HIGH"));
    }

    private static Level getRandomLevel(){
        Random random = new Random();
        Level returnValue;
        switch ( random.nextInt() % 3){
            case 0:
                returnValue = Level.LOW;
                break;
            case 1:
                returnValue = Level.MIDDLE;
                break;
            case 2:
                returnValue = Level.HIGH;
                break;
            default:
                returnValue = Level.MIDDLE;
        }

        return returnValue;
    }

}
