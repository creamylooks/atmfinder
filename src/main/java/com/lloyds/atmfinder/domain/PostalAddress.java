package com.lloyds.atmfinder.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Postal Address Entity
 */
public class PostalAddress implements Serializable {
    @JsonProperty("AddressLine")
    private List<String> addressLine;
    @JsonProperty("StreetName")
    private String streetName;
    @JsonProperty("TownName")
    private String townName;
    @JsonProperty("CountrySubDivision")
    private List<String> countrySubDivision;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("PostCode")
    private String postCode;

    /**
     *  Constructor for Postal Address
     * @param addressLine Address line
     * @param streetName Street Name
     * @param townName Town Name
     * @param countrySubDivision Country Sub Division
     * @param country Country Code
     * @param postCode Post Code
     */
    public PostalAddress(List<String> addressLine, String streetName, String townName, List<String> countrySubDivision, String country, String postCode) {
        this.addressLine = addressLine;
        this.streetName = streetName;
        this.townName = townName;
        this.countrySubDivision = countrySubDivision;
        this.country = country;
        this.postCode = postCode;
    }

    /**
     * No-Args Constructor for serialisation/de-serialisation
     */
    public PostalAddress() {
    }

    /**
     * Getter for address line
     * @return Address line
     */
    public List<String> getAddressLine() {
        return addressLine;
    }

    /**
     * Setter for address line
     * @param addressLine Address line
     */
    public void setAddressLine(List<String> addressLine) {
        this.addressLine = addressLine;
    }

    /**
     * Getter for street name
     * @return Street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Setter for Street name
     * @param streetName Street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Getter for town name
     * @return town name
     */
    public String getTownName() {
        return townName;
    }

    /**
     * Setter for town name
     * @param townName town name
     */
    public void setTownName(String townName) {
        this.townName = townName;
    }

    /**
     * Getter for country sub division
     * @return country sub division
     */
    public List<String> getCountrySubDivision() {
        return countrySubDivision;
    }

    /**
     * Setter for country sub division
     * @param countrySubDivision country sub division
     */
    public void setCountrySubDivision(List<String> countrySubDivision) {
        this.countrySubDivision = countrySubDivision;
    }

    /**
     * Getter for country code
     * @return country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for country code
     * @param country country code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *  Getter for Post code
     * @return Post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Setter for Post Code
     * @param postCode Post code
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalAddress that = (PostalAddress) o;
        return Objects.equals(addressLine, that.addressLine) &&
                Objects.equals(streetName, that.streetName) &&
                Objects.equals(townName, that.townName) &&
                Objects.equals(countrySubDivision, that.countrySubDivision) &&
                Objects.equals(country, that.country) &&
                Objects.equals(postCode, that.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine, streetName, townName, countrySubDivision, country, postCode);
    }

    @Override
    public String toString() {
        return "PostalAddress{" +
                "addressLine=" + addressLine +
                ", streetName='" + streetName + '\'' +
                ", townName='" + townName + '\'' +
                ", countrySubDivision=" + countrySubDivision +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
