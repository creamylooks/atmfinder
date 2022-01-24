package com.lloyds.atmfinder.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Brand of the Atm
 */
public class Brand implements Serializable {

    @JsonProperty("BrandName")
    private String brandName;
    @JsonProperty("ATM")
    private List<Atm> atms;

    /**
     * Constructor for brand of the atm
     * @param brandName Brand name of the atm
     * @param atms List of all Atms for the brand
     */
    public Brand(String brandName, List<Atm> atms) {
        this.brandName = brandName;
        this.atms = atms;
    }

    /**
     * No Args Constructor for serialisation/de-serialisation
     */
    public Brand() {
    }

    /**
     * Getter for Brand name of the atm
     * @return Brand name of the atm
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Setter for Brand name of the atm
     * @param brandName Brand name of the atm
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Getter for List of all Atms for the brand
     * @return List of all Atms for the brand
     */
    public List<Atm> getAtms() {
        return atms;
    }

    /**
     * Setter for List of all Atms for the brand
     * @param atms List of all Atms for the brand
     */
    public void setAtms(List<Atm> atms) {
        this.atms = atms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(brandName, brand.brandName) &&
                Objects.equals(atms, brand.atms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, atms);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandName='" + brandName + '\'' +
                ", atms=" + atms +
                '}';
    }
}
