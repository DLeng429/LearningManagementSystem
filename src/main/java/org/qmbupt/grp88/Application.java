package org.qmbupt.grp88;

import org.qmbupt.grp88.Controller.Login;
import java.awt.Color;

import javax.swing.*;

/**
 * Main function of this application which set the gui style with UIMANGER and start with the LoginFrame Class
 * @version 1.3.0
 * @author JunLeng, FeiyuYang, TianboYing
 */
public class Application {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", new Color(255, 255, 255));
            UIManager.put("nimbusLightBackground", new Color(255, 255, 255));
            UIManager.put("control", new Color(240, 240, 240));
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
        new Login();
    }
}
