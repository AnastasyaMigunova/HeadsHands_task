import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя игрока: ");

        String playerName;

        do {
            playerName = scanner.nextLine();
            if (playerName.equals(""))
                System.out.println("Имя игрока не может быть пустым! Введите его!");
        }
        while(playerName.equals(""));

        Player player = new Player(playerName);
        Monster monster = Monster.createMonster();

        int turn = 1;

        // вывод информации об игроке и монстре
        player.printInfo();
        monster.printInfo();

        // пока игрок жив - игра продолжается
        while (player.isAlive()) {

            System.out.println("\nХод " + turn + ":");
            System.out.println("Здоровье игрока " + playerName + ": " + player.getHealthPoint());

            System.out.println("Здоровье монстра: " + monster.getHealthPoint());

            // Начало хода
            // если ход игрока ему предоставляется выбор в действиях
            if (turn % 2 == 1) {
                int choice;
                System.out.println("\n-----Ваш ход-----");
                System.out.print("Выберите действие: \n1 - Атаковать \n2 - Исцелиться \n\n");
                System.out.print("Ваш выбор: ");

                if(scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> player.successHit(monster);
                        case 2 -> player.heal();
                        default -> System.out.println("Неверный выбор. Вы пропускаете ход.");
                    }
                }
                else
                    System.out.println("Неверный выбор. Вы пропускаете ход.");

                scanner.nextLine(); // Очистка буфера ввода

                if (!monster.isAlive()) {
                    monster = Monster.createMonster();
                    System.out.println("\nВаш новый противник: " + monster.getName());
                }
            }

            else {
                System.out.println("\n-----Атака монстра-----");
                monster.successHit(player);
            }

            if (!player.isAlive()) {
                System.out.println(playerName + " проиграл. Игра окончена.");
                break;
            }

            turn++;
        }

        scanner.close();
    }
}
