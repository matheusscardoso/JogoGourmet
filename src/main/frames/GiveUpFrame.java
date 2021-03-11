package main.frames;

import main.enuns.EQuestion;

import javax.swing.*;

public class GiveUpFrame {

    public static String Plate() {
        return JOptionPane.showInputDialog(null,
                EQuestion.QUAL_PRATO_VOCE_PENSOU.getDescription(),
                EQuestion.DESISTO.getDescription(), JOptionPane.QUESTION_MESSAGE);
    }


    public static String Category(String foodName, String lastItem) {
        return JOptionPane.showInputDialog(foodName.concat(EQuestion.RESPOSTA_CATEGORIA.getDescription())
                        .concat(lastItem)
                        .concat(EQuestion.NAO.getDescription()));


    }


}
