import java.util.Random;

public class  Monster extends Creatures {

    private static final String[] MONSTER_TYPES = {"Орк", "Чернокнижник", "Зомби", "Ведьма", "Разбойник"};

    public Monster(String name) {
        super(name);
    }

    public static Monster createMonster() {
        Random rand = new Random();
        String randomType = MONSTER_TYPES[rand.nextInt(MONSTER_TYPES.length)];
        return new Monster(randomType);
    }
}
