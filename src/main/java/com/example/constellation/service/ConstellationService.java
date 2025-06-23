package com.example.constellation.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.constellation.dao.IConstellationDao;
import com.example.constellation.dto.ConstellationDTO;


public class ConstellationService {
private final IConstellationDao constellationDao;
	
	public ConstellationService(IConstellationDao constellationDao) {
		this.constellationDao = constellationDao;
	}

	public List<ConstellationDTO> getAllBirthstone() {
		List<ConstellationDTO> blist = constellationDao.getAllConstellation();
		
		return blist;
	}

	public ConstellationDTO getBirthstoneByMonth(Integer month) {
		ConstellationDTO constellation = constellationDao.getConstellationByMonth(month);
		
		return constellation;
	}

	public ConstellationDTO getBirthstoneByBirth(String birth) {
		LocalDate date = getLocalDate(birth);
		int month = date.getMonthValue();
		
		ConstellationDTO birthstone =constellationDao.getConstellationByMonth(month);
		
		return birthstone;
	}
	
	private LocalDate getLocalDate(String birth) {
		List<DateTimeFormatter> fomatters = List.of(
			DateTimeFormatter.ofPattern("yyyy-MM-dd"), 
			DateTimeFormatter.ofPattern("yyyy/MM/dd"), 
			DateTimeFormatter.ofPattern("yyyy.MM.dd"), 
			DateTimeFormatter.ofPattern("yyyyMMdd")
		);
		
		for(DateTimeFormatter fomatter : fomatters) {
			try {
				return LocalDate.parse(birth, fomatter);				
			} catch(Exception e) {}
		}
		
		throw new IllegalArgumentException("입력한 날짜가 날짜 형식이 아닙니다. ");
	}
}
