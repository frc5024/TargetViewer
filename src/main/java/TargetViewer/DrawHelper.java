package TargetViewer;

import java.awt.Point;
import java.lang.Math;

public class DrawHelper {
    public static Point getRelativeAngularPoint(double distance, double angle) {
        double A = 180 - 90 - angle;

        double y = (distance * Math.sin(A)) / Math.sin(90);
        double x = (distance * Math.sin(angle)) / Math.sin(90);

        return new Point((int) x, (int) y);
    }
    
    public static Point mkAbsolutePoint(Point zero, Point point){

        double x = zero.getX() - point.getX();
        double y = zero.getY() - point.getY();

        return new Point((int)x, (int)y);
    }
}