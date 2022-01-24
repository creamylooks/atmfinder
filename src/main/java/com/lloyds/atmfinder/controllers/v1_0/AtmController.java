package com.lloyds.atmfinder.controllers.v1_0;

import com.lloyds.atmfinder.api.resources.v1_0.AtmResource;
import com.lloyds.atmfinder.domain.Atm;
import com.lloyds.atmfinder.services.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.net.URI;
import java.util.List;

/**
 * Controller for the Atm Resource
 */
@Controller
public class AtmController implements AtmResource {

    private final AtmService atmService;

    /**
     * Constructor for Atm Controller
     * @param atmService An instance of Atm Service containing business logic for Atm Resource
     */
    @Autowired
    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    /**
     * Retrieves the atm details for an atm. It accepts the atm's unique ID as
     * parameter and returns the details of the corresponding atm. It accepts
     * an optional uri parameter which can be used to specify the external service
     * uri it will fetch the atm details from. if the uri is not provided, it uses
     * default url provided in the application property <code>${service.host}</code>"
     *
     * @param id Unique ID of the atm whose details are being retrieved
     * @param uri Url to be used for retrieving the atm details
     * @return Response Entity containing Atm details for the atm matching the provided ID
     */
    @Override
    public ResponseEntity<Atm> getAtm(String id, URI uri) {
        return new ResponseEntity<>(this.atmService.getAtmById(id, uri), HttpStatus.OK);
    }

    /**
     * Returns a list of all Atms with their details
     * @return Response entity containing Details of all ATMs
     */
    @Override
    public ResponseEntity<List<Atm>> getAllAtms() {
        return new ResponseEntity<>(this.atmService.getAllAtms(), HttpStatus.OK);
    }
}
