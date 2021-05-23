package com.company;

public class Task1_10{ //task1
public static int remainder(int a, int b){
        return a % b; // возвращаем остаток от деления а на б
        }
public static double triArea(double a, double b){ //task2
        return a * b / 2; //возвращаем среднее значение
        }
public static int animals(int chickens, int cows, int pigs){ //task3
        return chickens * 2 + cows * 4 + pigs * 4; // банально умножаем количество животных на количество копыт
        }
public static boolean profitableGamble(double prob, double prize, double pay){ //task4
        return prob * prize > pay;
        }
public static String operation(int N, int a, int b){ //task5
        if(a + b == N)return "added";
        else if(a - b == N)return "subtracted"; //если какая либо операця дает N то выводим суть операции
        else if(a * b == N)return "multiplied";
        else if(a / b == N)return "divided";
        return "none";
        }
public static int ctoa(char c){ //task6
        return c;  //переводим значние int в char и передаем его
        }
public static int addUpTo(int n){ //task7
        return (n + 1) * n / 2; // к числу прибавляем единицу и у множаем на его половину.
        }
public static int nextEdge(int a, int b){ //task8
        return a + b - 1; //длинна третьего ребра не может быть больше суммы длин двух других ребер поэтому -1
        }
public static int sumOfCubes(int[] a){ //task9
        int sum = 0;
        for (int i =0; i < a.length; i++){
        sum += a[i]* a[i]*a[i]; //три раза умножаем а на саму себя.
        }
        return sum;
        }
public static boolean abcmath(int a, int b, int c){ //task10
        for(int i = 0; i < b; i++){
        a +=a;
        }
        return a % c == 0; //выполняем прибавление а до б и возвращаем делится ли оно на с
        }
        }
