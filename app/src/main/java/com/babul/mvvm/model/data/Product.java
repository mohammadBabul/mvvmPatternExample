package com.babul.mvvm.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("image_urls")
    @Expose
    private List<String> imageUrls = null;
    @SerializedName("price_type")
    @Expose
    private String priceType;
    @SerializedName("max_price")
    @Expose
    private Integer maxPrice;
    @SerializedName("min_price")
    @Expose
    private Integer minPrice;
    @SerializedName("min_discounted_price")
    @Expose
    private Integer minDiscountedPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMinDiscountedPrice() {
        return minDiscountedPrice;
    }

    public void setMinDiscountedPrice(Integer minDiscountedPrice) {
        this.minDiscountedPrice = minDiscountedPrice;
    }

}