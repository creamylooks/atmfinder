package com.lloyds.atmfinder.services.impl;

import com.lloyds.atmfinder.domain.ExternalServiceResponse;
import com.lloyds.atmfinder.services.ExternalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
@ExtendWith(SpringExtension.class)
public class DefaultExternalServiceImplTest {

    private RestTemplate restTemplate;
    private ExternalService des;
    private static final String PATH = "/open-banking/v2.2/atms";
    private static final String uri = "http://localhost:8001";
    private ExternalServiceResponse esr = new ExternalServiceResponse();

    @BeforeEach
    public void setUp(){
        restTemplate = Mockito.mock(RestTemplate.class);
        des = new DefaultExternalServiceImpl(restTemplate, uri);
    }


    @Test
    public void getWithOnlyResponseClassTest() {
        Mockito.when(restTemplate.getForObject(uri+PATH, ExternalServiceResponse.class)).thenReturn(esr);
        Assertions.assertEquals(esr, this.des.get(ExternalServiceResponse.class));
        Mockito.verify(restTemplate, Mockito.atLeastOnce()).getForObject(uri+PATH, ExternalServiceResponse.class);
    }

    @Test
    public void getWithResponseClassAndUriTest() {
        String uri = "http://localhost:5000";
        Mockito.when(restTemplate.getForObject(uri, ExternalServiceResponse.class)).thenReturn(esr);
        Assertions.assertEquals(esr, this.des.get(ExternalServiceResponse.class, uri));
        Mockito.verify(restTemplate, Mockito.atLeastOnce()).getForObject(uri, ExternalServiceResponse.class);
    }

    @Test
    public void getWithNullUri() {

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, ()-> this.des.get(ExternalServiceResponse.class, null));
        Assertions.assertEquals("Uri for the request to External Service cannot be null", exception.getMessage());

    }

}
