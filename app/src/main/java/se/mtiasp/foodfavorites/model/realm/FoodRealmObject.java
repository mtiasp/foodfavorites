package se.mtiasp.foodfavorites.model.realm;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class FoodRealmObject extends RealmObject  {

    @PrimaryKey
    private Integer id;

    @Index
    private String title;

    private String caloriesDescription;

    private boolean isSelected = false;

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
