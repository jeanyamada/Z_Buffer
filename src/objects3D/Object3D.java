/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects3D;

import java.awt.Color;
import java.util.ArrayList;
import points.Point3D;
import tela.ZBuffer;

/**
 *
 * @author jean
 */
public abstract class Object3D {

    private Point3D origin;
    private Color colorFill, colorDraw;


    public Object3D(Point3D origin, Color colorFill, Color colorDraw) {
        this.origin = origin;
        this.colorFill = colorFill;
        this.colorDraw = colorDraw;
    }

    public Object3D() {
    }

    public abstract int getDepht(int x, int y);

    public abstract void create();

    public abstract boolean intercept(int x, int y);

    public abstract ArrayList<Point3D> getPoints();

    public abstract void draw(ZBuffer zBuffer);

    public Point3D getOrigin() {
        return origin;
    }

    public void setOrigin(Point3D origin) {
        this.origin = origin;
    }

    public Color getColorFill() {
        return colorFill;
    }

    public void setColorFill(Color colorFill) {
        this.colorFill = colorFill;
    }

    public Color getColorDraw() {
        return colorDraw;
    }

    public void setColorDraw(Color colorDraw) {
        this.colorDraw = colorDraw;
    }

}
