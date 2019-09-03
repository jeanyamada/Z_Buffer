/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objects3D.Casa;
import objects3D.MalhaPoligno;
import objects3D.Object3D;
import objects3D.Poligno;
import points.Point3D;

/**
 *
 * @author jean
 */
public class ZBuffer {

    private BufferedImage canvas;
    private Integer[] depth;
    private Point2D size, center;
    private Color brackground;
    private ArrayList<Object3D> objects3D;
    private ArrayList<MalhaPoligno> mL;
    
    public ZBuffer() {

    }

    public ZBuffer(BufferedImage canvas, Point2D size, Point2D center, Color brackground) {
        this.canvas = canvas;
        this.size = size;
        this.center = center;
        this.brackground = brackground;
        this.depth = new Integer[canvas.getWidth() * canvas.getHeight()];
        objects3D = new ArrayList<>();
        mL = new ArrayList<>();
    }

    public void reset() {
        for (int i = 0; i < size.getX(); i++) {
            for (int j = 0; j < size.getY(); j++) {
                addPixel(i, j, brackground, Integer.MIN_VALUE);
            }
        }
    }

    public void draw() {
        for (Object3D obj : getObjects3D()) {
            obj.draw(this);
        }
    }

    public void fill() {

        for (Object3D x : getObjects3D()) {

            for (Point3D p : x.getPoints()) {

                int i = (int) (center.getX() - p.getY());
                int j = (int) (p.getX() + center.getY());

                if (p.getZ() >= depth[(int) (i * size.getY() + j)]) {

                    depth[(int) (i * size.getX() + j)] = p.getZ();
                    canvas.setRGB(j,i, x.getColorFill().getRGB());

                }

            }
        }

        for (int i = 0; i < size.getX(); i++) {
            for (int j = 0; j < size.getY(); j++) {

                for (Object3D x : getObjects3D()) {
                    if(x instanceof Poligno)
                        if (x.intercept((int) (j - size.getY() / 2), (int)size.getX() / 2 - i)) {

                            int prof = x.getDepht((int)(j - size.getY() / 2), (int)(size.getX() / 2 - i));

                            if (prof >= depth[(int)(i * size.getX() + j)]) {

                                depth[(int)(i * size.getX() + j)] = prof;
                                canvas.setRGB(j,i, x.getColorFill().getRGB());

                            }

                        }
                }

            }
        }

    }

    public void addPixelCenter(int x, int y, Color color, int depth) {

        int j = (int) (center.getY() + x);
        int i = (int) (center.getX() - y);

        canvas.setRGB(j,i, color.getRGB());

        this.depth[i * (int) size.getX() + j] = depth;
    }

    public void addPixel(int x, int y, Color color, int depth) {
        canvas.setRGB(x, y, color.getRGB());
        this.depth[x * (int) size.getX() + y] = depth;
    }

    public Color getBrackground() {
        return brackground;
    }

    public void setBrackground(Color brackground) {
        this.brackground = brackground;
    }

    public BufferedImage getCanvas() {
        return canvas;
    }

    public void setCanvas(BufferedImage canvas) {
        this.canvas = canvas;
    }

    public Point2D getSize() {
        return size;
    }

    public void setSize(Point2D size) {
        this.size = size;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public Integer[] getDepth() {
        return depth;
    }

    public void setDepth(Integer[] depth) {
        this.depth = depth;
    }

    public ArrayList<Object3D> getObjects3D() {
        return objects3D;
    }

    public void setObjects3D(ArrayList<Object3D> objects3D) {
        this.objects3D = objects3D;
    }

    public ArrayList<MalhaPoligno> getmL() {
        return mL;
    }

    public void setmL(ArrayList<MalhaPoligno> mL) {
        this.mL = mL;
    }



    
}
