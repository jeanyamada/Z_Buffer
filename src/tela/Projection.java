/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.util.ArrayList;
import objects3D.Casa;
import objects3D.MalhaPoligno;
import objects3D.Object3D;
import points.Point3D;

/**
 *
 * @author jean
 */
public class Projection {

    private int projection;
    private ArrayList<Object3D> objects3D;

    public Projection(int projection) {
        this.projection = projection;
        objects3D = new ArrayList<>();
    }

    public void draw(ZBuffer zBuffer) {
        for (Object3D x : objects3D) {
            x.draw(zBuffer);
        }
    }

    public void insertObjects3D(ArrayList<Object3D> obj) {
        objects3D = (ArrayList<Object3D>) obj.clone();
    }

    public void startProjectionObj3D(Object3D obj) {

        switch (getProjection()) {
            case 0:

                for (Point3D p : obj.getPoints()) {
                    cavalier45(p);
                }

                break;
        }
    }

    public void startProjectionMalha(MalhaPoligno m) {

        switch (getProjection()) {
            case 0:

                for (Point3D p : m.getPoints()) {
                    cavalier45(p);
                }

                break;
        }
    }
    public void cavalier45(Point3D p) {

        double grausR = Math.toRadians(45);
        p.setX((int) (p.getX() - p.getZ() * Math.cos(grausR)));
        p.setY((int) (p.getY() - p.getZ() * Math.sin(grausR)));
    }

    public static void cavalier30(Point3D p) {

        double grausR = Math.toRadians(30);
        p.setX((int) (p.getX() - p.getZ() * Math.cos(grausR)));
        p.setY((int) (p.getY() - p.getZ() * Math.sin(grausR)));
    }

    public static void cabinet(Point3D p) {

        double grausR = Math.toRadians(63.4);
        int l = 2;
        p.setX((int) (p.getX() - p.getZ() * l * Math.cos(grausR)));
        p.setY((int) (p.getY() - p.getZ() * l * Math.sin(grausR)));
    }

    public static void ortografica(Point3D p) {

        double grausR = Math.toRadians(90);
        p.setX((int) (p.getX() - p.getZ() * Math.cos(grausR)));
        p.setY((int) (p.getY() - p.getZ() * Math.sin(grausR)));
    }

    public int getProjection() {
        return projection;
    }

    public void setProjection(int projection) {
        this.projection = projection;
    }

    public ArrayList<Object3D> getObjects3D() {
        return objects3D;
    }

    public void setObjects3D(ArrayList<Object3D> objects3D) {
        this.objects3D = objects3D;
    }

}
