
public class Converter {

final static double lengthStep = 0.75d;     //километры
final static double calorieStep = 50d;      //килокалории
    static void convert(int steps){
        System.out.println("Пройденная дистанция в километрах равна " + (steps * lengthStep) / 1000);
        System.out.println("Количество сожженных килокалорий " + (steps * calorieStep) / 1000);
    }
}
