package se.mtiasp.foodfavorites.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("measurementid")
    @Expose
    private Integer measurementid;
    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("sugar")
    @Expose
    private Double sugar;
    @SerializedName("sodium")
    @Expose
    private Double sodium;
    @SerializedName("pcstext")
    @Expose
    private String pcstext;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("typeofmeasurement")
    @Expose
    private Integer typeofmeasurement;
    @SerializedName("defaultserving")
    @Expose
    private Integer defaultserving;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("pcsingram")
    @Expose
    private Double pcsingram;
    @SerializedName("unsaturatedfat")
    @Expose
    private Double unsaturatedfat;
    @SerializedName("showmeasurement")
    @Expose
    private Integer showmeasurement;
    @SerializedName("protein")
    @Expose
    private Double protein;
    @SerializedName("servingcategory")
    @Expose
    private Integer servingcategory;
    @SerializedName("fiber")
    @Expose
    private Double fiber;
    @SerializedName("fat")
    @Expose
    private Double fat;
    @SerializedName("potassium")
    @Expose
    private Double potassium;
    @SerializedName("mlingram")
    @Expose
    private Double mlingram;
    @SerializedName("headcategoryid")
    @Expose
    private Integer headcategoryid;
    @SerializedName("cholesterol")
    @Expose
    private Double cholesterol;
    @SerializedName("source")
    @Expose
    private Object source;
    @SerializedName("saturatedfat")
    @Expose
    private Double saturatedfat;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("showonlysametype")
    @Expose
    private Integer showonlysametype;
    @SerializedName("gramsperserving")
    @Expose
    private Double gramsperserving;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("carbohydrates")
    @Expose
    private Double carbohydrates;
    @SerializedName("categoryid")
    @Expose
    private Integer categoryid;

    public Integer getMeasurementid() {
        return measurementid;
    }

    public void setMeasurementid(Integer measurementid) {
        this.measurementid = measurementid;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

    public Double getSodium() {
        return sodium;
    }

    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    public String getPcstext() {
        return pcstext;
    }

    public void setPcstext(String pcstext) {
        this.pcstext = pcstext;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getTypeofmeasurement() {
        return typeofmeasurement;
    }

    public void setTypeofmeasurement(Integer typeofmeasurement) {
        this.typeofmeasurement = typeofmeasurement;
    }

    public Integer getDefaultserving() {
        return defaultserving;
    }

    public void setDefaultserving(Integer defaultserving) {
        this.defaultserving = defaultserving;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPcsingram() {
        return pcsingram;
    }

    public void setPcsingram(Double pcsingram) {
        this.pcsingram = pcsingram;
    }

    public Double getUnsaturatedfat() {
        return unsaturatedfat;
    }

    public void setUnsaturatedfat(Double unsaturatedfat) {
        this.unsaturatedfat = unsaturatedfat;
    }

    public Integer getShowmeasurement() {
        return showmeasurement;
    }

    public void setShowmeasurement(Integer showmeasurement) {
        this.showmeasurement = showmeasurement;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Integer getServingcategory() {
        return servingcategory;
    }

    public void setServingcategory(Integer servingcategory) {
        this.servingcategory = servingcategory;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getPotassium() {
        return potassium;
    }

    public void setPotassium(Double potassium) {
        this.potassium = potassium;
    }

    public Double getMlingram() {
        return mlingram;
    }

    public void setMlingram(Double mlingram) {
        this.mlingram = mlingram;
    }

    public Integer getHeadcategoryid() {
        return headcategoryid;
    }

    public void setHeadcategoryid(Integer headcategoryid) {
        this.headcategoryid = headcategoryid;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Double getSaturatedfat() {
        return saturatedfat;
    }

    public void setSaturatedfat(Double saturatedfat) {
        this.saturatedfat = saturatedfat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getShowonlysametype() {
        return showonlysametype;
    }

    public void setShowonlysametype(Integer showonlysametype) {
        this.showonlysametype = showonlysametype;
    }

    public Double getGramsperserving() {
        return gramsperserving;
    }

    public void setGramsperserving(Double gramsperserving) {
        this.gramsperserving = gramsperserving;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

}