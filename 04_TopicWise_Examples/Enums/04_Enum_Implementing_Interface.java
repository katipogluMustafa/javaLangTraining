
public class Main {

    enum Level implements GameLevel{
        LOW("Backyard", "Zombie Territory"){
            @Override
            public String asLowerCase(){
                return LOW.getName().toLowerCase();
            }

            @Override
            public Level getLevel(){
                return this;
            }

            @Override
            public double getReward(){
                return 660.0;
            }

            @Override
            public String getDescription(){
                return "Playing with baby zombies at the backyard...";
            }

        },
        MIDDLE("Zombie Territory", "Everest"){
            @Override
            public String asLowerCase(){
                return MIDDLE.getName().toLowerCase();
            }

            @Override
            public Level getLevel(){
                return this;
            }

            @Override
            public double getReward(){
                return 990.0;
            }

            @Override
            public String getDescription(){
                return "Running around zombie territory with non-stopping fashion. Don't forget jus for professionals can make this level...";
            }
        },

        HIGH("Everest" , null){
            @Override
            public String asLowerCase(){
                return HIGH.getName().toLowerCase();
            }

            @Override
            public Level getLevel(){
                return this;
            }

            @Override
            public double getReward(){
                return 5000.0;
            }

            @Override
            public String getDescription(){
                return "Mountain advanture with highly skilled zombies. Even Professionals may not make it here. Don't forget jus for Master Class Players can make this level...";
            }
        };

        private final String name;
        private final String nextLevel;

        private Level(String name, String nextLevel){
            this.name = name;
            this.nextLevel = nextLevel;
        }

        public String getName() {
            return name;
        }

        public String getNextLevel() {
            return nextLevel;
        }

        // Notice the abstract method declaration at the bottom of the enum class.
        public abstract String asLowerCase();
    }

    public static void main(String[] args) {

        System.out.println("Levels: ");
        for(Level l : Level.values()) {
            System.out.print("\t" + l.asLowerCase() + " : ");
            System.out.println( l.levelDetails() );
        }

    }

}

interface GameLevel{
    Main.Level getLevel();
    double getReward();
    String getDescription();

    default String levelDetails(){
        StringBuilder details = new StringBuilder();
        details.append("\n\t\tLevel Details : ").append(getDescription()).append("\n\t\t");
        details.append("Difficulty: ").append(getLevel()).append(".\n\t\tHas ").append(getReward()).append("$ cash reward for the winner.");
        return details.toString();
    }
}
