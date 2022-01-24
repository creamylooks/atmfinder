package com.lloyds.atmfinder.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Location Entity
 */
public class Location implements Serializable {
    @JsonProperty("PostalAddress")
    private PostalAddress postalAddress;

    /**
     * Constructor for Location
     * @param postalAddress Postal Address
     */
    public Location(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * No-Args Constructor for Serialisation/ De-Serialisation
     */
    public Location() {
    }

    /**
     * Getter for Postal Address
     * @return Postal Address
     */
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    /**
     * Setter for Postal Address
     * @param postalAddress Postal Address
     */
    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(postalAddress, location.postalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalAddress);
    }

    @Override
    public String toString() {
        return "Location{" +
                "postalAddress=" + postalAddress +
                '}';
    }
}
