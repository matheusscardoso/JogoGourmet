package main.food;

public class Category extends Entity {
    private Category(String categoryName) {
        this.name = categoryName;
    }

    public static Category of(String categoryName) {
        return new Category(categoryName);
    }

}
