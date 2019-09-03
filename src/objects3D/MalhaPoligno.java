/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects3D;

import java.util.ArrayList;
import points.Point3D;

/**
 *
 * @author jean
 */
public abstract class MalhaPoligno {
    public abstract Point3D getOrigin();
    public abstract ArrayList<Point3D> getPoints();
}
