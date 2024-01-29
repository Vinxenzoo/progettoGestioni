package GUI;

import UTILITIES.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImmagineProgetto extends JFrame
{

    private Controller curr;

        public ImmagineProgetto(Controller currcontroller)
        {
            this.curr = currcontroller;
            // Creazione del pannello principale
            JPanel mainPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image background = new ImageIcon("/Users/capasso/Desktop/progetto capasso-agrillo/modifiche_apportate.jpg").getImage();
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Altri componenti e impostazioni della finestra
            setTitle("Altra Pagina");
            setSize(1500, 1500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Creazione del pulsante per tornare alla HomePage con ombra al passaggio del cursore
            JButton backButton = ButtonShadow.createButtonWithShadow("Torna alla HomePage");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Chiudi l'attuale finestra e crea una nuova HomePage
                    dispose();
                    new HomePage(curr);
                }
            });



                // Aggiunta del pulsante al pannello principale
            mainPanel.add(backButton, BorderLayout.SOUTH);

            // Aggiunta del pannello principale alla finestra
            add(mainPanel);

            // Impostazione della finestra come visibile
            setVisible(true);
        }


}
