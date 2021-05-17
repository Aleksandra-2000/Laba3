package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        String input;
        String[] str;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the first point: (x y z)");
        input = br.readLine();
        str = input.trim().split(" ");
        Point3d p1 = new Point3d(Double.parseDouble(str[0]),
                Double.parseDouble(str[1]),
                Double.parseDouble(str[2]));

        System.out.println("Enter the second point: (x y z)");
        input = br.readLine();
        str = input.trim().split(" ");
        Point3d p2 = new Point3d(Double.parseDouble(str[0]),
                Double.parseDouble(str[1]),
                Double.parseDouble(str[2]));

        System.out.println("Enter the third point: (x y z)");
        input = br.readLine();
        str = input.trim().split(" ");
        Point3d p3 = new Point3d(Double.parseDouble(str[0]),
                Double.parseDouble(str[1]),
                Double.parseDouble(str[2]));

        if(p1.isEqual(p2) || p1.isEqual(p3) || p2.isEqual(p3))System.out.println("Please enter different points");
        else System.out.printf("The area of this triangle: S =  %.2f", computeArea(p1,p2,p3));

    }
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        double a = p1.distanceTo(p2);
        double b = p1.distanceTo(p3);
        double c = p2.distanceTo(p3);

        double p = (a + b + c)/2; //формула полупериметра

        return Math.sqrt(p*(p-a)*(p-b)*(p-c)); //формула площади

    }
}
