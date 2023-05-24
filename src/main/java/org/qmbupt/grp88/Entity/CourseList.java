package org.qmbupt.grp88.Entity;

import java.util.ArrayList;

/**
 * The list of entity course
 * @author JunLeng
 */
public class CourseList extends ArrayList<Course>{
    public CourseList(){
        Course course = new Course("RFID","EBU0001",4);
        Course course2 = new Course("Microprocessor","EBU0002",3);
        Course course3 = new Course("Software Engineer","EBU0003",4);
        Course course4 = new Course("Wireless Sensor","EBU0004",2);
        Course course5 = new Course("Mobile Internet","EBU0005",2);
        Course course6 = new Course("Information processing technology","EBU0006",2);
        Course course7 = new Course("PE","EBU0007",2);
        this.add(course);
        this.add(course2);
        this.add(course3);
        this.add(course4);
        this.add(course5);
        this.add(course6);
        this.add(course7);
    }
}
