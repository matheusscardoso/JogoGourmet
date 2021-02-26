package main.db;

import main.food.Category;
import main.food.Food;
import main.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private final List<Category> foodCategoriesList;
    private final List<Food> foodList;

    public DB() {
        this.foodCategoriesList = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    public List<Category> getFoodCategoriesList() {
        return foodCategoriesList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    private void addCategory(String categoryName) {
        this.foodCategoriesList.add(Category.of(categoryName));
    }


    public void addFood(Food food) {
        if (!Utils.StringIsBlank(food.getCategoryName())) {
            addCategory(food.getCategoryName());
        }

        if (!Utils.StringIsBlank(food.getName())) {
            this.foodList.add(food);
        }
    }

}
