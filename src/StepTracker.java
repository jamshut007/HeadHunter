import java.util.HashMap;

public class StepTracker {
    int stepNorm = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    Converter converter = new Converter();

    public StepTracker() {
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    void changeSteps(int stepsDay) {
        if (stepsDay >= 0) {
            stepNorm = stepsDay;
            print("Сейчас целевое количество шагов " + stepNorm);
        } else {
            print("Введено отрицательное значение!");
        }
    }

    int saveStepsDay(int month, int day, int steps) {
        MonthData monthValue = monthToData.get(month);
        monthValue.monthData[day - 1] = steps;
        return monthValue.monthData[day - 1];
    }

    void printMonthlyStepStatistic(int monthStatistic) {
        MonthData monthValue = monthToData.get(monthStatistic);
        for (int i = 0; i < 30; i++) {
            int day = i + 1;
            print(day + " день: " + monthValue.monthData[i]);
        }
    }

    void printTotalNumberOfStepsInMonth(int monthStatistic) {
        MonthData monthValue = monthToData.get(monthStatistic);
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += monthValue.monthData[i];
        }
        print("Общее количество шагов за месяц " + sum);
    }

    void printMaximumNumberOfStepsInMonth(int monthStatistic) {
        MonthData monthValue = monthToData.get(monthStatistic);
        int max = 0;
        for (int i = 0; i < 30; i++) {
            if (max < monthValue.monthData[i]) {
                max = monthValue.monthData[i];
            }
        }
        print("Максимальное пройденное количество шагов в месяце " + max);
    }

    void printAverageNumberOfStepsInMonth(int monthStatistic) {
        MonthData monthValue = monthToData.get(monthStatistic);
        double average = 0;
        for (int i = 0; i < 30; i++) {
            average += monthValue.monthData[i];
        }
        average /= 30;
        print("Среднее количество шагов " + average);
    }

    void printDistanceTraveledInMonth(int monthStatistic) {
        MonthData monthValue = monthToData.get(monthStatistic);
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += monthValue.monthData[i];
        }
        print("Пройденная дистанция (в км) " + converter.convertDistance(sum));
    }

    void printNumberOfCaloriesBurnedInMonth(int monthStatistic) {
        MonthData monthValue = monthToData.get(monthStatistic);
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += monthValue.monthData[i];
        }
        print("Количество сожжённых килокалорий " + converter.convertCalories(sum));
    }

    void printBestSeriesInMonth(int monthStatistic) {
        MonthData monthValue = monthToData.get(monthStatistic);
        int maxDays = 0;
        int numbersOfDays = 0;
        for (int i = 0; i < 30; i++) {
            if (monthValue.monthData[i] >= stepNorm) {
                numbersOfDays += 1;
            } else if (maxDays < numbersOfDays) {
                maxDays = numbersOfDays;
                numbersOfDays = 0;
            } else {
                numbersOfDays = 0;
            }
        }
        if (maxDays < numbersOfDays) {
            print("Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого " + numbersOfDays);
        } else {
            print("Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого " + maxDays);
        }
    }

    void outputOfStatistics(int userSelection, int monthIndex) {
        if (userSelection == 1) {
            printMonthlyStepStatistic(monthIndex);
        } else if (userSelection == 2) {
            printTotalNumberOfStepsInMonth(monthIndex);
        } else if (userSelection == 3) {
            printMaximumNumberOfStepsInMonth(monthIndex);
        } else if (userSelection == 4) {
            printAverageNumberOfStepsInMonth(monthIndex);
        } else if (userSelection == 5) {
            printDistanceTraveledInMonth(monthIndex);
        } else if (userSelection == 6) {
            printNumberOfCaloriesBurnedInMonth(monthIndex);
        } else if (userSelection == 7) {
            printBestSeriesInMonth(monthIndex);
        } else {
            print("Такой команды нет!");
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }
} 