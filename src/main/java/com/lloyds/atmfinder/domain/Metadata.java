package com.lloyds.atmfinder.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.Objects;

/**
 * Metadata Entity
 */
public class Metadata implements Serializable {
    @JsonProperty("LastUpdated")
    private Date lastUpdated;
    @JsonProperty("TotalResults")
    private long totalResultsCount;
    @JsonProperty("Agreement")
    private String agreement;
    @JsonProperty("License")
    private URI license;
    @JsonProperty("TermsOfUse")
    private URI termsOfUse;

    /**
     * Constructor for the metadata
     * @param lastUpdated Date of last update
     * @param totalResultsCount total count of results
     * @param agreement agreement url
     * @param license license url
     * @param termsOfUse terms of use url
     */
    public Metadata(Date lastUpdated, long totalResultsCount, String agreement, URI license, URI termsOfUse) {
        this.lastUpdated = lastUpdated;
        this.totalResultsCount = totalResultsCount;
        this.agreement = agreement;
        this.license = license;
        this.termsOfUse = termsOfUse;
    }

    /**
     *  No-Args Constructor for serialisation/de-serialisation
     */
    public Metadata() {
    }

    /**
     * Getter for date of last update
     * @return Date of last update
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Setter for date of last update
     * @param lastUpdated Date of last update
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Getter for total count of results
     * @return total count of results
     */
    public long getTotalResultsCount() {
        return totalResultsCount;
    }

    /**
     * Setter for total count of results
     * @param totalResultsCount total count of results
     */
    public void setTotalResultsCount(long totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    /**
     *  Getter for Agreement
     * @return Agreement url
     */
    public String getAgreement() {
        return agreement;
    }

    /**
     * Setter for Agreement
     * @param agreement Agreement  url
     */
    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    /**
     * Getter for license url
     * @return license url
     */
    public URI getLicense() {
        return license;
    }

    /**
     * Setter for license url
     * @param license license url
     */
    public void setLicense(URI license) {
        this.license = license;
    }

    /**
     * Getter for terms of Use URI
     * @return terms of use URI
     */
    public URI getTermsOfUse() {
        return termsOfUse;
    }

    /**
     *  Setter for terms of use uri
     * @param termsOfUse terms of use uri
     */
    public void setTermsOfUse(URI termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadata metadata = (Metadata) o;
        return totalResultsCount == metadata.totalResultsCount &&
                Objects.equals(lastUpdated, metadata.lastUpdated) &&
                Objects.equals(agreement, metadata.agreement) &&
                Objects.equals(license, metadata.license) &&
                Objects.equals(termsOfUse, metadata.termsOfUse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastUpdated, totalResultsCount, agreement, license, termsOfUse);
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "lastUpdated=" + lastUpdated +
                ", totalResultsCount=" + totalResultsCount +
                ", agreement='" + agreement + '\'' +
                ", license=" + license +
                ", termsOfUse=" + termsOfUse +
                '}';
    }
}
