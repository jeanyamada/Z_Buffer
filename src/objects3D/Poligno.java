/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects3D;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import objects2D.DrawObjects2D;
import points.Point3D;
import tela.ZBuffer;

/**
 *
 * @author jean
 */
public class Poligno extends Object3D {

    private ArrayList<Point3D> points;

    public Poligno(ArrayList<Point3D> points, Point3D origin, Color colorFill, Color colorDraw) {
        super(origin, colorFill, colorDraw);
        this.points = points;
    }

    public Poligno(ArrayList<Point3D> points) {
        this.points = points;
    }

    public boolean contains(int x, int y) {

        Polygon polygon = new Polygon();

        for (Point3D p : points) {
            polygon.addPoint(p.getX(), p.getY());
        }

        Point point = new Point(x, y);

        return polygon.contains(point);

    }

    public void setPoints(ArrayList<Point3D> points) {
        this.points = points;
    }


    @Override
    public int getDepht(int x, int y) {

        Point3D pt1 = getPoints().get(0);
        Point3D pt2 = getPoints().get(1);
        Point3D pt3 = getPoints().get(2);

        int a = (pt2.getZ() - pt3.getZ()) * (pt1.getY() - pt2.getY()) - (pt1.getZ() - pt2.getZ()) * (pt2.getY() - pt3.getY());
        int b = (pt2.getX() - pt3.getX()) * (pt1.getZ() - pt2.getZ()) - (pt1.getX() - pt2.getX()) * (pt2.getZ() - pt3.getZ());
        int c = (pt2.getY() - pt3.getY()) * (pt1.getX() - pt2.getX()) - (pt1.getY() - pt2.getY()) * (pt2.getX() - pt3.getX());
        int d = -pt1.getX() * (pt2.getY() * pt3.getZ() - pt2.getZ() * pt3.getY()) + pt1.getY() * (pt2.getX() * pt3.getZ() - pt2.getZ() * pt3.getX()) - pt1.getZ() * (pt2.getX() * pt3.getY() - pt2.getY() * pt3.getX());

        int z = Integer.MIN_VALUE;

        if (c != 0) {
            z = (-a * x - b * y - d) / c;
        }

        return z;
    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean intercept(int x, int y) {
        Polygon polygon = new Polygon();

        for (Point3D p : points) {
            polygon.addPoint(p.getX(), p.getY());
        }

        Point point = new Point(x, y);

        return polygon.contains(point);
    }

    @Override
    public ArrayList<Point3D> getPoints() {
        return points;
    }

    @Override
    public void draw(ZBuffer zBuffer) {

        for (int i = 0; i < points.size() - 1; i++) {

            DrawObjects2D.bresenhamLine(points.get(i).getX(), points.get(i).getY(),
                    points.get(i + 1).getX(), points.get(i + 1).getY(),
                    getColorDraw(), zBuffer, this);
        }

        DrawObjects2D.bresenhamLine(points.get(points.size() - 1).getX(), points.get(points.size() - 1).getY(),
                points.get(0).getX(), points.get(0).getY(),
                getColorDraw(), zBuffer, this);

    }

}
