package GUI;

import DTO.ConferenzaDTO;
import UTILITIES.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class Mostraconfingui extends JFrame
{
        private JComboBox<String> conferenzaComboBox;
        private DefaultComboBoxModel<String> conferenzaComboBoxModel;

        private Controller curr;
        public Mostraconfingui(Controller currcontroller)
        {
            this.curr = currcontroller;
            // Creazione del pannello principale
            JPanel mainPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image background = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini/homepage3.jpeg").getImage();
                    Image scaledImage = background.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Altri componenti e impostazioni della finestra
            setTitle("Dettagli Conferenze");
            setSize(1100, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            Font labelFont = new Font("Times New Roman", Font.PLAIN, 20);

            JLabel titleLabel = new JLabel("Dai un'occhiata alle nostre Conferenze!!! ", SwingConstants.CENTER);
            titleLabel.setFont(labelFont);
            titleLabel.setForeground(Color.BLACK);

            JPanel titlePanel = new JPanel(new BorderLayout());
            titlePanel.add(titleLabel, BorderLayout.CENTER);

            // Aggiunta del pannello del titolo centrato nella parte superiore
            mainPanel.add(titlePanel, BorderLayout.NORTH);
            mainPanel.add(new JLabel("Capasso & Agrillo - © 2023", SwingConstants.CENTER), BorderLayout.SOUTH);

            // Aggiunta del pannello centrale con la JComboBox e il pulsante "Torna Indietro"
            mainPanel.add(createCenterPanel(), BorderLayout.CENTER);

            // Impostazione della finestra come visibile
            add(mainPanel);
            setVisible(true);

            // Chiamata per aggiornare la JComboBox
            updateConferenzaComboBox();
        }

        // Metodo che crea e restituisce il pannello centrale con sfondo immagine
        private JPanel createCenterPanel() {
            JPanel centerPanel = new JPanel(new GridBagLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image background = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini/lib2.jpeg").getImage();
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                }
            };

            GridBagConstraints gbc = new GridBagConstraints();

            conferenzaComboBoxModel = new DefaultComboBoxModel<>();
            conferenzaComboBox = new JComboBox<>(conferenzaComboBoxModel);

            // Imposta le dimensioni desiderate per la JComboBox
            conferenzaComboBox.setPreferredSize(new Dimension(350, 90));


            centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

            centerPanel.add(conferenzaComboBox);

         gbc.anchor =  GridBagConstraints.CENTER;

            gbc.gridx = 6;
            gbc.gridy ++;
            gbc.insets = new Insets(10, 0, 10, 0); // Spazio tra la JComboBox e il pulsante
            centerPanel.add(conferenzaComboBox, gbc);

            // Configura il GridBagConstraints per il pulsante "Login Partecipante"
            JButton loginButton = createButtonWithShadow("Guarda le nostre Sessioni");
            bounceEffect(loginButton);
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                    new TabellaSessione(curr);
                }
            });
            loginButton.setForeground(Color.BLUE);

            gbc.gridy ++;
            gbc.insets = new Insets(350, 0, 50, 0); // Resetta lo spazio tra gli elementi
            centerPanel.add(loginButton, gbc);

            centerPanel.add(Box.createVerticalGlue(), gbc); // Spazio vuoto sotto il pulsante



            return centerPanel;
        }

    public static JButton createButtonWithShadow(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 150));


        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBorder(BorderFactory.createLineBorder(Color.black, 3));
                button.setSize(new Dimension(150, 100));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBorder(BorderFactory.createEmptyBorder(0, 3, 3, 3));
                button.setSize(new Dimension(150, 100));
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


    private void bounceEffect(JComponent component) {
        Timer timer = new Timer(130, new ActionListener() {
            int deltaY = 1;
            int direction = 1;
            int countDown = 1000;

            @Override
            public void actionPerformed(ActionEvent e) {
                int newY = component.getLocation().y + deltaY * direction;
                component.setLocation(component.getLocation().x, newY);

                if (newY <= 0 || newY >= 10) {
                    direction *= -1;
                }

                if (--countDown <= 0) {
                    ((Timer) e.getSource()).stop();
                    component.setLocation(component.getLocation().x, 0);
                }
            }
        });

        timer.start();
    }


    // Metodo che ottiene i nomi delle conferenze dal controller
        private void updateConferenzaComboBox()
        {


            List<ConferenzaDTO> listaConferenze = curr.getListaConferenze();

            // Pulisci il modello della JComboBox
            conferenzaComboBoxModel.removeAllElements();

            // Aggiungi le informazioni delle conferenze al modello della JComboBox
            for (ConferenzaDTO conferenza : listaConferenze) {
                conferenzaComboBoxModel.addElement(conferenza.getDescrizione());
            }
        }

    }














