package com.lloyds.atmfinder.domain;

import java.util.Date;

/**
 * Error Message Entity
 */
public class ErrorMessage {
  private int statusCode;
  private Date timestamp;
  private String message;
  private String description;

  /**
   * Error Message Constructor
   * @param statusCode Status code
   * @param timestamp time stamp
   * @param message error message
   * @param description Error Description
   */
  public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
    this.statusCode = statusCode;
    this.timestamp = timestamp;
    this.message = message;
    this.description = description;
  }

  /**
   * Getter for Status Code
   * @return Status Code
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Getter for Timestamp
   * @return Time Stamp
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Getter for Error Message
   * @return Error Message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Getter for Error Description
   * @return Error Description
   */
  public String getDescription() {
    return description;
  }
}