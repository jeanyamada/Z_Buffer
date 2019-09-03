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
public class Casa extends MalhaPoligno{

    private Point3D p1, p2, p3,
            p4, p5, p6,
            p7, p8, p9, p10, origin;

    
    public Casa() {
        p1 = new Point3D(0, 0, 0);
        origin = p1;
        p2 = new Point3D(0, 0, 100);
        p3 = new Point3D(100, 0, 100);
        p4 = new Point3D(100, 0, 0);
        p5 = new Point3D(0, 100, 0);
        p6 = new Point3D(0, 100, 100);
        p7 = new Point3D(100, 100, 100);
        p8 = new Point3D(100, 100, 0);
        p9 = new Point3D(50, 150, 0);
        p10 = new Point3D(50, 150, 100);
    }

    public ArrayList<Point3D> getPoints() {
        ArrayList<Point3D> points = new ArrayList<>();
        points.add(getP1());
        points.add(getP2());
        points.add(getP3());
        points.add(getP4());
        points.add(getP5());
        points.add(getP6());
        points.add(getP7());
        points.add(getP8());
        points.add(getP9());
        points.add(getP10());
        return points;
    }

    public void create(ArrayList<Object3D> obj) {

        ArrayList<Point3D> point3Ds = new ArrayList<>();

        point3Ds.add(p2);
        point3Ds.add(p6);
        point3Ds.add(p7);
        point3Ds.add(p3);

        obj.add(new Poligno(point3Ds, p2, Color.GREEN, Color.BLACK));

        point3Ds = new ArrayList<>();
        
        point3Ds.add(p1);
        point3Ds.add(p2);
        point3Ds.add(p3);
        point3Ds.add(p4);

        obj.add(new Poligno(point3Ds, p1, Color.RED, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p1);
        point3Ds.add(p2);
        point3Ds.add(p6);
        point3Ds.add(p5);

        obj.add(new Poligno(point3Ds, p1, Color.YELLOW, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p1);
        point3Ds.add(p4);
        point3Ds.add(p8);
        point3Ds.add(p5);

        obj.add(new Poligno(point3Ds, p1, Color.BLUE, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p3);
        point3Ds.add(p7);
        point3Ds.add(p8);
        point3Ds.add(p4);

        obj.add(new Poligno(point3Ds, p3, Color.ORANGE, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p5);
        point3Ds.add(p6);
        point3Ds.add(p7);
        point3Ds.add(p8);

        obj.add(new Poligno(point3Ds, p5, Color.MAGENTA, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p5);
        point3Ds.add(p8);
        point3Ds.add(p9);

        obj.add(new Poligno(point3Ds, p5, Color.PINK, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p6);
        point3Ds.add(p7);
        point3Ds.add(p10);

        obj.add(new Poligno(point3Ds, p6, Color.GRAY, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p10);
        point3Ds.add(p9);
        point3Ds.add(p5);
        point3Ds.add(p6);

        obj.add(new Poligno(point3Ds, p10, Color.DARK_GRAY, Color.BLACK));

        point3Ds = new ArrayList<>();

        point3Ds.add(p10);
        point3Ds.add(p9);
        point3Ds.add(p8);
        point3Ds.add(p7);

        obj.add(new Poligno(point3Ds, p10, Color.LIGHT_GRAY, Color.BLACK));
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

    public Point3D getP7() {
        return p7;
    }

    public void setP7(Point3D p7) {
        this.p7 = p7;
    }

    public Point3D getP8() {
        return p8;
    }

    public void setP8(Point3D p8) {
        this.p8 = p8;
    }

    public Point3D getP9() {
        return p9;
    }

    public void setP9(Point3D p9) {
        this.p9 = p9;
    }

    public Point3D getOrigin() {
        return origin;
    }

    public void setOrigin(Point3D origem) {
        this.origin = origem;
    }

    public Point3D getP10() {
        return p10;
    }

    public void setP10(Point3D p10) {
        this.p10 = p10;
    }

}
