/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author bcast
 */
public class Ventana extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel txt;
    private JButton btnUrl;
    private JButton btnLocal;

    public Ventana() {
        this.panel = new JPanel();
        this.txt = new JLabel();
        this.btnUrl = new JButton();
        this.btnLocal = new JButton();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(700, 300);
        this.cargarInterfaz();
        this.btnUrl.setActionCommand("url");
        this.btnLocal.setActionCommand("local");
        this.btnUrl.addActionListener(this);
        this.btnLocal.addActionListener(this);
    }

    public void cargarInterfaz() {
        txt.setText("Presionar un boton para mostrar una imagen");

        btnUrl.setText("IMG URL");

        btnLocal.setText("IMG LOCAL");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(btnUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addComponent(txt)
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUrl)
                                        .addComponent(btnLocal))
                                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        JFrame frame = new JFrame();
            JPanel panel1 = new JPanel();
            Image img = null;
        if (comando == "url") {
            try {
                URL url = new URL("http://images6.fanpop.com/image/photos/34300000/homer-simpson-homer-simpson-34387502-168-200.png");
                img = ImageIO.read(url);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame.setBounds(700, 400, 200, 268);
            panel1.setSize(frame.getWidth(), frame.getHeight());
            JLabel icon = new JLabel(new ImageIcon(img));
            panel1.add(icon);
            frame.add(panel1);
            frame.setVisible(true);
        } else if (comando == "local") {
            frame.setBounds(800, 400, 200, 268);
            panel1.setSize(frame.getWidth(), frame.getHeight());
            JLabel icon = new JLabel(new ImageIcon("hank.png"));
            panel1.add(icon);
            frame.add(panel1);
            frame.setVisible(true);
        }
    }

}
