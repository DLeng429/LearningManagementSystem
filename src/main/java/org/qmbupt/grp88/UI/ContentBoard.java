package org.qmbupt.grp88.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * which set five main board basic information and configuration
 * @author JunLeng
 */
public class ContentBoard extends JPanel {
    public ScheduleBoard scheduleBoard = new ScheduleBoard();;
    public GradeBoard gradeBoard = new GradeBoard();
    public CalculatorBoard calculatorBoard = new CalculatorBoard();
    public PathBoard pathBoard = new PathBoard();
    public AchievementBoard achievementBoard = new AchievementBoard();

    public ContentBoard(CardLayout cards){
        this.setLayout(cards);
        this.setBackground(null);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(scheduleBoard,"scheduleBoard");
        scheduleBoard.setBackground(null);
        scheduleBoard.setOpaque(false);
        this.add(gradeBoard,"gradeBoard",1);
        gradeBoard.setBackground(null);
        gradeBoard.setOpaque(false);
        this.add(pathBoard,"pathBoard");
        pathBoard.setBackground(null);
        pathBoard.setOpaque(false);
        this.add(calculatorBoard,"calculatorBoard");
        calculatorBoard.setBackground(null);
        calculatorBoard.setOpaque(false);
        this.add(achievementBoard,"achievementBoard");
        achievementBoard.setBackground(null);
        achievementBoard.setOpaque(false);

    }
}
