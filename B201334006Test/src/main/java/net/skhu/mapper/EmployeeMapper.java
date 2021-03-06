package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Employee;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee findOne(int id);

    @Select("SELECT * FROM employee WHERE employeeNo = #{employeeNo}")
    Employee findByEmployeeNumber(String employeeNo);

    @Select("SELECT e.*, d.title, a.phone, a.address    " +
            "FROM employee e LEFT JOIN department d 	" +
            " ON e.departmentId = d.id             		" +
            "LEFT JOIN address a 						" +
            " ON e.id = a.employeeId ")
    List<Employee> findAll();

    @Insert("INSERT employee (employeeNo, name, departmentId, salary, sex)     " +
            "VALUES (#{employeeNo}, #{name}, #{departmentId}, #{salary}, #{sex}) ")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Employee employee);

    @Update("UPDATE employee SET                 " +
            "  employeeNo = #{employeeNo}, 		 " +
            "  name = #{name},                   " +
            "  departmentId = #{departmentId},   " +
            "  salary = #{salary}                " +
            "  sex = #{sex}                    	 " +
            "WHERE id = #{id}                    ")
    void update(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(int id);
}
