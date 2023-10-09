public class Player extends Creatures {
    private final int maxHealth;
    private int healCount = 4;
    public Player(String name) {
        super(name);
        this.maxHealth = healthPoint;
    }

    //метод, который позволяет Игроку исцелить себя
    // на 30% процентов от максимального здоровья
    public void heal() {
        if (healCount > 0) {
            int currentHealth = (int) (healthPoint + maxHealth * 0.3);
            healthPoint = Math.min(maxHealth, currentHealth);
            healCount--;
            System.out.println("Вы исцелились. Осталось исцелений: " + healCount + "\n");
        }
        else {
            System.out.println("Исцелить себя больше нельзя!\n");
        }
    }
}
