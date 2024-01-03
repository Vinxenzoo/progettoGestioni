package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePageNonReg extends JFrame
{
        public HomePageNonReg() {
            // Creazione del pannello principale
            JPanel mainPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.gray);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            // Altri componenti e impostazioni della finestra
            setTitle("HomePage aperta a tutti!! ");
            setSize(1000, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Aggiunta dei pannelli e altri componenti al pannello principale
            mainPanel.add(new JLabel("Questa è un'anteprima della nostra Home Page!", SwingConstants.CENTER), BorderLayout.NORTH);
            mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
            mainPanel.add(new JLabel("Capasso & Agrillo- © 2023", SwingConstants.CENTER), BorderLayout.SOUTH);

            // Aggiunta del pannello principale alla finestra
            add(mainPanel);

            // Impostazione della finestra come visibile
            setVisible(true);
        }

        private JPanel createCenterPanel() {
            // Creazione del pannello centrale con sfondo immagine
            JPanel centerPanel = new JPanel(new GridLayout(1, 4)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image background = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini/homepage2.jpeg").getImage();
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Creazione dei bottoni con ombra al passaggio del cursore
            JButton button1 = createButtonWithShadow("Anteprima delle nostre Conferenze");
            JButton button2 = createButtonWithShadow("il Nostro Progetto conferenze");
            JButton button3 = createButtonWithShadow("Corri A Registrarti");
            JButton button4 = createButtonWithShadow("Torna Indietro ed Accedi");

            // Aggiunta dei bottoni al pannello centrale
            centerPanel.add(button1);
            centerPanel.add(button2);
            centerPanel.add(button3);
            centerPanel.add(button4);

            // Aggiunta di azioni ai bottoni
            button1.addActionListener(e -> {



                MostraconfinguiNREG conferenzagui = new MostraconfinguiNREG();
                conferenzagui.setVisible(true);
                dispose();
            });

            button2.addActionListener(e -> {


                ImmagineProgettoNonReg altraClasse = new ImmagineProgettoNonReg();
                altraClasse.setVisible(true);
                dispose();
            });

            button3.addActionListener(e -> {
                    Registrazione Reg = new Registrazione();
                    Reg.setVisible(true);
                    dispose();

                    });
            button4.addActionListener(e -> {

                PaginaLogin pag = new PaginaLogin();
                pag.setVisible(true);
                dispose();

            });
            return centerPanel;
        }

        private JButton createButtonWithShadow(String text)
        {
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(150, 70));

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
            button.setForeground(Color.gray);

            // Rimuovi il bordo standard del pulsante
            button.setBorderPainted(true);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);


            return button;
        }

    }

