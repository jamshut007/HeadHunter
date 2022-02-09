public class Converter {

    double convertDistance(int steps) {
        double step = 0.00075;
        return step * steps;
    }

    double convertCalories(int steps) {
        double step = 0.05;
        return step * steps;
    }
}
