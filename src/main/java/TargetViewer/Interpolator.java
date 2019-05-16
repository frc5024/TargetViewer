package TargetViewer;

public class Interpolator {
    double m;
    double b;

    public Interpolator(double in_min, double in_max, double out_min, double out_max) {
        this.m = (out_max - out_min) / (in_max - in_min);
        this.b = -(this.m * in_min) + out_min;
    }

    public double getVal(double x){
        return (this.m * x) + this.b;
    }
}