package com.lloyds.atmfinder.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * External Service data Entity
 */
public class ExternalServiceData implements Serializable {
    @JsonProperty("Brand")
    private List<Brand> brands;

    /**
     * Constructor for External Service Data
     * @param brands List of brands
     */
    public ExternalServiceData(List<Brand> brands) {
        this.brands = brands;
    }

    /**
     * No-Args Constructor for Serialisation/De-Serialisation
     */
    public ExternalServiceData() {
    }

    /**
     * Getter for List of Brands
     * @return List of Brands
     */
    public List<Brand> getBrands() {
        return brands;
    }

    /**
     * Setter for List of Brands
     * @param brands List of Brands
     */
    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalServiceData that = (ExternalServiceData) o;
        return Objects.equals(brands, that.brands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brands);
    }

    @Override
    public String toString() {
        return "ExternalServiceData{" +
                "brands=" + brands +
                '}';
    }
}
