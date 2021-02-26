package main.db;

import main.food.Category;
import main.food.Food;

public class Seed {

    public static DB startData() {
        DB db = new DB();
        db.addFood(Food.of("macarrão", Category.of("massa")));
        db.addFood(Food.of("bolo de chocolate", Category.of("doce")));

        return db;
    }

}
