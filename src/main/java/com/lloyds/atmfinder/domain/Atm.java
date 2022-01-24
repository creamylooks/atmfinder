package com.lloyds.atmfinder.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * An Entity Representing the Atm Resource
 */
public class Atm implements Serializable {
    @JsonProperty("Identification")
    private String identification;
    @JsonProperty("SupportedCurrencies")
    private List<String> supportedCurrencies;
    @JsonProperty("Location")
    private Location location;

    /**
     * Atm Constructor
     * @param identification Unique ID for the Atm
     * @param supportedCurrencies List of  Currencies Supported by the ATM
     * @param location Location details of the Atm
     */
    public Atm(String identification, List<String> supportedCurrencies, Location location) {
        this.identification = identification;
        this.supportedCurrencies = supportedCurrencies;
        this.location = location;
    }

    /**
     * No Args Constructor for serialisation/de-serialisation
     */
    public Atm() {
    }

    /**
     *  Getter for the Unique ID of the Atm
     * @return Unique ID for the Atm
     */
    public String getIdentification() {
        return identification;
    }

    /**
     *  Setter for the Unique ID of the Atm
     * @param identification Unique ID for the Atm
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * Getter for the List of Supported Currencies
     * @return List of Supported Currencies
     */
    public List<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    /**
     * Setter for the List of Supported Currencies
     * @param supportedCurrencies List of Supported Currencies
     */
    public void setSupportedCurrencies(List<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    /**
     * Getter for the Location details of the Atm
     * @return Location details of the Atm
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Setter for the Location details of the Atm
     * @param location Location details of the Atm
     */
    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return Objects.equals(identification, atm.identification) &&
                Objects.equals(supportedCurrencies, atm.supportedCurrencies) &&
                Objects.equals(location, atm.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification, supportedCurrencies, location);
    }

    @Override
    public String toString() {
        return "Atm{" +
                "identification='" + identification + '\'' +
                ", supportedCurrencies=" + supportedCurrencies +
                ", location=" + location +
                '}';
    }
}
