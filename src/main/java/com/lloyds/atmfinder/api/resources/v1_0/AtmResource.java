package com.lloyds.atmfinder.api.resources.v1_0;

import com.lloyds.atmfinder.domain.Atm;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.List;

import static com.lloyds.atmfinder.domain.ValidationConstants.ID_PATTERN;
import static com.lloyds.atmfinder.domain.ValidationConstants.URI_PATTERN;

/**
 * Represents the Atm Resource and Houses all it's api specifications
 */
@RestController
@RequestMapping(value = "/atms/v1.0")
public interface AtmResource {
    /**
     * Retrieves the atm details for an atm. It accepts the atm's unique ID as
     * parameter and returns the details of the corresponding atm. It accepts
     * an optional uri parameter which can be used to specify the external service
     * uri it will fetch the atm details from.
     *
     * @param id Unique ID of the atm whose details are being retrieved
     * @param uri Url to be used for retrieving the atm details
     * @return Response Entity containing Atm details for the atm matching the provided ID
     */
    @GetMapping(value = "/{id:.+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    ResponseEntity<Atm>getAtm(@PathVariable("id") @Pattern(regexp = ID_PATTERN) @Validated String id,
                              @RequestParam(value = "uri", required = false) @Pattern(regexp = URI_PATTERN) @Validated URI uri);

    /**
     * Returns a list of all Atms with their details
     * @return Response entity containing Details of all ATMs
     */
    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    ResponseEntity<List<Atm>>getAllAtms();
}
