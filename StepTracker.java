import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {

    int targetStepsInDay;       //цель по количеству шагов за день.
    int passedNumberOfStepsPerDay;      //пройденное количество шагов за день.
    HashMap<String, ArrayList<Integer>> monthData;      //в хешмап по ключу(месяц) хранятся данные дней
    ArrayList<Integer> calendar;        //хранилище дней в месяце

    StepTracker(){      //конструктор класса StepTracker
        monthData = new HashMap<>();
        passedNumberOfStepsPerDay = 0;
        targetStepsInDay = 10_000;
        monthData.put("Январь", initArrayCalendar());
        monthData.put("Февраль", initArrayCalendar());
        monthData.put("Март", initArrayCalendar());
        monthData.put("Апрель", initArrayCalendar());
        monthData.put("Май", initArrayCalendar());
        monthData.put("Июнь", initArrayCalendar());
        monthData.put("Июль", initArrayCalendar());
        monthData.put("Август", initArrayCalendar());
        monthData.put("Сентябрь", initArrayCalendar());
        monthData.put("Октябрь", initArrayCalendar());
        monthData.put("Ноябрь", initArrayCalendar());
        monthData.put("Декабрь", initArrayCalendar());

    }
    ArrayList<Integer> initArrayCalendar(){     //инициализация массива днями
        calendar = new ArrayList<>();
        for (int i = 0; 30 > i; i++){
            calendar.add(passedNumberOfStepsPerDay);
        }
        return calendar;
    }
    public void savedSteps(String month, int day, int steps){       //Сохранение шагов за конкретный день месяца
        if (monthData.containsKey(month)){
            monthData.get(month).set((day - 1), steps);
            System.out.println("Данные сохранены.");
        } else {
            System.out.println("Название месяца введено неверно.");
        }
        if (steps < 0){
            System.out.println("Количество шагов должно быть больше нуля.");
        }
        if (day < 1 || day > 30 ){
            System.out.println("Введен неверный день, введите день от 1 до 30.");
        }
    }

    void changeTargetNumberOfSteps(int targetStepsInDay){       //Изменение целевого количества шагов
        if (targetStepsInDay < 0){
            System.out.println("Введенное значение должно быть неотрицательным");
        } else {
            this.targetStepsInDay = targetStepsInDay;
            System.out.println("Данные сохранены");
        }
    }

    public void printStatistics(String month){      //печать статистики
        int totalSumSteps = 0;      //общее количество шагов за месяц
        int maxSteps = 0;       //максимальное количество шагов
        int dayOfMaxSteps = 0;      //номер дня
        int bestSeres = 0;      //счетчик лучшей серии
        int tmpCurrentSeries = 0;       //счетчик временной лучшей серии

        if (monthData.containsKey(month)){
            for (int i =0; i < calendar.size();i++){
                int steps = monthData.get(month).get(i);
                if (i != 29){
                    System.out.println((i + 1) + " день " + steps + " шагов" +  ", ");
                } else {
                    System.out.println((i + 1) + " день " + steps + "\n");
                }
                totalSumSteps += steps;
                if (steps > maxSteps){
                    maxSteps = steps;
                    dayOfMaxSteps = i + 1;
                }
                if (steps > targetStepsInDay){
                    tmpCurrentSeries++;
                } else {
                    bestSeres = Math.max(bestSeres, tmpCurrentSeries);
                    tmpCurrentSeries = 0;
                }
            }
            int avgSteps = totalSumSteps / calendar.size();
            System.out.println("Общее количество шагов за месяц: " + totalSumSteps);
            System.out.println("Максимальное количество шагов - " + maxSteps +
                    " было пройдено в день номер " + dayOfMaxSteps);
            System.out.println("Среднее количество шагов в день " + avgSteps);
            Converter.convert(totalSumSteps);
            System.out.println("Лучшая серия " + bestSeres + " дней");
        } else {
            System.out.println("Название месяца введено неверно");
        }
    }






}
