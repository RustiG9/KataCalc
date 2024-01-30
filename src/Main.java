import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) {
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

        String[] rim = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] rim2 = new String[]{"I",
                "II",
                "III",
                "IV",
                "V",
                "VI",
                "VII",
                "VIII",
                "IX",
                "X",
                "XI",
                "XII",
                "XIII",
                "XIV",
                "XV",
                "XVI",
                "XVII",
                "XVIII",
                "XIX",
                "XX",
                "XXI",
                "XXII",
                "XXIII",
                "XXIV",
                "XXV",
                "XXVI",
                "XXVII",
                "XXVIII",
                "XXIX",
                "XXX",
                "XXXI",
                "XXXII",
                "XXXIII",
                "XXXIV",
                "XXXV",
                "XXXVI",
                "XXXVII",
                "XXXVIII",
                "XXXIX",
                "XL",
                "XLI",
                "XLII",
                "XLIII",
                "XLIV",
                "XLV",
                "XLVI",
                "XLVII",
                "XLVIII",
                "XLIX",
                "L",
                "LI",
                "LII",
                "LIII",
                "LIV",
                "LV",
                "LVI",
                "LVII",
                "LVIII",
                "LIX",
                "LX",
                "LXI",
                "LXII",
                "LXIII",
                "LXIV",
                "LXV",
                "LXVI",
                "LXVII",
                "LXVIII",
                "LXIX",
                "LXX",
                "LXXI",
                "LXXII",
                "LXXXIII",
                "LXXIV",
                "LXXV",
                "LXXVI",
                "LXXVII",
                "LXXVIII",
                "LXXXIX",
                "LXXX",
                "LXXXI",
                "LXXXII",
                "LXXXIII",
                "LXXXIV",
                "LXXXV",
                "LXXXVI",
                "LXXXVII",
                "LXXVIII",
                "LXXXIX",
                "XC",
                "XCI",
                "XII",
                "XIII",
                "XCIV",
                "XCV",
                "XCVI",
                "XVII",
                "XCVIII",
                "ХХIХ",
                "C"};

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
                    if (ifRim) {
                        return rim2[Integer.parseInt(num[0]) + Integer.parseInt(num[2])-1];
                    } else {
                        return String.valueOf(Integer.parseInt(num[0]) + Integer.parseInt(num[2]));
                    }
                case "-":
                    otvet = Integer.parseInt(num[0]) - Integer.parseInt(num[2]);
                    if (ifRim) {
                        if (otvet < 0) {
                            throw new Exception("Нет римских чисел меньше нуля");
                        } else {
                            return rim2[Integer.parseInt(num[0]) - Integer.parseInt(num[2])-1];
                        }
                    } else {
                        return String.valueOf(Integer.parseInt(num[0]) - Integer.parseInt(num[2]));
                    }
                case "*":
                    if (ifRim) {
                        return rim2[Integer.parseInt(num[0]) * Integer.parseInt(num[2])-1];
                    } else {
                        return String.valueOf(Integer.parseInt(num[0]) * Integer.parseInt(num[2]));
                    }
                case "/":
                    if (ifRim) {
                        return rim2[Integer.parseInt(num[0]) / Integer.parseInt(num[2])-1];
                    } else {
                        return String.valueOf(Integer.parseInt(num[0]) / Integer.parseInt(num[2]));
                    }
                default:
                    throw new Exception("Введите правильный операнд");
            }
        } else {
            throw new Exception("введите число меньше 10");
        }
    }
}

