package org.qmbupt.grp88.Entity;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class CourseListTest extends TestCase {
    CourseList courseList = new CourseList();

    @Test
    public void testCreateCourseList() {
        Course course = new Course("RFID","EBU0001",4);
        assertEquals(courseList.get(0).getCourse_name(), course.getCourse_name());
        assertEquals(courseList.get(1).getNumber(), "EBU0002");
        assertEquals(courseList.get(2).getCredit(), 4.0);
    }

    @Test
    public void testTranverse() {
        System.out.println(courseList.getClass()+"\t"+ courseList);
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.get(i).getCourse_name()+"\t"+
                    courseList.get(i).getNumber()+"\t"+
                    courseList.get(i).getCredit());
        }
    }
}