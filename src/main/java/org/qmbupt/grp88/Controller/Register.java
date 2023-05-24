package org.qmbupt.grp88.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.qmbupt.grp88.Entity.UIStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Register extends JFrame implements ActionListener {

    private final JTextField userText;
    private final JPasswordField passwordText;
    private final JButton registerButton;

    private JLabel nameLabel, emailLabel, passwordLabel, confirmLabel;
    private JTextField  emailField;
    private JPasswordField passwordField, confirmField;
    private JButton  clearButton;


    /**
     * LoginFrame has two functions, check the username and password, register and jump into RegisterFrame
     */
    public Register() {
        super("Register");

        JPanel panel = new JPanel();
        panel.setLayout(null);


        JLabel jLabel=new JLabel();
        jLabel.setBounds(0,0,500,544);
        URL resource = UIStyle.regback;
        assert resource != null;
        jLabel.setIcon(new ImageIcon(resource));




        JPanel back_panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));

                g2d.setColor(Color.white);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                g2d.dispose();
            }
        };

        back_panel.setLayout(null);
        back_panel.setBounds(90,60,300,300);

        back_panel.setOpaque(false);
        panel.add(back_panel);


        JLabel userICon=new JLabel();
        userICon.setBounds(10,20,24,24);
        URL user = UIStyle.usericon;
        assert user != null;
        userICon.setIcon(new ImageIcon(user));
        back_panel.add(userICon);



        JLabel passwordIcon=new JLabel();
        passwordIcon.setBounds(10,80,24,24);
        URL passwordRes = UIStyle.passwordicon;
        assert passwordRes != null;
        passwordIcon.setIcon(new ImageIcon(passwordRes));
        back_panel.add(passwordIcon);


        JLabel confirmIcon=new JLabel();
        confirmIcon.setBounds(10,140,24,24);
        URL confirmRes = UIStyle.passwordicon;
        assert confirmRes != null;
        confirmIcon.setIcon(new ImageIcon(confirmRes));
        back_panel.add(confirmIcon);

        JLabel emailIcon=new JLabel();
        emailIcon.setBounds(10,200,24,24);
        URL emailIconRes = UIStyle.emailicon;
        assert emailIconRes != null;
        emailIcon.setIcon(new ImageIcon(emailIconRes));
        back_panel.add(emailIcon);


        JLabel userLabel = new JLabel("username:");
        userLabel.setBounds(50, 20, 80, 25);
        back_panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(130, 20, 165, 25);
        userText.setOpaque(false); // 设置为透明
        userText.setBackground(new Color(0, 0, 0, 0)); // 设置背景色透明度
        back_panel.add(userText);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(50, 80, 80, 25);
        back_panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(130, 80, 165, 25);
        passwordText.setOpaque(false); // 设置为透明
        passwordText.setBackground(new Color(0, 0, 0, 0)); // 设置背景色透明度
        back_panel.add(passwordText);

        JLabel confirm = new JLabel("confirm pwd:");
        confirm.setBounds(50, 140, 80, 25);
        back_panel.add(confirm);

        confirmField = new JPasswordField(20);
        confirmField.setBounds(130, 140, 165, 25);
        confirmField.setOpaque(false); // 设置为透明
        confirmField.setBackground(new Color(0, 0, 0, 0)); // 设置背景色透明度
        back_panel.add(confirmField);

        JLabel email = new JLabel("email:");
        email.setBounds(50, 200, 80, 25);
        back_panel.add(email);

        emailField = new JTextField(20);
        emailField.setBounds(130, 200, 165, 25);
        emailField.setOpaque(false); // 设置为透明
        emailField.setBackground(new Color(0, 0, 0, 0)); // 设置背景色透明度
        back_panel.add(emailField);


        clearButton = new JButton("Clear");
        clearButton.setBounds(100, 440, 90, 25);
        clearButton.addActionListener(this);
        panel.add(clearButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(300, 440, 90, 25);
        registerButton.addActionListener(this);
        panel.add(registerButton);

        panel.add(jLabel);
        add(panel);
        setSize(500, 544);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       getContentPane().setBackground(new Color(0, 0, 0, 0));

        setVisible(true);
    }

    /**
     * Click the button 'Login' to log in an account or 'Register' to create a new account
     * */
    @Override
    // handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = userText.getText();
            String email = emailField.getText();
            String password = new String(passwordText.getPassword());
            String confirm = new String(confirmField.getPassword());

            if (!password.equals(confirm)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
                return;
            }
            //

            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.json"));
                StringBuilder jsonString = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonString.append(line);
                }
                reader.close();

                JSONArray jsonArray = JSON.parseArray(jsonString.toString());

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("username", name);
                jsonObject.put("password", password);
                jsonObject.put("email", email);
                jsonArray.add(jsonObject);

                FileWriter writer = new FileWriter("data.json");
                JSON.writeJSONStringTo(jsonArray, writer);
                writer.flush();
                writer.close();
                JOptionPane.showMessageDialog(this, "Registration successful!");


                dispose();
                new Login();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        //JOptionPane.showMessageDialog(this, "Registration successful!");
        else if (e.getSource() == clearButton) {
            userText.setText("");
            emailField.setText("");
            passwordText.setText("");
            confirmField.setText("");
        }
    }

}