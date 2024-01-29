import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(calc(reader.readLine()));
        } catch (Exception e) {
            System.out.println("что-то пошло не так");
            e.printStackTrace();
        }
    }


    public static String calc(String input) throws Exception {
        String[] num = input.split(" ");
        int otvet;
        boolean firsRimNum = false;
        boolean secondRimNum = false;
        boolean ifRim = false;

        if (num.length > 3) {
            throw new Exception("Введено больше двух значений");
        }

        String[] rim = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI", "X"};

        for (int i = 0; i < rim.length; i++) {

            if (num[0].equals(rim[i])) {
                num[0] = String.valueOf(i + 1);
                firsRimNum = true;
            }
            if (num[2].equals(rim[i])) {
                num[2] = String.valueOf(i + 1);
                secondRimNum = true;
            }
        }

        if (firsRimNum & secondRimNum) {
            firsRimNum = false;
            secondRimNum = false;
            ifRim = true;
        }

        if (firsRimNum | secondRimNum) {
            throw new Exception("Введите только римские или арабские цифры");
        }

        if (!(Integer.parseInt(num[0]) > 10) & !(Integer.parseInt(num[2]) > 10)) {
            switch (num[1]) {
                case "+":
                    return String.valueOf(Integer.parseInt(num[0]) + Integer.parseInt(num[2]));

                case "-":
                    otvet = Integer.parseInt(num[0]) - Integer.parseInt(num[2]);
                    if (otvet < 0 & ifRim) {
                        throw new Exception("Нет римских чисел меньше нуля");
                    }
                    return String.valueOf(Integer.parseInt(num[0]) - Integer.parseInt(num[2]));

                case "*":
                    return String.valueOf(Integer.parseInt(num[0]) * Integer.parseInt(num[2]));

                case "/":
                    return String.valueOf(Integer.parseInt(num[0]) / Integer.parseInt(num[2]));

                default:
                    throw new Exception("Введите правильный операнд");
            }
        } else {
            throw new Exception("введите число меньше 10");
        }
    }
}

