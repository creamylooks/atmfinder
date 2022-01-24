package com.lloyds.atmfinder.services;

import com.lloyds.atmfinder.domain.*;
import com.lloyds.atmfinder.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
public class AtmServiceTest {


    private AtmService atmService;
    private URI uri = URI.create("http://localhost:8000");
    private Atm atm = new Atm("ABCDEF11", Collections.singletonList("GB"), new Location());
    private ExternalService externalService;
    private ExternalServiceResponse esr;

    @BeforeEach
    public void setUp(){
        externalService = Mockito.mock(ExternalService.class);
        atmService = new AtmService(externalService, 86400000);
        Brand brand = new Brand("testBrand", Collections.singletonList(atm));
        ExternalServiceData esd = new ExternalServiceData(Collections.singletonList(brand));
        esr = new ExternalServiceResponse(new Metadata(), Collections.singletonList(esd));
    }

    @Test
    public void getAtmByIdWithNullID() {
        Mockito.when(this.externalService.get(ExternalServiceResponse.class, uri.toString())).thenReturn(esr);
        Assertions.assertThrows(NotFoundException.class, () -> this.atmService.getAtmById(null, uri));
        Mockito.verify(externalService, Mockito.times(1)).get(ExternalServiceResponse.class, uri.toString());
    }

    @Test
    public void getAtmByIdWithValidDetails() {
        uri = uri.resolve("/abc");
        Mockito.when(this.externalService.get(ExternalServiceResponse.class, uri.toString())).thenReturn(esr);
        Assertions.assertEquals(atm, this.atmService.getAtmById("ABCDEF11", uri));
        Mockito.verify(externalService, Mockito.times(1)).get(ExternalServiceResponse.class, uri.toString());
    }


    @Test
    public void getAtmByIdCacheRetrieveTest() {
        uri = uri.resolve("/test");
        Mockito.when(this.externalService.get(ExternalServiceResponse.class, uri.toString())).thenReturn(esr);
        IntStream.range(0, 10).forEach(index-> Assertions.assertEquals(atm, this.atmService.getAtmById("ABCDEF11", uri)));
        Mockito.verify(externalService, Mockito.times(1)).get(ExternalServiceResponse.class, uri.toString());
    }
}
