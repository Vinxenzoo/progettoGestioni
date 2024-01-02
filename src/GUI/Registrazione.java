package GUI;

import DTO.PartecipanteDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Registrazione extends JFrame
{

    private JTextField emailField;

    private JTextField nomefield;

    private JTextField num_civicofield;

    private JTextField titolofield;

    private JTextField cognomefield;

    private JTextField istruzionefield;

    private JTextField Partec_sfield;

    private JTextField Keynotefield;
    private JPasswordField passwordField;


    private JPanel sinusoidPanel;

    public Registrazione() {
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.GRAY);  // Colore di sfondo
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };


        setTitle("Pagina Login ccoordinatore ed Organizzatore");
        setSize(1050, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font labelFont = new Font("Helvetica", Font.BOLD, 16);

        JLabel titleLabel = new JLabel("Registrati per entrare nel nostro ambiente ", SwingConstants.CENTER);
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

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Aggiungi uno sfondo all'immagine nel pannello centrale
                ImageIcon backgroundImage = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini/lampadina.jpeg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        centerPanel.setOpaque(false);


        Font labelFont = new Font("Times New Roman", Font.BOLD, 15);

        Font labeltitle = new Font("Times New Roman", Font.BOLD, 20);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Allineamento al centro
        gbc.insets = new Insets(5, 0, 5, 0); // Aggiungi spazio tra i componenti

        // Aggiungi la frase sopra i textfield
        JLabel loginLabel = new JLabel("Metti qui i tuoi dati per la Registrazione!!");
        loginLabel.setFont(labeltitle);
        bounceEffect(loginLabel);
        loginLabel.setForeground(Color.BLUE);
        centerPanel.add(loginLabel, gbc);

        //nome partecipante
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(labelFont);
        bounceEffect(nomeLabel);
        nomeLabel.setForeground(Color.orange);
        centerPanel.add(nomeLabel, gbc);

        gbc.gridx = 3;
        nomefield = new JTextField(13);
        nomefield.setFont(labelFont);
        nomefield.setBorder(createRoundedBorder());
        nomefield.setBorder(new RounderBorder(10));
        centerPanel.add(nomefield, gbc);


        //num_civico
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel num_civico = new JLabel("Num_civico:");
        num_civico.setFont(labelFont);
        bounceEffect(num_civico);
        num_civico.setForeground(Color.orange);
        centerPanel.add(num_civico, gbc);

        gbc.gridx = 3;
        num_civicofield= new JTextField(13);
        num_civicofield.setFont(labelFont);
        num_civicofield.setBorder(createRoundedBorder());
        num_civicofield.setBorder(new RounderBorder(10));
        centerPanel.add(num_civicofield, gbc);


        //cognome partceipante
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel cognomelabel = new JLabel("Cognome:");
        cognomelabel.setFont(labelFont);
        bounceEffect(cognomelabel);
        cognomelabel.setForeground(Color.orange);
        centerPanel.add(cognomelabel, gbc);


        gbc.gridx = 3;
        cognomefield = new JTextField(13);
        cognomefield.setFont(labelFont);
        cognomefield.setBorder(createRoundedBorder());
        cognomefield.setBorder(new RounderBorder(10));
        centerPanel.add(cognomefield, gbc);

        //titolo
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel titolo = new JLabel("titolo:");
        titolo.setFont(labelFont);
        bounceEffect(titolo);
        titolo.setForeground(Color.orange);
        centerPanel.add(titolo, gbc);

        gbc.gridx = 3;
        titolofield = new JTextField(13);
        titolofield.setFont(labelFont);
        titolofield.setBorder(createRoundedBorder());
        titolofield.setBorder(new RounderBorder(10));
        centerPanel.add( titolofield, gbc);


        //Istruzione
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel istruzione = new JLabel("Istruzione:");
        istruzione.setFont(labelFont);
        bounceEffect(istruzione);
        istruzione.setForeground(Color.orange);
        centerPanel.add(istruzione, gbc);

        gbc.gridx = 3;
        istruzionefield = new JTextField(13);
        istruzionefield.setFont(labelFont);
        istruzionefield.setBorder(createRoundedBorder());
        istruzionefield.setBorder(new RounderBorder(10));
        centerPanel.add( istruzionefield, gbc);

        //Partecipante speciale
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel Partec_s = new JLabel("Specifico? ");
        Partec_s.setFont(labelFont);
        bounceEffect(Partec_s);
        Partec_s.setForeground(Color.orange);
        centerPanel.add(Partec_s, gbc);

        gbc.gridx = 3;
        Partec_sfield = new JTextField(13);
        Partec_sfield.setFont(labelFont);
        Partec_sfield.setBorder(createRoundedBorder());
        Partec_sfield.setBorder(new RounderBorder(10));
        centerPanel.add( Partec_sfield, gbc);

        //Partecipante speciale
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel Keynote = new JLabel("Keynote? ");
        Keynote.setFont(labelFont);
        bounceEffect(Keynote);
        Keynote.setForeground(Color.orange);
        centerPanel.add(Keynote, gbc);

        gbc.gridx = 3;
        Keynotefield = new JTextField(13);
        Keynotefield.setFont(labelFont);
        Keynotefield.setBorder(createRoundedBorder());
        Keynotefield.setBorder(new RounderBorder(10));
        centerPanel.add( Keynotefield, gbc);



        // Email
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        bounceEffect(emailLabel);
        emailLabel.setForeground(Color.orange);
        centerPanel.add(emailLabel, gbc);

        gbc.gridx = 3;
        gbc.ipadx = 0; // Aumenta la larghezza preferita
        emailField = new JTextField(13);
        emailField.setFont(labelFont);
        emailField.setBorder(createRoundedBorder());
        emailField.setBorder(new RounderBorder(10));
        centerPanel.add(emailField, gbc);

        // Password
        gbc.gridx = 2;
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        bounceEffect(passwordLabel);
        passwordLabel.setForeground(Color.orange);
        centerPanel.add(passwordLabel, gbc);

        gbc.gridx = 3;
        passwordField = new JPasswordField(13);
        passwordField.setFont(labelFont);
        passwordField.setBorder(createRoundedBorder());
        passwordField.setBorder(new RounderBorder(10));
        centerPanel.add(passwordField, gbc);

        // Pulsante di login
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        JButton loginButton = ButtonShadow.createButtonWithShadow("Login Personale");
        bounceEffect(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               login();
            }
        });
        loginButton.setForeground(Color.blue);
        centerPanel.add(loginButton, gbc);

       gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        JButton Button = ButtonShadow.createButtonWithShadow("Torna all'anteprima");
        bounceEffect(loginButton);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomePageNonReg();
            }
        });
        Button.setForeground(Color.blue);
        centerPanel.add(Button, gbc);





        return centerPanel;
    }
    private void login() {


        String nome = nomefield.getText();
        String cognome = cognomefield.getText();

        String inputext = num_civicofield.getText();
        Integer intvalue = Integer.valueOf(inputext);


        String tit = titolofield.getText();
        String istr = istruzionefield.getText();
        String partec = Partec_sfield.getText();
        String  keynote = Keynotefield.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        // Verifica le credenziali nel database
        DBConnection dbConnection = DBConnection.getConnessione();
        Controller controller = new Controller(dbConnection);


        PartecipanteDTO parteci = new PartecipanteDTO(nome, intvalue, cognome, email, tit, istr, partec, keynote, password);

        if(!parteci.getNome().isEmpty())
        {
            if(parteci.getNumCivico() != 0)
            {
                if(!parteci.getCognome().isEmpty())
                {
                    if(!parteci.getEmail().isEmpty())
                    {
                        if(!parteci.getPassword().isEmpty())
                        {

                            if (controller.verifica(parteci)) {
                                new StatusPanel("Registrazione effettuata, adesso effettua il login", true);
                                new PaginaLogin();
                            } else {
                                new StatusPanel("Credenziali Errate", false);
                            }

                        }
                        else
                        {
                            new StatusPanel("Campo Password obbligatorio, immettilo", false);
                        }
                    }
                    else
                    {
                        new StatusPanel("Campo Email obbligatorio, immettilo", false);
                    }


                }
                else
                {
                    new StatusPanel("Cognome obbligatorio, immettilo", false);
                }
            }
            else
            {
                new StatusPanel("Numero civico obbligatorio, immettilo", false);
            }
        }
        else
        {
            new StatusPanel("Nome obbligatorio immettilo", false);
        }


    }
    private void bounceEffect(JComponent component) {
        Timer timer = new Timer(130, new ActionListener() {
            int deltaY = 1;
            int direction = 4;
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

    }



        private Border createRoundedBorder() {
        int radius = 15; // Puoi regolare questo valore a tuo piacimento
        Border line = new LineBorder(Color.ORANGE); // Colore del bordo
        Border empty = new EmptyBorder(0, radius, 0, radius); // Spaziatura interna
        return new CompoundBorder(line, empty);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Registrazione loginPage = new Registrazione();
            loginPage.setVisible(true);
        });
    }


    }


