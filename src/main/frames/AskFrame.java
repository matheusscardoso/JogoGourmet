package main.frames;

import main.enuns.EQuestion;

import javax.swing.*;

public class AskFrame {

    public static Integer create(String foodName) {
        return JOptionPane
                .showConfirmDialog(null,
                        EQuestion.O_PRATO_QUE_PENSOU_E.getDescription().concat(foodName).concat("?"), null, JOptionPane.YES_NO_OPTION);

    }

}
