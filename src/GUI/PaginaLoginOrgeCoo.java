package GUI;

import UTILITIES.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaLoginOrgeCoo extends JFrame
{

    private JComboBox<String> ruoloComboBox;
        private JTextField emailField;

        private JTextField nomefield;

        private JTextField cognomefield;
        private JPasswordField passwordField;

        private Controller curr;

        public PaginaLoginOrgeCoo(Controller currcontroller)
        {
            this.curr = currcontroller;
            JPanel mainPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.GRAY);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            setTitle("Pagina Login ccoordinatore ed Organizzatore");
            setSize(1050, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            Font labelFont = new Font("Helvetica", Font.BOLD, 20);

            JLabel titleLabel = new JLabel("Effettua il login per usufruire del nostro ambiente", SwingConstants.CENTER);
            titleLabel.setFont(labelFont);
            titleLabel.setForeground(Color.BLACK);

            Font southfont= new Font("Helvetica", Font.BOLD, 14);

            JLabel labelsouth = new JLabel("Capasso & Agrillo- © 2023", SwingConstants.CENTER);
            labelsouth.setFont(southfont);
            labelsouth.setForeground(Color.BLACK);


            // Aggiunta del pannello del titolo centrato nella parte superiore
            mainPanel.add(titleLabel, BorderLayout.NORTH);
            mainPanel.add(labelsouth, BorderLayout.SOUTH);
            mainPanel.add(createCenterPanel(), BorderLayout.CENTER);

            add(mainPanel);
            setVisible(true);

        }

        private JPanel createCenterPanel()
        {
            JPanel centerPanel = new JPanel(new GridBagLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Aggiungi uno sfondo all'immagine nel pannello centrale
                    ImageIcon backgroundImage = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini/lab3.jpg");
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            };

            centerPanel.setOpaque(false);

            Font labelFont = new Font("Times New Roman", Font.BOLD, 20);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER; // Allineamento al centro
            gbc.insets = new Insets(15, 0, 15, 0); // Aggiungi spazio tra i componenti

            // Aggiungi la frase sopra i textfield
            JLabel loginLabel = new JLabel("                                                                         ");
            loginLabel.setFont(labelFont);
            bounceEffect(loginLabel);
            loginLabel.setOpaque(false);
            loginLabel.setForeground(new Color(0, 255, 255, 200));
            centerPanel.add(loginLabel, gbc);



            gbc.gridx = 102;
            gbc.gridy++;

            // Aggiunta della JComboBox con le opzioni "Organizzatore" e "Coordinatore"
            String[] ruoloOptions = {"organizzatore", "coordinatore"};
            ruoloComboBox = new JComboBox<>(ruoloOptions);
            ruoloComboBox.setFont(labelFont);
            centerPanel.add(ruoloComboBox, gbc);


            //nome partecipante
            gbc.gridx=100;
            gbc.gridy++;
            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setFont(labelFont);
            bounceEffect(nomeLabel);
            nomeLabel.setForeground(Color.ORANGE);
            centerPanel.add(nomeLabel, gbc);


            gbc.gridx =102;
            gbc.ipadx = 0; // Aumenta la larghezza preferita
            nomefield = new JTextField(13);
            nomefield.setFont(labelFont);
            nomefield.setBorder(createRoundedBorder());
            nomefield.setBorder(new RounderBorder(10));
            centerPanel.add(nomefield, gbc);


            //cognome partceipante
            gbc.gridx=100;
            gbc.gridy++;
            JLabel cognomelabel = new JLabel("Cognome:");
            cognomelabel.setFont(labelFont);
            bounceEffect(cognomelabel);
            cognomelabel.setForeground(Color.ORANGE);
            centerPanel.add(cognomelabel, gbc);


            gbc.gridx = 102;
            gbc.ipadx = 0; // Aumenta la larghezza preferita
            cognomefield = new JTextField(13);
            cognomefield.setFont(labelFont);
            cognomefield.setBorder(createRoundedBorder());
            cognomefield.setBorder(new RounderBorder(10));
            centerPanel.add(cognomefield, gbc);


            // Email
            gbc.gridx=100;
            gbc.gridy++;
            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setFont(labelFont);
            bounceEffect(emailLabel);
            emailLabel.setForeground(Color.orange);
            centerPanel.add(emailLabel, gbc);

            gbc.gridx = 102;
            gbc.ipadx = 0; // Aumenta la larghezza preferita
            emailField = new JTextField(13);
            emailField.setFont(labelFont);
            emailField.setBorder(createRoundedBorder());
            emailField.setBorder(new RounderBorder(10));
            centerPanel.add(emailField, gbc);

            // Password
            gbc.gridx=100;
            gbc.gridy++;
            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setFont(labelFont);
            bounceEffect(passwordLabel);
            passwordLabel.setForeground(Color.orange);
            centerPanel.add(passwordLabel, gbc);

            gbc.gridx = 102;
            passwordField = new JPasswordField(13);
            passwordField.setFont(labelFont);
            passwordField.setBorder(createRoundedBorder());
            passwordField.setBorder(new RounderBorder(10));
            centerPanel.add(passwordField, gbc);

            // Pulsante di login
            gbc.gridx = 102;
            gbc.gridy = 6;
            gbc.gridwidth = 2;
            JButton loginButton = ButtonShadow.createButtonWithShadow("Login Personale");
            bounceEffect(loginButton);
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  login();
                }
            });
            loginButton.setForeground(Color.ORANGE);
            centerPanel.add(loginButton, gbc);


            return centerPanel;
        }

    private void login()
    {
        // Ottieni i valori dalle caselle di testo
        String email = emailField.getText();
        String nome = nomefield.getText();
        String cognome = cognomefield.getText();
        String password = new String(passwordField.getPassword());

        String ruolo = (String) ruoloComboBox.getSelectedItem();



        if(ruolo == "organizzatore")
        {
            if (curr.accessoorg(nome, cognome, email, password))
            {
                new StatusPanel("Accesso Riuscito", true);

                dispose();

                new HomePageOrg(curr);
            }
            else {
                new StatusPanel("Credenziali non valide", false);
            }
            dispose();
        }
        else
        {
            if(ruolo == "coordinatore")
            {
                if (curr.accessocoo(nome, cognome, email, password))
                {

                    new HomePageCoo(curr);
                }
                else
                {
                    new StatusPanel("Credenziali non valide", false);
                }

                dispose();
            }
        }

    }

    private void bounceEffect(JComponent component) {
        Timer timer = new Timer(130, new ActionListener() {
            int deltaY = 1;
            int direction = 1;
            int countDown = 10000;

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


        private Border createRoundedBorder() {
            int radius = 15; // Puoi regolare questo valore a tuo piacimento
            Border line = new LineBorder(Color.ORANGE); // Colore del bordo
            Border empty = new EmptyBorder(0, radius, 0, radius); // Spaziatura interna
            return new CompoundBorder(line, empty);
        }



    }
