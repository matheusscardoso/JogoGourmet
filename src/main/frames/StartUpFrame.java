package main.frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpFrame {

    public boolean okClicked = false;

    public JButton createButtonOK() {
        JButton btn = new JButton();
        btn.setText("OK");
        btn.setPreferredSize(new Dimension(52, 26));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOkClicked(true);
                JOptionPane.showMessageDialog(null, "Clicado");

            }
        });
        return btn;
    }

    private JFrame addComponents(String appTitle, JPanel contentPane) {
        JFrame frame = new JFrame(appTitle);
        frame.setSize(285, 130);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(contentPane);

        return frame;
    }

    public JFrame create(String appTitle) {
        JButton btn = createButtonOK();

        JLabel label = new JLabel("Pense em um prato que gosta");
        label.setVerticalAlignment(SwingConstants.CENTER);

        JPanel contentPane = new JPanel();
        contentPane.setSize(100, 100);
        contentPane.setVisible(true);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(btn);
        contentPane.add(label);
        contentPane.setLayout(null);

        Insets insets = contentPane.getInsets();
        Dimension size = label.getPreferredSize();

        label.setBounds(insets.left + 45, insets.top + 15, size.width, size.height);
        size = btn.getPreferredSize();
        btn.setBounds(100 + insets.left, 40 + insets.top, size.width, size.height);

        return new StartUpFrame().addComponents(appTitle, contentPane);

    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setOkClicked(boolean okClicked) {
        this.okClicked = okClicked;
    }

}
