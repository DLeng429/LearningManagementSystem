package org.qmbupt.grp88.UI;

import org.qmbupt.grp88.Entity.UIStyle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * A table to show students grades
 * @author JunLeng
 */
public class GradeBoard extends JPanel {
    public DefaultTableModel model;
    public GradeBoard(){
        this.setBackground(null);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        JButton search_button = new JButton("search");
        String col_name[] = {"Semester","Course Number","Course Name","Course Credit","Grade"};
        model = new DefaultTableModel(col_name,0);
        JTable table = new JTable(model);
        JTableHeader head = table.getTableHeader();
        head.setPreferredSize(new Dimension(head.getWidth(), 35));
        head.setFont(new Font("楷体", Font.PLAIN, 18));
        table.setRowHeight(25);
        table.setFont(UIStyle.table_font);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setEnabled(false);
        this.add(scrollPane,BorderLayout.CENTER);
        // create bottom panel
        JPanel bottom_panel = new JPanel();
        JButton add_button = new JButton("ADD");
        JButton delete_button = new JButton("DELETE");
        bottom_panel.add(add_button);
        bottom_panel.add(delete_button);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new AddMarkDialog(model);}
        });
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = model.getRowCount();
                if (rowCount > 0) {
                    model.removeRow(rowCount - 1);
                    try {
                        RandomAccessFile file = new RandomAccessFile("src/main/resources/mark.txt", "rw");
                        long length = file.length();
                        if (length > 0) {
                            byte b;
                            do {
                                length -= 1;
                                file.seek(length);
                                b = file.readByte();
                            } while (length > 0 && b != 10);
                            if (length > 0) {
                                file.setLength(length);
                            } else {
                                file.setLength(0);
                            }
                        }
                        file.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        bottom_panel.setOpaque(false);
        this.add(bottom_panel,BorderLayout.SOUTH);
        JPanel rightPanel = new JPanel();
        Color borderColor =new Color(0, 0, 0, 0) ;
        int borderWidth = 15;
        rightPanel.setBorder(BorderFactory.createLineBorder(borderColor, borderWidth));
        rightPanel.setOpaque(false);
        this.add(rightPanel,BorderLayout.EAST);
    }

    /**
     * update the table into GUI from txt file with io function
     */
    public void updateCourseList() {
        model.setRowCount(0);
        try (FileReader reader = new FileReader("src/main/resources/mark.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                model.addRow(parts);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
