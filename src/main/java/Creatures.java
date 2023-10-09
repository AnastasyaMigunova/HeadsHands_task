import java.util.Random;

public abstract class Creatures {
    private final String name;
    private final int attack;
    private final int def;
    protected int healthPoint;
    private final int minDamage;
    private final int maxDamage;

    public Creatures(String name) {
        this.name = name;
        this.attack = getRandomNumber(1, 30);
        this.def = getRandomNumber(1, 30);
        this.healthPoint = Math.max(getRandomNumber(0, 100), 1);
        this.minDamage = getRandomNumber(1, 10);
        this.maxDamage = getRandomNumber(15, 30);
    }

    // метод, возвращающий случайное число из диапазона [min, max]
    private int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // геттер, возвращающий имя существа
    protected String getName(){
        return name;
    }

    protected int getHealthPoint(){
        return healthPoint;
    }

    // метод, проверяющий живо существо или нет
    public boolean isAlive() {
        return healthPoint > 0;
    }

    //метод, который реализует получение урона существом
    public void takingDamage(int damage) {
        if (damage > 0) {
            healthPoint -= damage;
            if (healthPoint < 0) {
                healthPoint = 0;
                System.out.println(name + " погиб!\n");
            }
        }
    }

    // метод, рассчитывающий удар существа
    public void successHit(Creatures defender) {
        // рассчет модификатора атаки
        int N = attack - (defender.def + 1);
        N = Math.max(N, 1);
        boolean success = false;

        // бросок N кубиков с цифрами от 1 до 6
        for(int i = 0; i < N; i++){
            int randomNumber = getRandomNumber(1, 6);
            // если на кубике выпало 5 или 6
            if(randomNumber >= 5) {
                // то удар считается успешным
                success = true;
                break;
            }
        }

        // если удар успешен
        if (success) {
            // то берется произвольное (случайное) число
            int attackerHit = getRandomNumber(minDamage, maxDamage);
            System.out.println("\n" + name + " нанес " + attackerHit + " урона!\n");
            // и атакующий наносит удар по существу
            defender.takingDamage(attackerHit);
        }
        // если удар неудачен, то ход атакующего пропускается
        else {
            System.out.println("\n" + name + " промахнулся!\n");
        }
    }

    // метод для вывода информации о существе
    public void printInfo() {
        System.out.println("Характеристики " + name + ":");
        System.out.println("Атака: " + attack);
        System.out.println("Защита: " + def);
        System.out.println("Здоровье: " + healthPoint);
        System.out.println("Урон: " + minDamage + "-" + maxDamage + "\n");
    }

}