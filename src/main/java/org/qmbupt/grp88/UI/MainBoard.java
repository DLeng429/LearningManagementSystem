package org.qmbupt.grp88.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * The main board of the application
 * set some information of the frame and panel
 * @author JunLeng
 */
public class MainBoard extends JFrame {
    public CardLayout cards = new CardLayout();
    public ContentBoard contentBoard = new ContentBoard(cards);
    public ChooseBoard sidebar = new ChooseBoard(cards,contentBoard);
    public void build(){
        // set background
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        this.setContentPane(backgroundPanel);
        // add components to frame
        JPanel jPanel = new JPanel();
        sidebar.setBackground(null);
        sidebar.setOpaque(false);
        contentBoard.setBackground(null);
        contentBoard.setOpaque(false);
        jPanel.setLayout(new BorderLayout());
        jPanel.setBounds(0,0,1100,600);
        // set sidebar
        //jPanel.add(sidebar, BorderLayout.WEST);
        jPanel.add(sidebar, BorderLayout.WEST);
        // set content
        jPanel.add(contentBoard,BorderLayout.CENTER);

        jPanel.setOpaque(false);
        this.add(jPanel);
        this.setLayout(null);
        this.setSize(1100,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            try {
                URL resource = this.getClass().getResource("/demo.jpg");
                backgroundImage = ImageIO.read(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
