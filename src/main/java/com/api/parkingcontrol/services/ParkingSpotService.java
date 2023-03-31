package com.api.parkingcontrol.services;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.entities.ParkingSpot;
import com.api.parkingcontrol.entities.dto.ParkingSpotDto;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	@Autowired
	private ParkingSpotRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Transactional
	public ParkingSpot insert(ParkingSpotDto dto) {
		var ps = mapper.map(dto, ParkingSpot.class);
		ps.setRegistrationDate(LocalDateTime.now());
		return repository.save(ps);
	}
	
	public ParkingSpotDto getId(UUID id) throws Exception {
		var ps = repository.findById(id).orElseThrow(() -> new Exception("id not found"));
		var psDto = mapper.map(ps, ParkingSpotDto.class);
		return psDto;
	}

	@Transactional
	public void delete(UUID id) throws Exception {
		repository.findById(id).orElseThrow(() -> new Exception("id not found"));
		repository.deleteById(id);
	}
}
