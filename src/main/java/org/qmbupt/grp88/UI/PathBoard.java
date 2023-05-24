package org.qmbupt.grp88.UI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * show the learning path diagram
 * @author FeiyuYang
 */
public class PathBoard extends JPanel {
    public PathBoard(){
        this.setOpaque(false);
        //JLabel course_map=new JLabel(new ImageIcon("src/main/resources/course_map.png"));
        //this.add(course_map);
        //course_map.setBounds(0, 150, 700, 500);

        this.setLayout(new  GridLayout(8, 1));

        // each JPanel carry modules of a same semester
        ArrayList<JPanel> jPanels = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel semester = new JLabel("Semester " + (i+1) + "    ");
            semester.setBackground(Color.ORANGE);
            semester.setFont(new Font("Arvo", Font.PLAIN, 16));
            jPanel.add(semester);
            jPanels.add(jPanel);
        }

        try (FileReader reader = new FileReader("src/main/resources/mark.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                JButton jButton = new JButton(parts[2]);
                int index = 0;
                switch (parts[0]) {
                    case "2020-2021-1": {
                        index = 0;
                        break;
                    }
                    case "2020-2021-2": {
                        index = 1;
                        break;
                    }
                    case "2021-2022-1": {
                        index = 2;
                        break;
                    }
                    case "2021-2022-2": {
                        index = 3;
                        break;
                    }
                    case "2022-2023-1": {
                        index = 4;
                        break;
                    }
                    case "2022-2023-2": {
                        index = 5;
                        break;
                    }
                    case "2023-2024-1": {
                        index = 6;
                        break;
                    }
                    case "2023-2024-2": {
                        index = 7;
                    }
                }

                jPanels.get(index).add(jButton);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // add all JPanel to PathBoard
        for (int i = 0; i < jPanels.size(); i++) {
            this.add(jPanels.get(i));
        }
        this.setVisible(true);
    }
}
