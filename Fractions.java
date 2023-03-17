public class Fractions {
    int numerator;
    int denominator;

    public Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public static String toString(Fractions fractions){
        return fractions.numerator + "/" + fractions.denominator;
    }

    public Fractions() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public static Fractions summarise(Fractions fr1, Fractions fr2) {
        Fractions result = new Fractions(fr1.numerator * fr2.denominator + fr2.numerator * fr1.denominator, fr1.denominator * fr2.denominator);
        return result;
    }

    public static Fractions substraction(Fractions fr1, Fractions fr2) {
        Fractions result = new Fractions(fr1.numerator * fr2.denominator - fr2.numerator * fr1.denominator, fr1.denominator * fr2.denominator);
        return result;
    }

    public static Fractions multiplication(Fractions fr1, Fractions fr2) {
        Fractions result = new Fractions(fr1.numerator * fr2.numerator, fr1.denominator * fr2.denominator);
        return result;
    }

    public static Fractions division(Fractions fr1, Fractions fr2) {
        Fractions result = new Fractions(fr1.numerator * fr2.denominator, fr2.numerator * fr1.denominator);
        return result;
    }
}
