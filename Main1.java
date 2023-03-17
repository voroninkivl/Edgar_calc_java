import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        try {
            System.out.println("Введите выражение");
            Scanner in = new Scanner(System.in);
            String exp = in.nextLine();
            in.close();
            if (exp.contains("(") && exp.contains(")")){
            Fractions fr1, fr2;
            String arr_res[] = new String[2];
            exp = Calculator.brackets(exp);
            arr_res = Calculator.operations(exp).split("/");
            int res_num = Integer.parseInt(arr_res[0]);
            int res_den = Integer.parseInt(arr_res[1]);
            int diviver = Reduction.reduce(res_num, res_den);
            if (res_den == 0){
                System.out.println("Ошибка. Деление на 0");
            }
            if (res_den / diviver == 1) {
                System.out.println(res_num / diviver);
            } else {
                if (res_num == 0) {
                    System.out.println("0");
                } else {
                    System.out.println(res_num / diviver + "/" + res_den / diviver);
                }
            }
          }
            else {
                Fractions fr1, fr2;
                String arr_res[] = new String[2];
                arr_res = Calculator.operations(exp).split("/");
                int res_num = Integer.parseInt(arr_res[0]);
                int res_den = Integer.parseInt(arr_res[1]);
                int diviver = Reduction.reduce(res_num, res_den);
                if (res_den == 0){
                    System.out.println("Ошибка. Деление на 0");
                    System.exit(0);
                }
                if (res_den / diviver == 1) {
                    System.out.println(res_num / diviver);
                }
                else {
                    if (res_num == 0) {
                        System.out.println("0");
                    }
                    else {
                        System.out.println(res_num / diviver + "/" + res_den / diviver);
                    }
                }
            }
            }
        catch (Exception e) {
            System.out.println("Ошибка. Некорректное выражение");
        }
    }
}



