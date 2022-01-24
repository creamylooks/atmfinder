package com.lloyds.atmfinder.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Cached External Service Response Model
 */
public class CachedExternalServiceResponse implements Serializable {

    private Date date;
    private ExternalServiceResponse externalServiceResponse;

    /**
     * The Cached response with date it was cached
     * @param date Date the cache was taken
     * @param externalServiceResponse External service response to be cached
     */
    public CachedExternalServiceResponse(Date date, ExternalServiceResponse externalServiceResponse) {
        this.date = date;
        this.externalServiceResponse = externalServiceResponse;
    }

    /**
     * Getter for the Date of caching
     * @return Date the cache was taken
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for the date of Caching
     * @param date Date the cache was taken
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for External service response to be cached
     * @return External service response to be cached
     */
    public ExternalServiceResponse getExternalServiceResponse() {
        return externalServiceResponse;
    }

    /**
     * Setter for External service response to be cached
     * @param externalServiceResponse External service response to be cached
     */
    public void setExternalServiceResponse(ExternalServiceResponse externalServiceResponse) {
        this.externalServiceResponse = externalServiceResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CachedExternalServiceResponse that = (CachedExternalServiceResponse) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(externalServiceResponse, that.externalServiceResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, externalServiceResponse);
    }
}
