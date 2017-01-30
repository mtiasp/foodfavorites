package se.mtiasp.foodfavorites.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServingCategory {

    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("usemedian")
    @Expose
    private Integer usemedian;
    @SerializedName("name_en")
    @Expose
    private Object nameEn;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_de")
    @Expose
    private Object nameDe;
    @SerializedName("name_it")
    @Expose
    private Object nameIt;
    @SerializedName("name_da")
    @Expose
    private Object nameDa;
    @SerializedName("linearquantity")
    @Expose
    private Double linearquantity;
    @SerializedName("name_pl")
    @Expose
    private Object namePl;
    @SerializedName("name_es")
    @Expose
    private Object nameEs;
    @SerializedName("name_fr")
    @Expose
    private Object nameFr;
    @SerializedName("name_nl")
    @Expose
    private Object nameNl;
    @SerializedName("source")
    @Expose
    private Object source;
    @SerializedName("defaultsize")
    @Expose
    private Integer defaultsize;
    @SerializedName("name_pt")
    @Expose
    private Object namePt;
    @SerializedName("name_sv")
    @Expose
    private Object nameSv;
    @SerializedName("name_no")
    @Expose
    private Object nameNo;
    @SerializedName("name_ru")
    @Expose
    private Object nameRu;
    @SerializedName("lastupdated")
    @Expose
    private Integer lastupdated;
    @SerializedName("linearsize")
    @Expose
    private Integer linearsize;
    @SerializedName("oid")
    @Expose
    private Integer oid;

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUsemedian() {
        return usemedian;
    }

    public void setUsemedian(Integer usemedian) {
        this.usemedian = usemedian;
    }

    public Object getNameEn() {
        return nameEn;
    }

    public void setNameEn(Object nameEn) {
        this.nameEn = nameEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNameDe() {
        return nameDe;
    }

    public void setNameDe(Object nameDe) {
        this.nameDe = nameDe;
    }

    public Object getNameIt() {
        return nameIt;
    }

    public void setNameIt(Object nameIt) {
        this.nameIt = nameIt;
    }

    public Object getNameDa() {
        return nameDa;
    }

    public void setNameDa(Object nameDa) {
        this.nameDa = nameDa;
    }

    public Double getLinearquantity() {
        return linearquantity;
    }

    public void setLinearquantity(Double linearquantity) {
        this.linearquantity = linearquantity;
    }

    public Object getNamePl() {
        return namePl;
    }

    public void setNamePl(Object namePl) {
        this.namePl = namePl;
    }

    public Object getNameEs() {
        return nameEs;
    }

    public void setNameEs(Object nameEs) {
        this.nameEs = nameEs;
    }

    public Object getNameFr() {
        return nameFr;
    }

    public void setNameFr(Object nameFr) {
        this.nameFr = nameFr;
    }

    public Object getNameNl() {
        return nameNl;
    }

    public void setNameNl(Object nameNl) {
        this.nameNl = nameNl;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Integer getDefaultsize() {
        return defaultsize;
    }

    public void setDefaultsize(Integer defaultsize) {
        this.defaultsize = defaultsize;
    }

    public Object getNamePt() {
        return namePt;
    }

    public void setNamePt(Object namePt) {
        this.namePt = namePt;
    }

    public Object getNameSv() {
        return nameSv;
    }

    public void setNameSv(Object nameSv) {
        this.nameSv = nameSv;
    }

    public Object getNameNo() {
        return nameNo;
    }

    public void setNameNo(Object nameNo) {
        this.nameNo = nameNo;
    }

    public Object getNameRu() {
        return nameRu;
    }

    public void setNameRu(Object nameRu) {
        this.nameRu = nameRu;
    }

    public Integer getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Integer lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Integer getLinearsize() {
        return linearsize;
    }

    public void setLinearsize(Integer linearsize) {
        this.linearsize = linearsize;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

}