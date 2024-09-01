import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Добро пожаловать в приложение \"Счётчик калорий\"!");
        System.out.println();
        System.out.println("-Приложение способно зафиксировать количество пройденных шагов за определенный день.\n" +
                "-Приложение способно напечатать статистику по шагам за определенный месяц.\n" +
                "-Приложение способно изменить цель по количеству шагов в new день(Изначальная цель - 10000 шагов).");
        System.out.println();
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1){
                System.out.println("Введите название нужного месяца в формате:" +
                        " \"Январь\", \"Февраль\", \"Март\", \"Апрель\", \"Май\", \"Июнь\"," +
                        " \"Июль\", \"Август\", \"Сентябрь\", \"Октябрь\", \"Ноябрь\", \"Декабрь\"");

                String month = scanner.next();
                System.out.println("Введите число от 1 до 30");
                int day = scanner.nextInt();
                System.out.println("Введите количество  пройденных шагов");
                int steps = scanner.nextInt();
                stepTracker.savedSteps(month, day, steps);

            } else if (command == 2) {
                System.out.println("Введите название месяца в формате: \"Январь\", \"Февраль\" и т.д");
                String month = scanner.next();
                stepTracker.printStatistics(month);
            } else if (command == 3) {
                System.out.println("Введите требуемое количество шагов");
                int targetStepCount = scanner.nextInt();
                stepTracker.changeTargetNumberOfSteps(targetStepCount);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Введенная команда отсутствует");
            }

        }
    }

    public static void printMenu(){     //вывод меню выбора
        System.out.println("""
                Что вы хотите сделать?
                 
                Введите число, соответствующее пункту меню;
                                
                1 - Ввести количество шагов за определённый день
                2 - Напечатать статистику за определённый месяц
                3 - Изменить цель по количеству шагов в день
                0 - Выйти из приложения
                """);
    }
}