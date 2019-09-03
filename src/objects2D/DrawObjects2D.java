/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects2D;

import java.awt.Color;
import objects3D.Object3D;
import points.Point3D;
import tela.ZBuffer;

/**
 *
 * @author jean
 */
public class DrawObjects2D {

    public static void bresenhamLine(int startx, int starty, int endx, int endy, Color color, ZBuffer zBuffer, Object3D obj) {

        int dx = endx - startx;
        int dy = endy - starty;

        int ax = Math.abs(dx) << 1;
        int ay = Math.abs(dy) << 1;

        int signx = (int) Math.signum(dx);
        int signy = (int) Math.signum(dy);

        int x = startx;
        int y = starty;

        int deltax, deltay;
        if (ax >= ay) /* x dominant */ {
            deltay = ay - (ax >> 1);

            while (true) {
                zBuffer.addPixelCenter(x,y, color, obj.getDepht(x,y));
                if (x == endx) {
                    break;
                }

                if (deltay >= 0) {
                    y += signy;
                    deltay -= ax;
                }

                x += signx;
                deltay += ay;
            }
        } else if (ay >= ax) /* y dominant */ {
            deltax = ax - (ay >> 1);

            while (true) {
                zBuffer.addPixelCenter(x,y, color, obj.getDepht(x, y));
                if (y == endy) {
                    break;
                }

                if (deltax >= 0) {
                    x += signx;
                    deltax -= ay;
                }

                y += signy;
                deltax += ax;

            }

        }
        
        
    }

    public static void bresenhamCircle(int xc, int yc, int r, Color color, ZBuffer zBuffer, Object3D obj) {
        int x = 0, y = r;
        int d = 3 - 2 * r;

        while (x <= y) {

            zBuffer.addPixelCenter(xc + x, yc + y, color, obj.getDepht(xc - x, yc + y));
            zBuffer.addPixelCenter(xc - x, yc + y, color, obj.getDepht(xc - x, yc + y));
            zBuffer.addPixelCenter(xc + x, yc - y, color, obj.getDepht(xc + x, yc - y));
            zBuffer.addPixelCenter(xc - x, yc - y, color, obj.getDepht(xc - x, yc - y));
            zBuffer.addPixelCenter(xc + y, yc + x, color, obj.getDepht(xc + y, yc + x));
            zBuffer.addPixelCenter(xc - y, yc + x, color, obj.getDepht(xc - y, yc + x));
            zBuffer.addPixelCenter(xc + y, yc - x, color, obj.getDepht(xc + y, yc - x));
            zBuffer.addPixelCenter(xc - y, yc - x, color, obj.getDepht(xc - y, yc - x));

            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }

            zBuffer.addPixelCenter(xc + x, yc + y, color, obj.getDepht(xc - x, yc + y));
            zBuffer.addPixelCenter(xc - x, yc + y, color, obj.getDepht(xc - x, yc + y));
            zBuffer.addPixelCenter(xc + x, yc - y, color, obj.getDepht(xc + x, yc - y));
            zBuffer.addPixelCenter(xc - x, yc - y, color, obj.getDepht(xc - x, yc - y));
            zBuffer.addPixelCenter(xc + y, yc + x, color, obj.getDepht(xc + y, yc + x));
            zBuffer.addPixelCenter(xc - y, yc + x, color, obj.getDepht(xc - y, yc + x));
            zBuffer.addPixelCenter(xc + y, yc - x, color, obj.getDepht(xc + y, yc - x));
            zBuffer.addPixelCenter(xc - y, yc - x, color, obj.getDepht(xc - y, yc - x));
        }
    }

    public static void draw(Object3D obj, ZBuffer zBuffer, Color color) {

        for (Point3D p : obj.getPoints()) {          
            zBuffer.addPixelCenter(p.getX(), p.getY(), color, p.getZ());
        }
    }
}
