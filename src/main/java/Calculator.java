public class Calculator {
    double value;
    int divider;

    Calculator(double value, int divider) {
        this.value = value;
        this.divider = divider;
    }

    double division() {
        return value / divider;
    }
}