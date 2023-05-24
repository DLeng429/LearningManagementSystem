package org.qmbupt.grp88.UI;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

public class MainBoardTest extends TestCase {
    MainBoard mainBoard = new MainBoard();
    public CardLayout cardLayout = new CardLayout();

    @Test
    public void testMainBoardCreate() {
        mainBoard.build();
    }
}