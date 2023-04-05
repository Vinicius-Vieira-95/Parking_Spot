package com.api.parkingcontrol.entities.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ParkingSpotDto {

	@NotBlank(message = "Campo não pode ser nulo")
	private String parkingSpotNumber;
	
	@NotBlank(message = "Campo não pode ser nulo")
	@Size(max = 7)
	private String licensePlateCar;
	
	@NotBlank(message = "Campo não pode ser nulo")
	private String brandCar;
	
	@NotBlank(message = "Campo não pode ser nulo")
	private String modelCar;
	
	@NotBlank(message = "Campo não pode ser nulo")
	private String colorCar;
	
	@NotBlank(message = "Campo não pode ser nulo")
	private String responsibleName;
	
	@NotBlank(message = "Campo não pode ser nulo")
	private String apartment;
	
	@NotBlank(message = "Campo não pode ser nulo")
	private String block;
}
