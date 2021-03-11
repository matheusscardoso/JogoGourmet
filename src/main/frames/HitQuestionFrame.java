package main.frames;

import main.enuns.EQuestion;

import javax.swing.*;

public class HitQuestionFrame {

    public static void create() {
        JOptionPane.showMessageDialog(null,
                EQuestion.ACERTEI.getDescription(),
                EQuestion.APP_TITLE.getDescription(),
                JOptionPane.INFORMATION_MESSAGE);
    }

}
