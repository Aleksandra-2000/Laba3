package com.company;

public class Task20_30 {
    public static int solutions(double a, double b, double c){ //task21
        if(b * b - 4 * a * c > 0)return 2; //сичтаем a b c , если ответ больше 0 то решений будет 2
        else if(b * b - 4 * a * c == 0) return 1; // 1 решение
        return 0; //уравнение не имеет решений
    }
    public static int findZip(String string){ //task22
        string = string.replaceFirst("zip", ""); //парсим строку на первый зип и замещаем пустым местом
        if(string.contains("zip"))return string.indexOf("zip") + 3; //если находим второй зип выводим его позицию с +3
        return -1;
    }
    public static boolean checkPerfect(int n){ //task23
        int mn_sum = 0; //
        for(int i = 1; i < (n/2) + 1; i++){
            if(n % i == 0)mn_sum += i; //перебираем числа от 1 до половины входного зачения
        } // и если остаток от деления нашего числа равен 0 то число делиться на N
        return mn_sum == n; //если сумма чисел делщихся на N без остатка дает само N то выводим True или False
    }
    public static String flipEndChars(String string){ //task24
        if(string.length() <= 2)return "Incompatible"; //несовместимо ибо 2 или меньше символов
        if(string.charAt(0) == string.charAt(string.length() - 1))return "Two's a pair"; //сравниваем первый и посл символы, если они одинаковы выводим что это пара
        return string.charAt(string.length() - 1) + string.substring(1 , string.length() - 1) + string.charAt(0);//если никакя проверка не ретернула, то просто меняем 1 и посл символы
    }
    public static boolean isValidHexCode(String string){ //task25 //
        if(string.charAt(0) != '#' || string.length() != 7)return false; //если первый символ не начинается с #  или знаков не 7 то ошибка
        for (int i = 1; i <= 6; i++){ //перебираем число
            char c = string.charAt(i); //переводим стринг в чар
            if(!((c >= 48 && c <= 57) ||  (c >= 65 && c <= 70) ||  (c >= 97 && c <= 102)))return false; //и проверяем его на заданные значения по таблице Unicode
        }
        return true;
    }
    public static boolean same(int[] arr1, int[] arr2){ //task26
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < arr1.length; i += 1) {
            if (!line1.contains(String.valueOf(arr1[i]))) { //если уникальное значение несодержится в лайн1 то заносим туда
                line1 += String.valueOf(arr1[i]);
            }
        }
        for (int i = 0; i < arr2.length; i += 1) {
            if (!line2.contains(String.valueOf(arr2[i]))) {
                line2 += String.valueOf(arr2[i]);
            }
        }
        return line1.length() == line2.length(); //если уникальных значений одинакове кол-во то тру
    }
    public static boolean isKaprekar(int n){ //task27
        int square = (int) Math.pow(n, 2); //возводим в квадрат
        String karp = String.valueOf(square);
        if (Integer.parseInt(karp.substring(0,karp.length()/2)) + Integer.parseInt(karp.substring(karp.length()/2)) == n){
            return true; // делим число на 2 части, и если при скаладывании этих частей получаем изначальное число то тру
        }
        return false;
    }
    public static String longestZero(String string){ //task28
        String ans = "";
        int max = 0;
        int temp = 0;
        for(int i =0; i < string.length(); i++){
            if(string.charAt(i) == '1')temp = 0; // проходимся по строке и если после 0 идет 1 сбрасываем счетчик,
            else {
                temp++; //если это не 1 то увеличиваем счетчик и сразу же записываем в максимум если новое число больше 0
                if(max < temp)max = temp;
            }
        }
        for (int i =0; i< max; i++){
            ans +='0'; //ну и выводим количество нулей
        }
        return ans;
    }
    public static int nextPrime(int n){ //task29
        while (true){
            for (int i = 2; i < n/2; i++) //проходимся по числам начиная с 2 до половины заданного значения.
            if(n % i == 0)break; //если число не простое то выходим и приавляем к числу +1 пока оно не будет простым
            else if(i == n/2 - 1) return n;{ //если мы дошли до конца значит число простое и выводим его же
                n++;
            }

        }
    }
    public static boolean rightTriangle(int a, int b, int c){ //task30
        if( a*a == b*b + c*c || b*b == a*a + c*c || c*c == b*b + a*a)return true; // если гипотенуза равна значению а+б то все ок
        return false;
    }


}
