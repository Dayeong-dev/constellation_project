package com.example.constellation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.constellation.dto.ConstellationDTO;


public interface IConstellationDao {

	@Select("SELECT * FROM tbl_constellation")
	public List<ConstellationDTO> getAllConstellation();

	@Select("SELECT * FROM tbl_constellation WHERE month = #{month}")
	public ConstellationDTO getConstellationByMonth(@Param("month") Integer month);
	
	@Insert("INSERT INTO tbl_constellation(MONTH, NAME, ENGNAME, DESCRIPTION, Image_url) VALUES (#{ct.month}, #{ct.name}, #{ct.engName}, #{ct.description}, #{ct.imageURL})")
	public void setBirthstone(@Param("ct") ConstellationDTO ct);
	
	@Update("UPDATE tbl_constellation SET NAME = #{name} WHERE MONTH = #{month}")
	public void updateBirthstoneName(@Param("name") String name, @Param("month") Integer month);
	
}
