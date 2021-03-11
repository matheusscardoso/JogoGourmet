package main.db;

import main.food.Category;
import main.food.Food;

public class Seed {

    public static DB startData() {
        DB db = new DB();
        db.addFood(Food.of("Lasanha", Category.of("massa")));
        //db.addFood(Food.of("Bolo de Chocolate", Category.of("doce")));
        db.addFood(Food.of("Bolo de Chocolate", Category.of(new String())));

        return db;
    }

}
