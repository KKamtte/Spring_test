package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Address;

@Mapper
public interface AddressMapper {

	@Select("SELECT * FROM address WHERE id = #{id}")
	Address findOne(int id);

	@Select("SELECT * FROM address WHERE employeeId = #{employeeId}")
	Address findByEmployeeId(int employeeId);

	@Select("SELECT a.*, e.name					 " +
			"FROM address a LEFT JOIN employee e " +
			" ON a.employeeId = e.id			 ")
	List<Address> findAll();

	@Insert("INSERT address (employeeId, phone, address)" +
			"VALUES (#{employeeId}, #{phone}, #{address}) ")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insert(Address address);

    @Update("UPDATE Employee SET                 " +
            "  employeeNo = #{employeeNo}, 		 " +
            "  name = #{name},                   " +
            "  departmentId = #{departmentId},   " +
            "  salary = #{salary}                " +
            "  sex = #{sex}                    	 " +
            "WHERE id = #{id}                    ")
    void update(Address address);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(int id);
}
