package se.mtiasp.foodfavorites.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServingSize {

    @SerializedName("name_de")
    @Expose
    private String nameDe;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("name_sv")
    @Expose
    private String nameSv;
    @SerializedName("name_es")
    @Expose
    private String nameEs;
    @SerializedName("name_fr")
    @Expose
    private String nameFr;
    @SerializedName("lastupdated")
    @Expose
    private Integer lastupdated;
    @SerializedName("name_nl")
    @Expose
    private String nameNl;
    @SerializedName("source")
    @Expose
    private Object source;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("name_pt")
    @Expose
    private String namePt;
    @SerializedName("proportion")
    @Expose
    private Double proportion;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_no")
    @Expose
    private String nameNo;
    @SerializedName("name_ru")
    @Expose
    private String nameRu;
    @SerializedName("name_it")
    @Expose
    private String nameIt;
    @SerializedName("servingcategory")
    @Expose
    private Integer servingcategory;
    @SerializedName("name_da")
    @Expose
    private String nameDa;
    @SerializedName("oid")
    @Expose
    private Integer oid;
    @SerializedName("countryfilter")
    @Expose
    private String countryfilter;
    @SerializedName("name_pl")
    @Expose
    private String namePl;

    public String getNameDe() {
        return nameDe;
    }

    public void setNameDe(String nameDe) {
        this.nameDe = nameDe;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getNameSv() {
        return nameSv;
    }

    public void setNameSv(String nameSv) {
        this.nameSv = nameSv;
    }

    public String getNameEs() {
        return nameEs;
    }

    public void setNameEs(String nameEs) {
        this.nameEs = nameEs;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public Integer getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Integer lastupdated) {
        this.lastupdated = lastupdated;
    }

    public String getNameNl() {
        return nameNl;
    }

    public void setNameNl(String nameNl) {
        this.nameNl = nameNl;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNamePt() {
        return namePt;
    }

    public void setNamePt(String namePt) {
        this.namePt = namePt;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameNo() {
        return nameNo;
    }

    public void setNameNo(String nameNo) {
        this.nameNo = nameNo;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameIt() {
        return nameIt;
    }

    public void setNameIt(String nameIt) {
        this.nameIt = nameIt;
    }

    public Integer getServingcategory() {
        return servingcategory;
    }

    public void setServingcategory(Integer servingcategory) {
        this.servingcategory = servingcategory;
    }

    public String getNameDa() {
        return nameDa;
    }

    public void setNameDa(String nameDa) {
        this.nameDa = nameDa;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getCountryfilter() {
        return countryfilter;
    }

    public void setCountryfilter(String countryfilter) {
        this.countryfilter = countryfilter;
    }

    public String getNamePl() {
        return namePl;
    }

    public void setNamePl(String namePl) {
        this.namePl = namePl;
    }

}