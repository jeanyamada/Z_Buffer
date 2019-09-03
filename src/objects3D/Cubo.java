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
public class Cubo extends Object3D {

    private ArrayList<Point3D> points;

    public Cubo(Point3D origin, Color colorFill, Color colorDraw) {
        super(origin, colorFill, colorDraw);
        points = new ArrayList<>();
    }

    public Cubo() {
        points = new ArrayList<>();
    }

    @Override
    public int getDepht(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() {
        Point3D p;
        for (int i = 0; i <  40; i++) {
            for (int j = 0; j < 40; j++) {

                p = new Point3D(i,0,j);
                points.add(p);
                p = new Point3D(i,40,j);
                points.add(p);
                p = new Point3D(0,i,j);
                points.add(p);
                p = new Point3D(40,i,j);
                points.add(p);
                p = new Point3D(i,j,0);
                points.add(p);
                p = new Point3D(i,j,40);
            }
        }
    }

        @Override
        public boolean intercept
        (int x, int y
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ArrayList<Point3D> getPoints
        
            () {
        return points;
        }

        @Override
        public void draw
        (ZBuffer zBuffer
        
            ) {
        DrawObjects2D.draw(this, zBuffer, getColorDraw());
        }

    }
