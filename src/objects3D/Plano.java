/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects3D;

import java.awt.Color;
import java.util.ArrayList;
import objects2D.DrawObjects2D;
import points.Point3D;
import tela.ZBuffer;

/**
 *
 * @author jean
 */
public class Plano extends Object3D {

    private ArrayList<Point3D> points;

    public Plano(Point3D origin, Color colorFill, Color colorDraw) {
        super(origin, colorFill, colorDraw);
        points = new ArrayList<>();
    }

    public Plano() {
        points = new ArrayList<>();
    }

    @Override
    public int getDepht(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() {
        for (double i = 50; i < 100; i +=0.1) {
            for (double j = 30; j < 80; j +=0.1) {
                int z = (int) Math.round(3.0d * i - 2.0d * j + 5.0d);
                Point3D p = new Point3D((int)Math.round(j), (int) Math.round(i),(int)Math.round(z));
                points.add(p);
            }
        }
    }

    @Override
    public boolean intercept(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Point3D> getPoints() {
        return points;
    }

    @Override
    public void draw(ZBuffer zBuffer) {
        DrawObjects2D.draw(this, zBuffer, getColorDraw());
    }

}
