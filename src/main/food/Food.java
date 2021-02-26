package main.food;

public class Food extends Entity {
    private final Category category;

    private Food(String foodName, Category category) {
        this.name = foodName;
        this.category = category;
    }

    public static Food of(String foodName, Category category) {
        return new Food(foodName, category);
    }

    public String getCategoryName() {
        return category.getName();
    }
}
