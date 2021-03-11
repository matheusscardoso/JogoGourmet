package main;

import main.db.DB;
import main.db.Seed;
import main.enuns.EQuestion;
import main.food.Category;
import main.food.Food;
import main.frames.AskFrame;
import main.frames.GiveUpFrame;
import main.frames.HitQuestionFrame;
import main.utils.Utils;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Startup {

    private static final String AppTitle = "Jogo Gourmet";

    public static void main(String[] args) {

        DB db = Seed.startData();

        boolean flagExit = false;
        String lastSearch = null;

        while (!flagExit) {

            int startGame = JOptionPane.showConfirmDialog(null,
                    EQuestion.PENSE_EM_UM_PRATO.getDescription(),
                    AppTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (startGame == -1) {
                System.exit(0);
                flagExit = true;
                break;
            }

            Set<Food> setFod = new LinkedHashSet<>(db.getFoodList());
            Set<Category> setCat = new LinkedHashSet<>(db.getFoodCategoriesList());

            Category selectedCategory = null;

            for (Category c : setCat) {
                int result = AskFrame.create(c.getName());
                if (result == 0) {
                    selectedCategory = c;
                    break;
                } else if (result < 0) {
                    flagExit = true;
                    break;
                }
                lastSearch = c.getName();
            }
            if (selectedCategory == null && setFod.size() == setCat.size() ) {
                Giveup(lastSearch, db, flagExit);
            }
            else {
                Set<Food> filterFood = new LinkedHashSet<>();

                if(selectedCategory != null ){
                    for (Food f : setFod) {
                        if (selectedCategory.getName().equals(f.getCategoryName())) {
                            filterFood.add(f);
                        }
                    }
                } else {

                    filterFood = setFod.stream()
                            .filter(food ->
                                    setCat.stream().noneMatch(i -> i.getName().equals(food.getCategoryName())))
                                        .collect(Collectors.toCollection(LinkedHashSet::new));

                }


                Food selectedFood = null;
                for (Food f : filterFood) {
                    int result = AskFrame.create(f.getName());
                    if (result == 0) {
                        selectedFood = f;
                        HitQuestionFrame.create();
                        break;
                    } else if (result < 0) {
                        flagExit = true;
                        break;
                    }
                    lastSearch = f.getName();
                }


                if (selectedFood == null) {
                    Giveup(lastSearch, db, flagExit);
                }
            }
        }
    }


    private static void Giveup(String lastSearch, DB db, boolean flagExit) {
        String foodSelected = GiveUpFrame.Plate();

        if (!Utils.StringIsBlank(foodSelected)) {
            String categorySelected =
                    GiveUpFrame.Category(foodSelected, lastSearch);
            if (!Utils.StringIsBlank(categorySelected)) {
                db.addFood(Food.of(foodSelected, Category.of(categorySelected)));
            }

        }
    }

}


