import java.util.Scanner;

public class main {
        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите выражение в арабских или римских цифрах: ");
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }

        public static String calc(String input) throws Exception {
            int x;
            int y;
            String operation;
            String result;
            boolean isRoman;
            String[] operands = input.split("[+\\-/*]");
            if (operands.length != 2) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            operation = detectOperation(input);
            if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
                x = Roman.convertToArabian(operands[0]);
                y = Roman.convertToArabian(operands[1]);
                isRoman = true;
            } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
                x = Integer.parseInt(operands[0]);
                y = Integer.parseInt(operands[1]);
                isRoman = false;
            } else {
                throw new Exception("Используются одновременно разные системы счисления");
            }
            if (x > 10 || y > 10) {
                throw new Exception("Числа должны быть от 1 до 10");
            }
            int arabian = calc(x, y, operation);
            if (isRoman) {
                if (arabian <= 0) {
                    throw new Exception("В римской системе нет отрицательных чисел");
                }
                result = Roman.convertToRoman(arabian);
            } else {
                result = String.valueOf(arabian);
            }
            return result;
        }

        static String detectOperation(String expression) {
            if (expression.contains("+")) return "+";
            else if (expression.contains("-")) return "-";
            else if (expression.contains("*")) return "*";
            else if (expression.contains("/")) return "/";
            else return null;
        }

        static int calc(int a, int b, String operation) {
            if (operation.equals("+")) return a + b;
            else if (operation.equals("-")) return a - b;
            else if (operation.equals("*")) return a * b;
            else return a / b;
        }

    }

    class Roman {
        static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C"};

        static boolean isRoman(String val) {
            for (int i = 0; i < romanArray.length; i++) {
                if (val.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }

        static int convertToArabian(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        static String convertToRoman(int arabian) {
            return romanArray[arabian];
        }

}
