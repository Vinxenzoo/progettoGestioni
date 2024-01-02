package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatusPanel  extends JFrame
{

        public StatusPanel(String message, boolean success) {
            setTitle("Status");
            setSize(400, 150);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout());
            JLabel label = new JLabel(message, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            label.setForeground(Color.WHITE); // Testo bianco
            panel.add(label, BorderLayout.CENTER);

            JButton closeButton = createButtonWithShadow("Chiudi");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            panel.add(closeButton, BorderLayout.SOUTH);

            if (success) {
                panel.setBackground(new Color(34, 139, 34)); // Verde scuro per successo
            } else {
                panel.setBackground(new Color(178, 34, 34)); // Rosso scuro per errore
            }

            // Effetto di ombra intorno al pannello
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Aggiungi il pannello al frame
            setContentPane(new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    // Aggiungi uno sfondo sfumato
                    GradientPaint gradientPaint = new GradientPaint(0, 0, panel.getBackground(), getWidth(), getHeight(), Color.WHITE);
                    g2d.setPaint(gradientPaint);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            });

            setLayout(new GridBagLayout());
            add(panel);

            setVisible(true);
        }

    private JButton createButtonWithShadow(String text)
    {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 25));

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






