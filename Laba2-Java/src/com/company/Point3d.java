package com.company;

public class Point3d extends Point2d {
    protected double z;

    public  Point3d(){
        this(0,0,0);
    }
    public  Point3d(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean isEqual(Point3d p){
        if(x == p.x && y == p.y && z == p.z)return true;
        return false;
    }

    public double distanceTo(Point3d p){
        return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2) + Math.pow(z-p.z, 2));
    }
}
