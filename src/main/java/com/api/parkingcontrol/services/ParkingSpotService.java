package com.api.parkingcontrol.services;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Transactional
	public ParkingSpotDto update(UUID id, ParkingSpotDto dto) {
		var ps = repository.getReferenceById(id);
		ps.setApartment(dto.getApartment());
		ps.setBlock(dto.getBlock());
		ps.setBrandCar(dto.getBrandCar());
		ps.setColorCar(dto.getColorCar());
		ps.setLicensePlateCar(dto.getLicensePlateCar());
		ps.setModelCar(dto.getModelCar());
		ps.setParkingSpotNumber(dto.getParkingSpotNumber());
		ps.setResponsibleName(dto.getResponsibleName());
		repository.save(ps);
		var psDto = mapper.map(ps, ParkingSpotDto.class);
		return psDto;
	}

	public Page<ParkingSpot> getPageable(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
