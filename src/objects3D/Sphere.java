/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects3D;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import objects2D.DrawObjects2D;
import points.Point3D;
import tela.ZBuffer;

/**
 *
 * @author jean
 */
public class Sphere extends Object3D {

    private int raio;
    ArrayList<Point3D> points;

    public Sphere(int raio, Point3D origin, Color colorFill, Color colorDraw) {
        super(origin, colorFill, colorDraw);
        this.raio = raio;
        points = new ArrayList<>();
    }

    public Sphere(int raio) {
        this.raio = raio;
        points = new ArrayList<>();
    }

    public Sphere() {
        points = new ArrayList<>();
    }

    @Override
    public int getDepht(int x, int y) {

        int nX = (int) -Math.pow(x - getOrigin().getX(), 2);
        int nY = (int) -Math.pow(y - getOrigin().getY(), 2);
        int z = (int) (Math.sqrt(x - y + Math.pow(Math.PI, 2)) + getOrigin().getZ());
        return z;
    }

    @Override
    public void create() {
 

        for (double a = 0.0d; a < 2.0d * Math.PI; a += 0.01f) {
            for (double b = 0.0d; b < 2.0d * Math.PI; b += 0.01f) {

                int x = (int) Math.round(getOrigin().getX() + raio * Math.cos(a)*Math.cos(b));
                int y = (int) Math.round(getOrigin().getY() + raio *Math.cos(a)*Math.sin(b));
                int z = (int) (getOrigin().getZ() + raio*Math.sin(a));
                

                Point3D p = new Point3D(x,y,z);

                points.add(p);
            }
        }

    }

    @Override
    public boolean intercept(int x, int y) {
        Point p1 = new Point(getOrigin().getX(), getOrigin().getY());
        Point p2 = new Point(x, y);

        if (p1.distance(p2) > raio) {
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<Point3D> getPoints() {
        return points;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    @Override
    public void draw(ZBuffer zBuffer) {
        DrawObjects2D.draw(this, zBuffer,getColorDraw());
    }

}
