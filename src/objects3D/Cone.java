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
public class Cone extends Object3D {

    private int altura;
    private ArrayList<Point3D> points;

    public Cone(int altura, Point3D origin, Color colorFill, Color colorDraw) {
        super(origin, colorFill, colorDraw);
        this.altura = altura;
        points = new ArrayList<>();
    }

    public Cone(int altura) {

        this.altura = altura;
        points = new ArrayList<>();
    }

    public Cone() {
        points = new ArrayList<>();
    }

    @Override
    public int getDepht(int x, int y) {
        int nX = (int) -Math.pow(x, 2);
        int nY = (int) -Math.pow(y, 2);
        int z = (int) (Math.sqrt(x - y + Math.pow(Math.PI, 2)));
        return z;
    }

    @Override
    public void create() {
        for (int i = 0; i < altura; i++) {
            for (float j = 0.0f; j < 2.0 * Math.PI; j += 0.01) {

                int x = (int) Math.round(getOrigin().getX() + i * Math.cos(j));
                int y = (int) Math.round(getOrigin().getY() + i * Math.sin(j));
                int z = getOrigin().getZ() + i;

                Point3D p = new Point3D(x, y, z);
                points.add(p);
            }
        }
    }

    @Override
    public boolean intercept(int x, int y) {
        for(Point3D p:getPoints())
            if(p.getX() == x && p.getY() == y)
                return true;
        return false;
    }

    @Override
    public ArrayList<Point3D> getPoints() {
        return points;
    }

    @Override
    public void draw(ZBuffer zBuffer) {
        DrawObjects2D.draw(this, zBuffer,getColorDraw());
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
