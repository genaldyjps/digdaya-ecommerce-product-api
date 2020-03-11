package com.digdaya.spring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PCODE", nullable = false)
    private String productCode;

    @Column(name = "NAME", nullable = false)
    private String productName;

    @Column(name = "SHORT_DESCRIPTION", nullable = false)
    private String shortDescription;

    @Column(name = "LONG_DESCRIPTION", nullable = false)
    private String longDescription;

    @Column(name = "CANDISPLAY", nullable = false)
    private boolean canDisplay;

    @Column(name = "ISDELETED", nullable = false)
    private boolean isDeleted;

    @Column(name = "ISAUTOMOTIVE", nullable = false)
    private boolean isAutomotive;

    @Column(name = "ISINTERNATIONAL", nullable = false)
    private boolean isInternational;

    @OneToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isCanDisplay() {
        return canDisplay;
    }

    public void setCanDisplay(boolean canDisplay) {
        this.canDisplay = canDisplay;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isAutomotive() {
        return isAutomotive;
    }

    public void setAutomotive(boolean automotive) {
        isAutomotive = automotive;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return canDisplay == product.canDisplay &&
                isDeleted == product.isDeleted &&
                isAutomotive == product.isAutomotive &&
                isInternational == product.isInternational &&
                Objects.equals(id, product.id) &&
                Objects.equals(productCode, product.productCode) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(shortDescription, product.shortDescription) &&
                Objects.equals(longDescription, product.longDescription) &&
                Objects.equals(parentCategory, product.parentCategory) &&
                Objects.equals(category, product.category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", canDisplay=" + canDisplay +
                ", isDeleted=" + isDeleted +
                ", isAutomotive=" + isAutomotive +
                ", isInternational=" + isInternational +
                ", parentCategory=" + parentCategory +
                ", category=" + category +
                '}';
    }

}
