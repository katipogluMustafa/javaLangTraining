package PlayGround;

import java.util.Random;

public class Main {

    enum Level{
        LOW("Backyard", "Zombie Territory"),
        MIDDLE("Zombie Territory", "Everest"),
        HIGH("Everest" , null);

        private String name;
        private final String nextLevel;

        private Level(String name, String nextLevel){
            this.name = name;
            this.nextLevel = nextLevel;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNextLevel() {
            return nextLevel;
        }
    }

    public static void main(String[] args) {
        Level currentLevel = Level.valueOf( getRandomLevel() );
        System.out.println( currentLevel.getName() );
        currentLevel.setName("Uuu");                                // Do not update !, as you can see kinda dangerous
        System.out.println( currentLevel.getName() );
        Level level = Level.valueOf( currentLevel.toString() );
        System.out.println(level.getName());                       // as you can see kinda dangerous

        for( Level l : Level.values())
            System.out.println(l.getName() + " comes before " + l.getNextLevel());

    }

    private static String getRandomLevel(){
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

        return returnValue.toString();
    }

}
