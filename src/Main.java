import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker userStep = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Укажите номер месяца от 1 до 12:");
                int month = scanner.nextInt();
                System.out.println("Укажите номер дня от 1 до 30:");
                int day = scanner.nextInt();
                System.out.println("Укажите количество шагов:");
                int steps = scanner.nextInt();
                if (steps >= 0) {
                    System.out.println(userStep.saveStepsDay(month, day, steps));
                } else {
                    System.out.println("Вы ввели отрицательное число!");
                }
            } else if (userInput == 2) {
                System.out.println("Введите месяц от 1 до 12:");
                int monthIndex = scanner.nextInt();
                printMenuStatistic();
                int userSelection = scanner.nextInt();
                userStep.outputOfStatistics(userSelection, monthIndex);
            } else if (userInput == 3) {
                System.out.println("Сейчас целевое количество шагов " + userStep.stepNorm + ". Введите цель по количеству шагов в день:");
                int stepsDay = scanner.nextInt();
                if (stepsDay >= 0) {
                    userStep.changeSteps(stepsDay);
                } else {
                    System.out.println("Вы ввели отрицательное число!");
                }
            } else {
                System.out.println("Такой команды нет!");
            }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что выберете?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

    private static void printMenuStatistic() {
        System.out.println("Что выберете?");
        System.out.println("1 - Количество пройденных шагов по дням");
        System.out.println("2 - Общее количество шагов за месяц");
        System.out.println("3 - Максимальное пройденное количество шагов в месяце");
        System.out.println("4 - Среднее количество шагов");
        System.out.println("5 - Пройденная дистанция (в км)");
        System.out.println("6 - Количество сожжённых килокалорий");
        System.out.println("7 - Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого");
        System.out.println("0 - Выйти из этого меню");
    }
}