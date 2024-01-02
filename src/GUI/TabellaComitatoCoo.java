package GUI;

import DTO.ComitatoDTO;
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


public class TabellaComitatoCoo extends JFrame
{
        private JTable table;

        public TabellaComitatoCoo()
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
            setTitle("Comitati Aderenti");
            setSize(1000, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Aggiunta dei pannelli e altri componenti al pannello principale
            mainPanel.add(new JLabel("Comitati Presenti alle Sessioni!!", SwingConstants.CENTER), BorderLayout.NORTH);
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
            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER))
            {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.gray);  // Colore di sfondo
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            JButton feedbutton = createButtonWithShadow("Guarda gli interventi");
            feedbutton .addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    dispose();
                    new TabellaInterventoCoo();
                }
            });

            bottomPanel.add(feedbutton);

            JButton intervbutton = createButtonWithShadow("Torna alla Homepage");
            intervbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Logica per tornare alla Home, ad esempio chiudere questa finestra e aprire la Home
                    dispose();
                    new HomePageCoo();
                }
            });

            bottomPanel.add(intervbutton);

            return bottomPanel;
        }

        private DefaultTableModel createTableModelFromDB() {
            DefaultTableModel tableModel = new DefaultTableModel();

            try {
                // Ottieni i dati dalla tua connessione e controller
                DBConnection dbConnection = DBConnection.getConnessione();
                Controller co = new Controller(dbConnection);

                // Sostituisci con il metodo effettivo per ottenere i dati dalla tabella Sessione
                List<ComitatoDTO> comlist = co.getListacomitato();

                // Colonne della tabella
                String[] columnNames = {"Codice Comitato", "Nome Comitato"};

                // Aggiungi le colonne al modello della tabella
                tableModel.setColumnIdentifiers(columnNames);

                // Aggiungi i dati al modello della tabella
                for (ComitatoDTO comitato : comlist) {
                    // Sostituisci con i metodi effettivi per ottenere i dati specifici dalla SessioneDTO
                    Object[] rowData = {comitato.getCodComitato(), comitato.getNomeC()};
                    tableModel.addRow(rowData);
                }
            } catch (Exception e) {
                // Gestione delle eccezioni, sostituisci con la tua logica di gestione degli errori
                e.printStackTrace();
            }

            return tableModel;
        }




        private JButton createButtonWithShadow(String text)
        {
            JButton button = new JButton(text);
            button.setPreferredSize(new Dimension(250, 25));

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
