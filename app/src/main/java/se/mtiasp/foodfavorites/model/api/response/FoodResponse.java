package se.mtiasp.foodfavorites.model.api.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodResponse {

    @SerializedName("title_completed")
    @Expose
    private String titleCompleted;
    @SerializedName("serving_categories")
    @Expose
    private List<ServingCategory> servingCategories = null;
    @SerializedName("food")
    @Expose
    private List<Food> food = null;
    @SerializedName("serving_sizes")
    @Expose
    private List<ServingSize> servingSizes = null;
    @SerializedName("language_requested")
    @Expose
    private String languageRequested;
    @SerializedName("title_requested")
    @Expose
    private String titleRequested;

    public String getTitleCompleted() {
        return titleCompleted;
    }

    public void setTitleCompleted(String titleCompleted) {
        this.titleCompleted = titleCompleted;
    }

    public List<ServingCategory> getServingCategories() {
        return servingCategories;
    }

    public void setServingCategories(List<ServingCategory> servingCategories) {
        this.servingCategories = servingCategories;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public List<ServingSize> getServingSizes() {
        return servingSizes;
    }

    public void setServingSizes(List<ServingSize> servingSizes) {
        this.servingSizes = servingSizes;
    }

    public String getLanguageRequested() {
        return languageRequested;
    }

    public void setLanguageRequested(String languageRequested) {
        this.languageRequested = languageRequested;
    }

    public String getTitleRequested() {
        return titleRequested;
    }

    public void setTitleRequested(String titleRequested) {
        this.titleRequested = titleRequested;
    }

}