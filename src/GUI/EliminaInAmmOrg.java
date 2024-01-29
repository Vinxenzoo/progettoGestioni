package GUI;

import DTO.AmmissioneDTO;
import UTILITIES.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EliminaInAmmOrg extends JFrame
{
        private JTable table;
        private Controller curr;

        public EliminaInAmmOrg(Controller currcontroller)
        {
            this.curr = currcontroller;
            JPanel mainPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.gray);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            // Altri componenti e impostazioni della finestra
            setTitle("Pannello Partecipazioni");
            setSize(1000, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Aggiunta dei pannelli e altri componenti al pannello principale
            mainPanel.add(new JLabel("Elimina Partecipante da SEssione!", SwingConstants.CENTER), BorderLayout.NORTH);
            mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
            mainPanel.add(createBottomPanel(), BorderLayout.SOUTH);

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

            DefaultTableModel tableModel = createTableModelFromDB();

            // Creazione della tabella
            table = new JTable(tableModel);

            customizeTableAppearance(table);

            // Aggiunta della tabella a uno JScrollPane per supportare lo scorrimento
            JScrollPane scrollPane = new JScrollPane(table);
            centerPanel.add(scrollPane, BorderLayout.CENTER);

            // Aggiunta del pannello principale alla finestra
            add(centerPanel);

            // Impostazione della finestra come visibile
            setVisible(true);


            return centerPanel;
        }

        private void customizeTableAppearance(JTable table) {
            // Imposta uno sfondo personalizzato per le celle della tabella
            table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Imposta uno sfondo per le celle
                    c.setBackground(row % 2 == 0 ? Color.lightGray : new Color(240, 240, 240));

                    // Imposta l'altezza della riga
                    table.setRowHeight(row, 40);

                    // Aggiunta un bordo alle celle
                    Border border = BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK);
                    ((JComponent) c).setBorder(border);

                    return c;
                }
            });
        }

        private JPanel createBottomPanel() {
            // Creazione del pannello in basso con il bottone "Torna alla Home"
            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER))
            {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.gray);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            JButton homeButton = createButtonWithShadow("Torna alle Sessioni");
            homeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logica per tornare alla Home, ad esempio chiudere questa finestra e aprire la Home
                    dispose();
                    new TabellaSessioneOrg(curr);
                }
            });

            bottomPanel.add(homeButton);

            JButton elimina = createButtonWithShadow("Elimina Partecipante");
            elimina.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    showPanel();

                }
            });

            bottomPanel.add(elimina);

            return bottomPanel;
        }

        private void showPanel() {
            JFrame inputFrame = new JFrame("Inserisci Valore");
            inputFrame.setSize(600, 350);
            inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            inputFrame.setLocationRelativeTo(null);

            Image backgroundImage = new ImageIcon("/Users/capasso/Desktop/progetto_OO/progettoGestioni/immagini/lab6.jpeg").getImage();

            // Crea un pannello personalizzato con sfondo
            JPanel inputPanel = new JPanel(new GridBagLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };



            Font labelFont = new Font("Times New Roman", Font.BOLD, 20);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.CENTER; // Allineamento al centro
            gbc.insets = new Insets(15, 0, 20, 0);

            gbc.gridx = 1;
            gbc.gridy =0;
            JLabel loginLabel = new JLabel("Elimina Partecipante                                     ");
            loginLabel.setFont(labelFont);

            loginLabel.setForeground(Color.BLACK);
            inputPanel.add(loginLabel, gbc);


            JLabel label = new JLabel("          Codice Partecipante:");
            gbc.gridx = 0;
            gbc.gridy++;
            label.setFont(labelFont);
            label.setForeground(Color.black);
            inputPanel.add(label, gbc);


            JTextField text = new JTextField(13);
            gbc.gridx = 1;
            text.setFont(labelFont);
            inputPanel.add(text, gbc);

            JLabel seslabel = new JLabel("          Codice Sessione:");
            gbc.gridx = 0;
            gbc.gridy++;
            seslabel.setFont(labelFont);
            seslabel.setForeground(Color.black);
            inputPanel.add(seslabel, gbc);


            JTextField sestext = new JTextField(13);
            gbc.gridx = 1;
            sestext.setFont(labelFont);
            inputPanel.add(sestext, gbc);

            JButton confirmButton = createButtonWithShadow("Conferma");
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {

                        String valuetext = text.getText();
                        Integer value = Integer.valueOf(valuetext);

                        String ses = sestext.getText();
                        Integer sesvalue = Integer.valueOf(ses);


                        curr.cancellap(value, sesvalue);


                        new StatusPanel("Operazione andata a buon fine", true);

                        new TabellaSessioneOrg(curr);
                    } catch (NumberFormatException ex)
                    {
                        // Se il valore non è un intero valido
                        new StatusPanel("Inserisci valore numerico valido", false);
                    }
                }
            });

            gbc.gridx =1;
            gbc.gridy++;
            inputPanel.add(confirmButton, gbc);

            inputFrame.add(inputPanel);
            inputFrame.setVisible(true);
        }




        private DefaultTableModel createTableModelFromDB() {
            DefaultTableModel tableModel = new DefaultTableModel();

            try {


                List<AmmissioneDTO> ammlist = curr.getListaammissione();

                // Colonne della tabella
                String[] columnNames = {"Codise Sessione", "Codice Partecipante"};

                // Aggiunge le colonne al modello della tabella
                tableModel.setColumnIdentifiers(columnNames);

                String no= ""; String cognom = "";

                // Aggiunge i dati al modello della tabella
                for (AmmissioneDTO ammissione : ammlist) {


                    Object[] rowData = {ammissione.getSessione(), ammissione.getPartecipante()};
                    tableModel.addRow(rowData);
                }
            } catch (Exception e) {
                // Gestione delle eccezioni,
                e.printStackTrace();
            }

            return tableModel;
        }





        private JButton createButtonWithShadow(String text)
        {
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(200, 25));

            // Aggiunta di un ascoltatore per gestire gli eventi del mouse
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

