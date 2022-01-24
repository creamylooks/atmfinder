package com.lloyds.atmfinder.services;

/**
 * Interface Representing External Service being called for retrieving data
 */
public interface ExternalService {
        /**
         * Makes a get request to an external API at the provided uri and returns of response of the provide type `responseType`
         * @param responseType Class of the Type of the response to be used for de-serialising the json
         * @param uri URI to be used for fetching the response
         * @param <T> Type of the response to be used for de-serialising the json
         * @return A response of type T
         */
        <T> T get(Class<T> responseType, String uri);

        /**
         * Makes a get request to an external API and returns a response of the provide type `responseType`
         * @param responseType Class of the Type of the response to be used for de-serialising the json
         * @param <T> Type of the response to be used for de-serialising the json
         * @return A response of type T
         */
        <T> T get(Class<T> responseType);
}
