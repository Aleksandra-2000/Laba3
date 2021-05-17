package com.company;

public class Point2d {
    protected double x;
    protected double y;
    public Point2d(){
        this(0,0);
    }
    public Point2d(double x,double y){
        this.x = x;
        this.y = x;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isEqual(Point2d p){
        if(x == p.x && y == p.y)return true;
        return false;
    }
}
