package GUI;

import javax.swing.border.AbstractBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

public class RounderBorder extends AbstractBorder
{
    //classe che consente di avere i bordi arrotondati e colorati
    private final int radius;

    public RounderBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.orange); // Puoi cambiare il colore del bordo se lo desideri
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 1, radius + 1, radius + 2, radius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = radius + 1;
        insets.top = insets.bottom = radius + 2;
        return insets;
    }
}

