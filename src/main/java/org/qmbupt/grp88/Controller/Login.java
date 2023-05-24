package org.qmbupt.grp88.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.qmbupt.grp88.Entity.UIStyle;
import org.qmbupt.grp88.UI.MainBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Login extends JFrame implements ActionListener {

    private final JTextField userText;
    private final JPasswordField passwordText;
    private final JButton loginButton;
    private final JButton registerButton;

    /**
     * LoginFrame has two functions, check the username and password, register and jump into RegisterFrame
     */
    public Login() {
        super("LOGIN");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel jLabel=new JLabel();
        jLabel.setBounds(0,0,500,344);
        jLabel.setIcon(new ImageIcon(UIStyle.loginicon));

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
        back_panel.setBounds(90,60,300,140);
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

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 240, 90, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(300, 240, 90, 25);
        registerButton.addActionListener(this);
        panel.add(registerButton);

        panel.add(jLabel);
        add(panel);
        setSize(500, 344);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置内容面板（Content Pane）透明
       getContentPane().setBackground(new Color(0, 0, 0, 0));

        setVisible(true);
    }

    /**
     * Click the button 'Login' to log in an account or 'Register' to create a new account
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());

            StringBuilder jsonString = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader("data.json"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonString.append(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JSONArray jsonArray = JSON.parseArray(jsonString.toString());
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String savedUsername = jsonObject.getString("username");
                String savedPassword = jsonObject.getString("password");
                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    JOptionPane.showMessageDialog(this, "Login successfully!");
                    // close the login board
                    dispose();
                    // turn to the main board
                    MainBoard sb = new MainBoard();
                    sb.build();

                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Login failed!","False", JOptionPane.ERROR_MESSAGE);
        }
        else if (e.getSource() == registerButton) {
              JOptionPane.showMessageDialog(null, "welcome register！");
              new Register();
              dispose();
    }}
    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
}