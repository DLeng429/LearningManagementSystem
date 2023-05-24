package org.qmbupt.grp88.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginWhiteBoxTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<Integer> passwords = new ArrayList<>();
        usernames.add("Dog");
        passwords.add(101);
        usernames.add("Cat");
        passwords.add(888);
        usernames.add("Dick");
        passwords.add(111);

        while (true) {
            System.out.println("Type in your name:\t");
            String name = scanner.next();
            boolean judge = false;

            for (int i = 0; i < usernames.size(); i++) {
                if (name.equals(usernames.get(i))) {
                    judge = true;
                    while (true) {
                        System.out.println("Type in your password:\t");
                        int password = scanner.nextInt();
                        if (password == passwords.get(i)) {
                            System.out.println("Welcome, " + name);
                            System.exit(0);
                        }
                        else { System.out.println("Wrong, try again"); }
                    }
                }
            }

            if (!judge) {
                System.out.println("Wrong, register first, your name:\t"+name);
                System.out.println("Type in password you like:\t");
                int password = scanner.nextInt();
                usernames.add(name);
                passwords.add(password);
                System.out.println("name\t"+name+", password:\t"+password);
            }
        }
    }
}
