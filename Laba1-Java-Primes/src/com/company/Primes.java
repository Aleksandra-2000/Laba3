package com.company;

public class Primes {
    public static void main(String[] args) {
        int SIZE = 100;
        for (int i = 2; i <= SIZE; i++) {
            if (IsPrime(i)) System.out.println(i);
        }
    }
    public static boolean IsPrime(int n){
        for (int i = 2; i <= n/2;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
