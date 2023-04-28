package com.api.parkingcontrol.controller;

import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.parkingcontrol.controllers.ParkingSpotController;
import com.api.parkingcontrol.entities.dto.ParkingSpotDto;
import com.api.parkingcontrol.services.ParkingSpotService;

import io.restassured.http.ContentType;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class ParkingSpotControllerTest {

    @Autowired
    private ParkingSpotController parkingSpotController;

    @MockBean
    private ParkingSpotService parkingSpotService;

    @MockBean
    private ParkingSpotDto dto;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.parkingSpotController);

        dto = new ParkingSpotDto();
        dto.setApartment("A20");
        dto.setBlock("A");
        dto.setBrandCar("Fiat");
        dto.setColorCar("Azul");
        dto.setModelCar("Uno");
        dto.setLicensePlateCar("ABC1234");
        dto.setParkingSpotNumber("1");
        dto.setResponsibleName("João da Silva");
    }

    @Test
    public void getTest() throws Exception {
        // cenario
        // acao
        var id = UUID.randomUUID();
        when(this.parkingSpotService.getId(id)).thenReturn(dto);
        // verificacao
        given().accept(ContentType.JSON).get("/parking-spot/{id}", id).then().statusCode(200);
    }
    
    @Test
    public void postTest() {
    	//cenario
    	when(this.parkingSpotService.insert(dto)).thenReturn(dto);
    	//verificação
    	given().contentType(ContentType.JSON).body(dto).when().post("/parking-spot").then().statusCode(201);
    	
    }
    
    public void  updateTest() {
    	
    }

}











