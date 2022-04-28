package projet;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates how to draw lines using Graphics2D object.
 * @author www.codejava.net
 *
 */
public class DrawLine extends JFrame {
    public DrawLine() {
    }


    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(0, 0, 0, 0);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}