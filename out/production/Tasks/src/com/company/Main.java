package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


////  1-10
     System.out.println(Task1_10.remainder(3,4));
       System.out.println(Task1_10.triArea(10,10));
        System.out.println(Task1_10.animals(2,3,5));
        System.out.println(Task1_10.profitableGamble(0.2, 50, 9));
        System.out.println(Task1_10.operation(24, 26, 2));
        System.out.println(Task1_10.ctoa('A'));
        System.out.println(Task1_10.addUpTo(10));
        System.out.println(Task1_10.nextEdge(8,10));
        int[] sumofcubes = {1,5,9};
        System.out.println(Task1_10.sumOfCubes(sumofcubes));
       System.out.println(Task1_10.abcmath(5,2,1));
////  10_20
        System.out.println(Task10_20.repeat("mice", 5));
        int[] avg = {1,5,6};
        System.out.println(Task10_20.isAvgWhole(avg));
        int[] sum = {3,3,-2,408,3,3};
        System.out.println(Arrays.toString(Task10_20.cumulativeSum(sum)));
        System.out.println(Task10_20.getDecimalPlaces("43,20"));
        System.out.println(Task10_20.Fibonacci(12));
        System.out.println(Task10_20.isValid("59001"));
        System.out.println(Task10_20.isStrangePair("ratio", "orator"));
        System.out.println(Task10_20.isSuffix("arachnophobia", "-phobia"));
        System.out.println(Task10_20.isPrefix("automation", "auto-"));
        Task10_20.boxSeq(5);
        System.out.println(" ");
//  20_30
        System.out.println(Task20_30.solutions(1,0,-1));
        System.out.println(Task20_30.findZip("all zip files are zipped"));
        System.out.println(Task20_30.checkPerfect(496));
        System.out.println(Task20_30.flipEndChars("CAt, dog, And Mouse"));
        System.out.println(Task20_30.isValidHexCode("#CD5C5C"));
        int[]arr1 = {1,3,4,4,4}; int[]arr2 = {2,5,7};
        System.out.println(Task20_30.same(arr1, arr2));
        System.out.println(Task20_30.isKaprekar(297));
        System.out.println(Task20_30.longestZero("01100001011000"));
        System.out.println(Task20_30.nextPrime(24));
        System.out.println(Task20_30.rightTriangle(70,30,110));
//  30_40
        System.out.println(Task30_40.bessi("hello my name is Bessie and this is my essay", 7));
        System.out.println(Arrays.toString(Task30_40.clasterSkobok("()()()")));
        System.out.println(Task30_40.toCamelCase("hello_edabit"));
        System.out.println(Task30_40.toSnakeCase("helloEdabit"));
        double[]overtime = {13.25, 15, 30, 1.5};
        System.out.println(Task30_40.overTime(overtime));
        System.out.println(Task30_40.BMI("55 kilos", "1.65 meters"));
        System.out.println(Task30_40.bugger(999));
        System.out.println(Task30_40.toStarShorthand("77777gefff"));
        System.out.println(Task30_40.doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(Task30_40.trouble(451999277, 41177722899L));
        System.out.println(Task30_40.countUniqueBooks("AZYWABBCATTTA", 'A'));
//40_50
        System.out.println((Task40_50.encrypt("Hello")));
        System.out.println(Task40_50.decrypt("72, 29, 7, 0, 3"));
        System.out.println(Task40_50.canMove("Bishop", "A7", "G1"));
        System.out.println(Task40_50.canComplete("butl", "beautiful"));
        int[] sumdigi = {1, 2, 3, 4, 5};
        System.out.println(Task40_50.sumDigProd(sumdigi));
        String[] samevowel = {"many", "carriage", "emit", "apricot", "animal"};
        System.out.println(Task40_50.sameVowelGroup(samevowel));
        System.out.println(Task40_50.validateCard("1234567890123452"));
        System.out.println(Task40_50.numToEng(128));
        System.out.println(Task40_50.getSha256Hash("password123"));
        System.out.println(Task40_50.correctTitle("jOn SnoW, kINg IN thE noRth."));
      System.out.println(Task40_50.hexLattice(7));
////50_60
        System.out.println(Task50_60.bell(5));
        System.out.println(Task50_60.translateWord("Apple"));
        System.out.println(Task50_60.validColor("rgba(0,0,0,0.123456789)"));
        System.out.println(Task50_60.stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(Arrays.toString(Task50_60.getHashTags("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println(Task50_60.ulam(206));
        System.out.println(Task50_60.longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(Task50_60.convertToRoman(16));
        System.out.println(Task50_60.formula("16 * 10 = 160 = 14 + 120"));
        System.out.println(Task50_60.palindromedescendant("11211230"));
    }
}