
public class Main {

    enum Level{
        LOW("Backyard", "Zombie Territory"){
            @Override
            public String asLowerCase(){
                return LOW.getName().toLowerCase();
            }
        },
        MIDDLE("Zombie Territory", "Everest"){
            @Override
            public String asLowerCase(){
                return MIDDLE.getName().toLowerCase();
            }
        },
        HIGH("Everest" , null){
            @Override
            public String asLowerCase(){
                return HIGH.getName().toLowerCase();
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

        for(Level l : Level.values())
            System.out.println(l.asLowerCase());

    }



}
