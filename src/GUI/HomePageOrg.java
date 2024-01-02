package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePageOrg extends JFrame
{


        public HomePageOrg()
        {
            JPanel mainPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.gray);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            // Altri componenti e impostazioni della finestra
            setTitle("Home Page organizzatori");
            setSize(1000, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Aggiunta dei pannelli e altri componenti al pannello principale
            mainPanel.add(new JLabel("Benvenuto nella Home Page per gli Organizzatori ", SwingConstants.CENTER), BorderLayout.NORTH);
            mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
            mainPanel.add(new JLabel("Capasso & Agrillo- © 2023", SwingConstants.CENTER), BorderLayout.SOUTH);

            // Aggiunta del pannello principale alla finestra
            add(mainPanel);

            // Impostazione della finestra come visibile bkbkkbk
            setVisible(true);
        }

        private JPanel createCenterPanel() {
            // Creazione del pannello centrale con sfondo immagine
            JPanel centerPanel = new JPanel(new GridLayout(1, 4)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image background = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini/lib3.jpeg").getImage();
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Creazione dei bottoni con ombra al passaggio del cursore
            JButton button1 = createButtonWithShadow("Guarda le nostre " +
                    "Conferenze");
            JButton button2 = createButtonWithShadow("Progetto conferenze");
            JButton button3 = createButtonWithShadow("Dai uno sguardo ai Comitati");
            JButton button4 = createButtonWithShadow("Esci Dalla pagina");

            // Aggiunta dei bottoni al pannello centrale
            centerPanel.add(button1);
            centerPanel.add(button2);
            centerPanel.add(button3);
            centerPanel.add(button4);

            // Aggiunta di azioni ai bottoni
            button1.addActionListener(e -> {


                // Modifica il nome della classe a cui vuoi passare il controllo
                MostraConfOrg conferenzagui = new MostraConfOrg();
                conferenzagui.setVisible(true);
                dispose();
            });

            button2.addActionListener(e -> {

                // Modifica il nome della classe a cui vuoi passare il controllo
                ImmagineProgettoOrg altraClasse = new ImmagineProgettoOrg();
                altraClasse.setVisible(true);
                dispose();
            });

            button3.addActionListener(e -> {

                // Modifica il nome della classe a cui vuoi passare il controllo
                TabellaComitato tb = new TabellaComitato();
               tb.setVisible(true);
                dispose();
            });

            button4.addActionListener(e ->
            {
                // Pannello personalizzato
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                // Icona personalizzata
                ImageIcon icon = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini");

                // JLabel per l'immagine
                JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);

                // Testo personalizzato
                JLabel messageLabel = new JLabel("<html><div style='text-align: center;'>" +
                        "Sei sicuro di voler chiudere l'applicazione?</div></html>");

                // Pulsante di conferma
                JButton confirmButton = new JButton("Conferma");
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Chiudi l'applicazione
                        System.exit(0);
                    }
                });

                // Layout del pannello
                panel.add(iconLabel, BorderLayout.NORTH);
                panel.add(messageLabel, BorderLayout.CENTER);
                panel.add(confirmButton, BorderLayout.SOUTH);

                // Finestra di dialogo personalizzata
                JDialog customDialog = new JDialog(this, "Conferma chiusura", true);
                customDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                customDialog.getContentPane().add(panel);
                customDialog.setSize(300, 200);
                customDialog.setLocationRelativeTo(this);
                customDialog.setVisible(true);

            });





            return centerPanel;
        }




        private JButton createButtonWithShadow(String text)
        {
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(150, 70));

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
            button.setForeground(Color.black);

            // Rimuovi il bordo standard del pulsante
            button.setBorderPainted(true);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);


            return button;
        }




        public static void main(String[] args)
        {
            // Avvia l'applicazione
            SwingUtilities.invokeLater(GUI.HomePageOrg::new);
        }

}



