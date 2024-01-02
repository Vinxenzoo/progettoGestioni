package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShadowButton  extends JButton
{

        private static final Color DEFAULT_SHADOW_COLOR = new Color(0, 0, 0, 50);
        private static final int SHADOW_SIZE = 5;

        private Color shadowColor = DEFAULT_SHADOW_COLOR;

        public ShadowButton(String text) {
            super(text);

            setOpaque(true);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setFocusPainted(false);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setForeground(getForeground().darker());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setForeground(getForeground().brighter());
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();

            // Disegna il testo
            super.paintComponent(g2d);

            // Disegna l'ombra
            g2d.setColor(shadowColor);
            g2d.fillRect(0, getHeight() - SHADOW_SIZE, getWidth(), SHADOW_SIZE);

            g2d.dispose();
        }

        public void setShadowColor(Color shadowColor) {
            this.shadowColor = shadowColor;
            repaint();
        }
    }
