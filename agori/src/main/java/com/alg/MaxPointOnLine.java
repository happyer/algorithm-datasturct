package com.alg;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by chauncy on 2018/5/10.
 */
public class MaxPointOnLine {


    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    public static void main(String[] args) {


        Point p1 = new Point(0, 0);
        Point p2 = new Point(94911151, 94911150);
        Point p3 = new Point(94911152, 94911151);
        Point[] points = new Point[]{p1, p2, p3};
        int r = maxPoints(points);
        System.out.println("r = " + r);
    }


    /**
     * 寻找相同的斜率,然后放在map 中
     *
     * @param points
     * @return
     */
//    public static int maxPoints(Point[] points) {
//        if (points.length < 3) return points.length;
//
//        int rest = 0;
//        Map<String, Integer> ress = new HashMap<>();
//        for (int i = 0; i < points.length - 1; i++) {
//            ress.clear();
//            int pointMax = 1;
//            int samePointNum = 0;
//            for (int j = i + 1; j < points.length; j++) {
//                final String slope;
//                //x is same
//                if (points[i].x == points[j].x) {
//                    slope = "##";
//                    if (points[i].y == points[j].y) {
//                        samePointNum++;
//                        continue;
//                    }
//                } else {
//                    if (points[i].y == points[j].y) {
//                        slope = "0";
//                    } else {
//                        //cal slope
//                        int igcd = gcdThing(points[i].x, points[i].y) == 0 ? 1 : gcdThing(points[i].x, points[i].y);
//                        int jgcd = gcdThing(points[j].x, points[j].y) == 0 ? 1 : gcdThing(points[j].x, points[j].y);
//
//                        slope = ((points[i].y / igcd) - (points[j].y / jgcd)) + "/" + ((points[i].x / igcd) - (points[j].x / jgcd));
//                    }
//                }
//                int cnt = 0;
//                if (ress.containsKey(slope)) {
//                    Integer tmp = ress.get(slope);
//                    ress.put(slope, tmp + 1);
//                    cnt = tmp + 1;
//                } else {
//                    cnt = 2;
//                    ress.put(slope, 2);
//                }
//                if (pointMax < cnt) pointMax = cnt;
//            }
//            rest = Math.max(rest, pointMax + samePointNum);
//
//        }
//        return rest;
//    }

    private static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }


    static class Line {
        int deltax;
        int deltay;

        int cross1;
        int cross2;

        public Line(int deltax, int deltay, int x0, int y0) {
            // shrink
            if (deltax == 0) {deltay = 1; cross1 = x0; cross2=0; }
            else if (deltay == 0) { deltax = 1; cross1 = y0; cross2 = 0;}
            else {
                int gcd = gcd(deltax, deltay);
                deltax = deltax/gcd;
                deltay = deltay/gcd;
                if (deltax <0) {
                    deltax = - deltax;
                    deltay = - deltay;
                }
                this.deltax = deltax;
                this.deltay = deltay;

                cross1 = y0 * deltax - x0 * deltay;
                cross2 = deltax * deltay;
                if (cross1 ==0) cross2 = 1;
                else {
                    gcd = gcd(cross1, cross2);
                    cross1 /= gcd;
                    cross2 /= gcd;
                }
            }
        }

        public int hashCode() {
            return deltax*deltay + cross1 + cross2 + deltax;
        }
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (! (obj instanceof Line )) return false;
            Line obj2 = (Line) obj;
            return obj2.deltax == deltax && obj2.deltay == deltay && obj2.cross1 == cross1 && obj2.cross2 == cross2;
        }

        static int gcd(int a, int b)
        {
            while(a!=0 && b!=0) // until either one of them is 0
            {
                int c = b;
                b = a%b;
                a = c;
            }
            return a+b; // either one is 0, so return the non-zero value
        }
    }

    public static int maxPoints(Point[] points) {
        Map<Line, Set<Integer>> map = new HashMap<Line, Set< Integer>>();
        if (points.length == 1 ) { return 1;}
        for(int i=0;i<points.length-1;i++) {
            for(int j=i+1;j<points.length;j++) {
                Line l = new Line(points[i].x - points[j].x, points[i].y - points[j].y, points[i].x, points[i].y );
                if( map.containsKey(l) ) {
                    map.get(l).add(i);
                    map.get(l).add(j);
                } else {
                    map.put(l,new HashSet<Integer>() );
                    map.get(l).add(i);
                    map.get(l).add(j);
                }
            }
        }

        int best = 0;
        for(Map.Entry e: map.entrySet()) {
            Set cnt = (Set)e.getValue();
            best = Math.max(cnt.size(),best);
        }
        return best;
    }
}
