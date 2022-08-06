package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
     Point start ;
    Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    double length() {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();

        return Math.sqrt(StrictMath.pow((x2-x1), 2)+StrictMath.pow((y2-y1), 2));

    }

    Point middle() {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();

        double x = (x1+x2)/2;
        double y = (y1+y2)/2;
        return new Point(x,y);

    }

    Point intersection(Segment another) {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();

        Point p1 = another.start;
        Point p2 = another.end;

        double x3 = p1.getX();
        double y3= p1.getY();
        double x4 = p2.getX();
        double y4 = p2.getY();

        Point po = null;
        try{
            double um = (x1*y2 - y1*x2);

            double x = ((x1*y2 - y1*x2)*(x3-x4)-(x1-x2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
            double y = ((x1*y2 - y1*x2)*(y3-y4)-(y1-y2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
            po = new Point(x,y);
        }finally{
            return po;
        }
    }

}
