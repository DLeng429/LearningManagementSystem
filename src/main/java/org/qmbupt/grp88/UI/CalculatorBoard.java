package org.qmbupt.grp88.UI;

import org.qmbupt.grp88.Controller.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Show the GPA and degree board
 * You can use this board to calculate the gpa with your marks and also your degree
 * @author FeiyuYang
 */
public class CalculatorBoard extends JPanel {

    public CalculatorBoard(){
        this.setBackground(null);
        this.setLayout(new BorderLayout());
        this.setBackground(null);
        this.setOpaque(false);

        JPanel GPA_bar = new JPanel();
        GPA_bar.setLayout(new FlowLayout());
        GPA_bar.setOpaque(false);
        JTextField GPA_field = new JTextField();
        GPA_field.setFont(new Font("Consolas", Font.PLAIN, 14));
        GPA_field.setPreferredSize(new Dimension(600, 50));
        JButton GPA_button = new JButton("calculate GPA");

        JPanel degree_bar = new JPanel();
        degree_bar.setOpaque(false);
        degree_bar.setLayout(new FlowLayout());
        JTextField degree_field = new JTextField();
        degree_field.setFont(new Font("Consolas", Font.PLAIN, 14));
        degree_field.setPreferredSize(new Dimension(600, 50));
        JButton degree_button = new JButton("calculate degree");

        JPanel rule_bar = new JPanel();
        rule_bar.setOpaque(false);
        JLabel jLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src/main/resources/calculation_rules.jpeg");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(600,450, Image.SCALE_SMOOTH));
        jLabel.setIcon(imageIcon);

        rule_bar.add(jLabel);
        GPA_bar.add(GPA_field);
        GPA_bar.add(GPA_button);
        degree_bar.add(degree_field);
        degree_bar.add(degree_button);
        this.add(GPA_bar, BorderLayout.NORTH);
        this.add(degree_bar, BorderLayout.CENTER);
        this.add(rule_bar, BorderLayout.SOUTH);

        GPA_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileReader fileReader = new FileReader("src/main/resources/mark.txt")) {
                    ArrayList<Integer> marks = new ArrayList<>();
                    ArrayList<Integer> credits = new ArrayList<>();

                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while((line = bufferedReader.readLine()) != null) {
                        String[] parts = line.split(" ");
                        marks.add(Integer.parseInt(parts[4]));
                        credits.add(Integer.parseInt(parts[3]));
                    }

                    GPA_field.setBackground(Color.CYAN);
                    GPA_field.setText(" Your synthesis GPA is:  " + String.format("%.2f",
                            Calculator.calculateGPA(credits, marks)) + "/4.0");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        degree_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileReader fileReader = new FileReader("src/main/resources/mark.txt")) {
                    ArrayList<Integer> semesters = new ArrayList<>();
                    ArrayList<Integer> marks = new ArrayList<>();

                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while((line = bufferedReader.readLine()) != null) {
                        String[] parts = line.split(" ");
                        marks.add(Integer.valueOf(parts[4]));
                        if (parts[0].equals("2020-2021-1")) { semesters.add(1); }
                        else if (parts[0].equals("2020-2021-2")) { semesters.add(2); }
                        else if (parts[0].equals("2021-2022-1")) { semesters.add(3); }
                        else if (parts[0].equals("2021-2022-2")) { semesters.add(4); }
                        else if (parts[0].equals("2022-2023-1")) { semesters.add(5); }
                        else if (parts[0].equals("2022-2023-2")) { semesters.add(6); }
                        else if (parts[0].equals("2023-2024-1")) { semesters.add(7); }
                        else if (parts[0].equals("2023-2024-2")) { semesters.add(8); }
                    }

                    degree_field.setBackground(Color.CYAN);
                    degree_field.setText(" Your QMUL academic degree of honor currently is:  "
                            + Calculator.calculateDegree(semesters, marks));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
