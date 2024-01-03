package GUI;

import DTO.SessioneDTO;
import UTILITIES.Controller;
import UTILITIES.DBConnection;

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

public class TabellaSessioneOrg extends JFrame
{

        private JTable table;

        public TabellaSessioneOrg() {
            JPanel mainPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.gray);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            // Altri componenti e impostazioni della finestra
            setTitle("Le nostre Sessioni");
            setSize(1000, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Aggiunta dei pannelli e altri componenti al pannello principale
            mainPanel.add(new JLabel("Guarda tutte le nostre sessioni!", SwingConstants.CENTER), BorderLayout.NORTH);
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

                    // Aggiungi un bordo alle celle
                    Border border = BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK);
                    ((JComponent) c).setBorder(border);

                    return c;
                }
            });
        }

        private JPanel createBottomPanel() {
            // Creazione del pannello in basso con il bottone "Torna alla Home"
            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.gray);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            JButton homeButton = createButtonWithShadow("Torna alla Home");
            homeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logica per tornare alla Home, ad esempio chiudere questa finestra e aprire la Home
                    dispose();
                    new HomePageOrg();  // Assumendo che HomePage sia la classe per la tua home page
                }
            });

            bottomPanel.add(homeButton);

            JButton elimina = createButtonWithShadow("Elimina partecioante da sessione");
            elimina.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logica per tornare alla Home, ad esempio chiudere questa finestra e aprire la Home
                    dispose();
                    new EliminaInAmmOrg();  // Assumendo che HomePage sia la classe per la tua home page
                }
            });

            bottomPanel.add(elimina);

            JButton viewpart = createButtonWithShadow("visualizza partecipanti");
            viewpart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logica per tornare alla Home, ad esempio chiudere questa finestra e aprire la Home
                    dispose();
                    new ViewPartecipanti();
                }
            });

            bottomPanel.add(viewpart);

            return bottomPanel;
        }

        private DefaultTableModel createTableModelFromDB() {
            DefaultTableModel tableModel = new DefaultTableModel();

            try {

                DBConnection dbConnection = DBConnection.getConnessione();
                Controller co = new Controller(dbConnection);


                List<SessioneDTO> sessionelist = co.getListaSessione();

                // Colonne della tabella
                String[] columnNames = {"Codise Sessione", "Orario Predefinito ", "Ora Prestabilita", "Codice Conferenza"};

                // Aggiunta le colonne al modello della tabella
                tableModel.setColumnIdentifiers(columnNames);

                // Aggiunta i dati al modello della tabella
                for (SessioneDTO sessione : sessionelist) {

                    Object[] rowData = {sessione.getCodSessione(), sessione.getDataPrestabilita(), sessione.getOrarioPredefinito(), sessione.getConferenza()};
                    tableModel.addRow(rowData);
                }
            } catch (Exception e) {
                // Gestione delle eccezioni
                e.printStackTrace();
            }

            return tableModel;
        }




        private JButton createButtonWithShadow(String text)
        {
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(250, 25));


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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TabellaInterventoOrg loginPage = new TabellaInterventoOrg();
            loginPage.setVisible(true);
        });
    }


}

