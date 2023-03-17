import java.util.Objects;
import java.util.regex.*;
public class Calculator {
    public static String operations(String exp) {
        String arr[] = new String[exp.split(" ").length];
        String arr_fr[] = new String[2];
        Fractions fr1, fr2;
        int index = 1;
        arr = exp.split(" ");
        while (exp.contains("*")) {
            arr = exp.split(" ");
            if (Objects.equals(arr[index], "*")) {
                arr_fr = arr[index - 1].split("/");
                fr1 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr_fr = arr[index + 1].split("/");
                fr2 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr[index] = Fractions.toString(Fractions.multiplication(fr1, fr2));
                String arr_str = String.join(" ", arr);
                arr_str = arr_str.replace(arr[index - 1] + " ", "");
                arr_str = arr_str.replace(" " + arr[index + 1], "");
                exp = arr_str;

            }
            else
                index += 2;
        }
        index = 1;
        while (exp.contains(":")) {
            arr = exp.split(" ");
            if (Objects.equals(arr[index], ":")) {
                arr_fr = arr[index - 1].split("/");
                fr1 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr_fr = arr[index + 1].split("/");
                fr2 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr[index] = Fractions.toString(Fractions.division(fr1, fr2));
                String arr_str = String.join(" ", arr);
                arr_str = arr_str.replace(arr[index - 1] + " ", "");
                arr_str = arr_str.replace(" " + arr[index + 1], "");
                exp = arr_str;

            }
            else
                index += 2;

        }
        index = 1;
        while (exp.contains(" - ")) {
            arr = exp.split(" ");
            if (Objects.equals(arr[index], "-")) {
                arr_fr = arr[index - 1].split("/");
                fr1 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr_fr = arr[index + 1].split("/");
                fr2 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr[index] = Fractions.toString(Fractions.substraction(fr1, fr2));
                String arr_str = String.join(" ", arr);
                arr_str = arr_str.replace(arr[index - 1] + " ", "");
                arr_str = arr_str.replace(" " + arr[index + 1], "");
                exp = arr_str;

            } else
                index += 2;
        }
        index = 1;
        while (exp.contains("+")) {
            arr = exp.split(" ");
            if (Objects.equals(arr[index], "+")) {
                arr_fr = arr[index - 1].split("/");
                fr1 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr_fr = arr[index + 1].split("/");
                fr2 = new Fractions(Integer.parseInt(arr_fr[0]), Integer.parseInt(arr_fr[1]));
                arr[index] = Fractions.toString(Fractions.summarise(fr1, fr2));
                String arr_str = String.join(" ", arr);
                arr_str = arr_str.replace(arr[index - 1] + " ", "");
                arr_str = arr_str.replace(" " + arr[index + 1], "");
                exp = arr_str;

            } else
                index += 2;
        }
        return exp;
    }
    public static String brackets(String exp){
        Pattern pt_brackets = Pattern.compile("\\([+\\-:*/ 0-9]{1,}\\)");
        while (exp.contains("(") && exp.contains(")")){
            Matcher mt_brackets = pt_brackets.matcher(exp);
            String exp_brackets;
            while (mt_brackets.find()){
                exp_brackets = mt_brackets.group();
                exp = exp.replace(exp_brackets, operations(exp.substring(exp.indexOf("(") + 1, exp.indexOf(")"))));
            }
        }
        return exp;
    }
}

