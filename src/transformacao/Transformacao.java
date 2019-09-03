/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacao;

import points.Point3D;

/**
 *
 * @author jean
 */
public class Transformacao {

    public static void rotacaoZ(Point3D p, double grausD, Point3D origem) {

        int tX = origem.getX(), tY = origem.getY();

        translacaoX(p, -tX);
        translacaoY(p, -tY);

        double grausR = Math.toRadians(grausD);
        int x = (int) Math.round(p.getX() * Math.cos(grausR) - (p.getY() * Math.sin(grausR)));
        int y = (int) Math.round(p.getX() * Math.sin(grausR) + (p.getY() * Math.cos(grausR)));

        p.setX(x);
        p.setY(y);

        translacaoX(p, tX);
        translacaoY(p, tY);
    }

    public static void rotacaoX(Point3D p, double grausD, Point3D origem) {

        int tY = origem.getY(), tZ = origem.getZ();

        translacaoY(p, -tY);
        translacaoZ(p, -tZ);

        double grausR = Math.toRadians(grausD);
        int y = (int) Math.round(p.getY() * Math.cos(grausR) + (p.getZ() * Math.sin(grausR)));
        int z = (int) Math.round(p.getY() * -Math.sin(grausR) + (p.getZ() * Math.cos(grausR)));

        p.setY(y);
        p.setZ(z);

        translacaoY(p, tY);
        translacaoZ(p, tZ);

    }

    public static void rotacaoY(Point3D p, double grausD, Point3D origem) {

        int tX = origem.getX(), tZ = origem.getZ();

        translacaoX(p, -tX);
        translacaoZ(p, -tZ);

        double grausR = Math.toRadians(grausD);
        int x = (int) Math.round(p.getZ() * Math.sin(grausR) + (p.getX() * Math.cos(grausR)));
        int z = (int) Math.round(p.getZ() * Math.cos(grausR) - (p.getX() * Math.sin(grausR)));

        p.setX(x);
        p.setZ(z);

        translacaoX(p, tX);
        translacaoZ(p, tZ);
    }

    public static void escalaX(Point3D p, double e, Point3D origem) {

        int tX = origem.getX();

        translacaoX(p, -tX);

        int x = (int) Math.round(p.getX() * e);

        p.setX(x);

        translacaoX(p, tX);
    }

    public static void escalaY(Point3D p, double e, Point3D origem) {

        int tY = origem.getY();

        translacaoY(p, -tY);

        int y = (int) Math.round(p.getY() * e);

        p.setY(y);

        translacaoY(p, tY);
    }

    public static void escalaZ(Point3D p, double e, Point3D origem) {

        int tZ = origem.getZ();

        translacaoZ(p, -tZ);

        int z = (int) Math.round(p.getZ() * e);

        p.setZ(z);

        translacaoZ(p, tZ);
    }

    public static void translacaoX(Point3D p, double t) {
        int x = (int) Math.round(p.getX() + t);
        p.setX(x);
    }

    public static void translacaoY(Point3D p, double t) {
        int y = (int) Math.round(p.getY() + t);
        p.setY(y);
    }

    public static void translacaoZ(Point3D p, double t) {
        int z = (int) Math.round(p.getZ() + t);
        p.setZ(z);
    }

}
