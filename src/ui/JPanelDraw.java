/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import tela.Projection;
import tela.ZBuffer;

/**
 *
 * @author jean
 */
public class JPanelDraw extends JPanel {

    private ZBuffer screen;
    private Projection projection;
    
    public JPanelDraw(int width, int height) {
        
        setPreferredSize(new Dimension(width, height));  
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Point size = new Point(height,width);
        Point center = new Point(height / 2,width / 2);
        screen = new ZBuffer(bufferedImage, size, center, Color.WHITE);
        screen.reset();
        
        projection = new Projection(0);
        
    }
    
    public void start(){
        screen.reset();
        //projection.insertObjects3D(screen.getObjects3D());
        //projection.startProjection();
        screen.draw();
        screen.fill();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D) grphcs;
        
        Graphics2D d2 = screen.getCanvas().createGraphics();

        d2.setColor(Color.RED);
        
        d2.fillOval((int)screen.getSize().getX()/2,(int)screen.getSize().getX()/2,5,5);
        
        g2d.drawImage(screen.getCanvas(), 0, 0, null);
        g2d.dispose();
    }

    public ZBuffer getScreen() {
        return screen;
    }

    public void setScreen(ZBuffer screen) {
        this.screen = screen;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

}
