package com.api.parkingcontrol.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.entities.ParkingSpot;
import com.api.parkingcontrol.entities.dto.ParkingSpotDto;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {
	
	@Autowired
	private ParkingSpotService service;
	
	@PostMapping
	public ResponseEntity<ParkingSpot> add(@RequestBody ParkingSpotDto dto) {
		var ps = service.insert(dto);
		return ResponseEntity.ok().body(ps);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingSpotDto> get(@PathVariable(value = "id") UUID id) throws Exception {
		var psDto = service.getId(id);
		return ResponseEntity.ok().body(psDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable(value = "id") UUID id) throws Exception {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
