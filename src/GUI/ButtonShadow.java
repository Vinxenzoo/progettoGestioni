package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonShadow extends JButton
{
    //questa classe consente di creare bottoni di una dimesione standard che siano con un'ombra dietro.

        public static JButton createButtonWithShadow(String text) {
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(150, 40));

            // ascoltatore per gestire gli eventi
            button.addMouseListener(new MouseAdapter() {
                //con questo override posso settare a piacimento l'animazione del bottone
                @Override
                public void mouseEntered(MouseEvent evt) {
                    button.setBorder(BorderFactory.createLineBorder(Color.black, 3));
                    button.setSize(new Dimension(150, 50));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    button.setBorder(BorderFactory.createEmptyBorder(0, 3, 3, 3));
                    button.setSize(new Dimension(150, 50));
                }
            });

            // Stile del testo del pulsante
            button.setForeground(Color.BLACK);

            // Rimozione del bordo standard del pulsante
            button.setBorderPainted(true);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);

            return button;
        }
    }

