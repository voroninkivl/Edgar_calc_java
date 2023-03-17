public class Reduction {

    int numerator_res;

    int denominator_res;

    public static int reduce(int numerator_res, int denominator_res) {
        numerator_res = Math.abs(numerator_res);
        denominator_res = Math.abs(denominator_res);
        if (numerator_res > 0 && denominator_res > 0) {
            while (numerator_res != denominator_res) {
                if (numerator_res > denominator_res){
                    numerator_res = numerator_res - denominator_res;
                }
                else denominator_res = denominator_res - numerator_res;
            }
            return numerator_res;
        } else return 1;
    }
}
