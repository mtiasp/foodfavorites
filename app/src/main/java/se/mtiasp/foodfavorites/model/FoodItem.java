package se.mtiasp.foodfavorites.model;

import se.mtiasp.foodfavorites.model.realm.FoodRealmObject;

public class FoodItem {

    private Integer id;
    private String title;
    private String caloriesDescription;
    private boolean isSelected;

    public FoodItem(FoodRealmObject foodRealmObject) {
        this(foodRealmObject.getId(),
                foodRealmObject.getTitle(),
                foodRealmObject.getCaloriesDescription(),
                foodRealmObject.isSelected());
     }

    public FoodItem(Integer id, String title, String caloriesDescription, boolean isSelected) {
        this.id = id;
        this.title = title;
        this.caloriesDescription = caloriesDescription;
        this.isSelected = isSelected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaloriesDescription() {
        return caloriesDescription;
    }

    public void setCaloriesDescription(String caloriesDescription) {
        this.caloriesDescription = caloriesDescription;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
