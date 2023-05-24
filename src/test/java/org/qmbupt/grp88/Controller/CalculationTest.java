package org.qmbupt.grp88.Controller;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class CalculationTest extends TestCase {
    Calculator calculation = new Calculator();

    /**
     * A manual test sample
     */
    @Test
    public void testCalculate() {
        ArrayList<Integer> credits = new ArrayList<>();
        credits.add(4);
        credits.add(3);
        credits.add(5);
        credits.add(2);
        credits.add(3);
        credits.add(2);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(75);
        scores.add(87);
        scores.add(90);
        scores.add(89);
        scores.add(88);
        ArrayList<Integer> semesters = new ArrayList<>();
        semesters.add(1);
        semesters.add(3);
        semesters.add(5);
        semesters.add(5);
        semesters.add(7);
        semesters.add(6);

        System.out.println("GPA:\t" + String.format("%.2f", calculation.calculateGPA(credits, scores)) + "/4.00");
        System.out.println("Degree of honor:\t" + calculation.calculateDegree(semesters, scores));
    }
}