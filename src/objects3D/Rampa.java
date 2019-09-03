/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects3D;

import java.awt.Color;
import java.util.ArrayList;
import points.Point3D;

/**
 *
 * @author jean
 */
public class Rampa extends MalhaPoligno {

    private Point3D p1, p2, p3,
            p4, p5, p6,
            origin;

    public Rampa() {
        p1 = new Point3D(0, 0, 0);
        origin = p1;
        p2 = new Point3D(150, 0, 0);
        p3 = new Point3D(150, 0, 100);
        p4 = new Point3D(0, 0, 100);
        p5 = new Point3D(0, 100, 100);
        p6 = new Point3D(0, 100,0);

    }

    public ArrayList<Point3D> getPoints() {
        ArrayList<Point3D> points = new ArrayList<>();
        points.add(getP1());
        points.add(getP2());
        points.add(getP3());
        points.add(getP4());
        points.add(getP5());
        points.add(getP6());
        return points;
    }

    public void create(ArrayList<Object3D> obj) {

        ArrayList<Point3D> point3Ds = new ArrayList<>();

        point3Ds.add(p1);
        point3Ds.add(p2);
        point3Ds.add(p3);
        point3Ds.add(p4);

        obj.add(new Poligno(point3Ds, p2, Color.GREEN, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p1);
        point3Ds.add(p4);
        point3Ds.add(p5);
        point3Ds.add(p6);

        obj.add(new Poligno(point3Ds, p1, Color.GRAY, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p6);
        point3Ds.add(p2);
        point3Ds.add(p3);
        point3Ds.add(p5);

        obj.add(new Poligno(point3Ds, p1, Color.YELLOW, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p5);
        point3Ds.add(p3);
        point3Ds.add(p4);

        obj.add(new Poligno(point3Ds, p1, Color.BLUE, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p1);
        point3Ds.add(p6);
        point3Ds.add(p2);

        obj.add(new Poligno(point3Ds, p3, Color.RED, Color.BLACK));

    }

    public Point3D getP1() {
        return p1;
    }

    public void setP1(Point3D p1) {
        this.p1 = p1;
    }

    public Point3D getP2() {
        return p2;
    }

    public void setP2(Point3D p2) {
        this.p2 = p2;
    }

    public Point3D getP3() {
        return p3;
    }

    public void setP3(Point3D p3) {
        this.p3 = p3;
    }

    public Point3D getP4() {
        return p4;
    }

    public void setP4(Point3D p4) {
        this.p4 = p4;
    }

    public Point3D getP5() {
        return p5;
    }

    public void setP5(Point3D p5) {
        this.p5 = p5;
    }

    public Point3D getP6() {
        return p6;
    }

    public void setP6(Point3D p6) {
        this.p6 = p6;
    }

    public Point3D getOrigin() {
        return origin;
    }

    public void setOrigin(Point3D origem) {
        this.origin = origem;
    }

}
