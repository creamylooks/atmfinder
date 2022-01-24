package com.lloyds.atmfinder.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * External Service Response
 */
public class ExternalServiceResponse implements Serializable {
    @JsonProperty("meta")
    private Metadata metadata;
    @JsonProperty("data")
    private List<ExternalServiceData> data;

    /**
     * Constructor for External Service Response
     * @param metadata Metadata for the response
     * @param data Data containing Atm Details List
     */
    public ExternalServiceResponse(Metadata metadata, List<ExternalServiceData> data) {
        this.metadata = metadata;
        this.data = data;
    }

    /**
     * No-Args Constructor for External Service Response
     */
    public ExternalServiceResponse() {
    }

    /**
     * Getter for Metadata
     * @return Metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * Setter for Metadata
     * @param metadata metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * Getter for Collection of Data for the Atm Details from the  External Service
     * @return Collection of External Service Data
     */
    public List<ExternalServiceData> getData() {
        return data;
    }

    /**
     * Setter for Collection of Data for the Atm Details from the  External Service
     * @param data Collection of External Service Data
     */
    public void setData(List<ExternalServiceData> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalServiceResponse that = (ExternalServiceResponse) o;
        return Objects.equals(metadata, that.metadata) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, data);
    }

    @Override
    public String toString() {
        return "ExternalServiceResponse{" +
                "metadata=" + metadata +
                ", data=" + data +
                '}';
    }
}
