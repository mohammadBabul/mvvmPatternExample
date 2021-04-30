
package com.babul.mvvm.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Shop implements Serializable {
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop_image")
    @Expose
    private String shopImage;
    @SerializedName("logo_image")
    @Expose
    private String logoImage;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("approval")
    @Expose
    private Boolean approval;
    @SerializedName("owner_username")
    @Expose
    private String ownerUsername;
    @SerializedName("owner_name")
    @Expose
    private String ownerName;
    @SerializedName("owner_number")
    @Expose
    private String ownerNumber;
    @SerializedName("cashback_percentage")
    @Expose
    private Integer cashbackPercentage;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("is_cod_allowed")
    @Expose
    private Boolean isCodAllowed;
    @SerializedName("campaign_category_name")
    @Expose
    private String campaignCategoryName;
    @SerializedName("campaign_category_slug")
    @Expose
    private String campaignCategorySlug;
    @SerializedName("campaign_name")
    @Expose
    private String campaignName;
    @SerializedName("campaign_slug")
    @Expose
    private String campaignSlug;
    @SerializedName("campaign_start_at")
    @Expose
    private String campaignStartAt;
    @SerializedName("campaign_ends_at")
    @Expose
    private String campaignEndsAt;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public Integer getCashbackPercentage() {
        return cashbackPercentage;
    }

    public void setCashbackPercentage(Integer cashbackPercentage) {
        this.cashbackPercentage = cashbackPercentage;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getIsCodAllowed() {
        return isCodAllowed;
    }

    public void setIsCodAllowed(Boolean isCodAllowed) {
        this.isCodAllowed = isCodAllowed;
    }

    public String getCampaignCategoryName() {
        return campaignCategoryName;
    }

    public void setCampaignCategoryName(String campaignCategoryName) {
        this.campaignCategoryName = campaignCategoryName;
    }

    public String getCampaignCategorySlug() {
        return campaignCategorySlug;
    }

    public void setCampaignCategorySlug(String campaignCategorySlug) {
        this.campaignCategorySlug = campaignCategorySlug;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignSlug() {
        return campaignSlug;
    }

    public void setCampaignSlug(String campaignSlug) {
        this.campaignSlug = campaignSlug;
    }

    public String getCampaignStartAt() {
        return campaignStartAt;
    }

    public void setCampaignStartAt(String campaignStartAt) {
        this.campaignStartAt = campaignStartAt;
    }

    public String getCampaignEndsAt() {
        return campaignEndsAt;
    }

    public void setCampaignEndsAt(String campaignEndsAt) {
        this.campaignEndsAt = campaignEndsAt;
    }

}






