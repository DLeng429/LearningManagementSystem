package org.qmbupt.grp88.UI;

import org.qmbupt.grp88.Entity.UIStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * The board is used to choose with board would you want to show
 * It uses a cards layout and can switch within five board: achievement board, calculate board, schedule board, marks board and PathDiagram
 * @author JunLeng
 */
public class ChooseBoard extends JPanel {
    public ChooseBoard(CardLayout cards,ContentBoard contentBoard){
        // set sidebar which have 5 buttons to choose the functionality
        this.setLayout(new GridLayout(5,1,0,0));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setBackground(null);
        this.setOpaque(false);
        //this.setBackground(Color.white);
        JButton schedule_button = setButton("Schedule",UIStyle.ScheduleIcon);
        JButton mark_button = setButton("Marks",UIStyle.GardeIcon);
        JButton calculator_button = setButton("Calculator",UIStyle.CalculatorIcon);
        JButton diagram_button = setButton("Path Diagram",UIStyle.PathIcon);
        JButton achievement_button = setButton("Achievement",UIStyle.AchievementIcon);
        // add buttons into sidebar panel
        this.add(schedule_button);
        this.add(mark_button);
        this.add(calculator_button);
        this.add(diagram_button);
        this.add(achievement_button);
        // add the listener
        schedule_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(contentBoard,"scheduleBoard");
            }
        });
        mark_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(contentBoard,"gradeBoard");
                GradeBoard gb = (GradeBoard) contentBoard.getComponent(1);
                gb.updateCourseList();
            }
        });
        calculator_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(contentBoard,"calculatorBoard");
            }
        });
        diagram_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(contentBoard,"pathBoard");
            }
        });
        achievement_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(contentBoard,"achievementBoard");
            }
        });
    }
    public JButton setButton(String name,URL resource){
        JButton jb = new JButton(name);
        jb.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jb.setFont(UIStyle.sidebar_font);
        jb.setForeground(Color.WHITE);
        //jb.setBackground(Color.white);
        ImageIcon icon = new ImageIcon(resource);
        jb.setIcon(icon);
        jb.setOpaque(false);
        jb.setBorderPainted(false);
        jb.setContentAreaFilled(false);
        return jb;
    }
}
