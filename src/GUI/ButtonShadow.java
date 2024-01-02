package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonShadow extends JButton
{

        public static JButton createButtonWithShadow(String text) {
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(150, 40));

            // Aggiungi un ascoltatore per gestire gli eventi del mouse
            button.addMouseListener(new MouseAdapter() {
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

            // Rimuovi il bordo standard del pulsante
            button.setBorderPainted(true);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);

            return button;
        }
    }

