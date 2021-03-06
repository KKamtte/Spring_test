package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Address;
import net.skhu.dto.Employee;
import net.skhu.mapper.AddressMapper;
import net.skhu.mapper.EmployeeMapper;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired EmployeeMapper employeeMapper;
    @Autowired AddressMapper addressMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<Address> address = addressMapper.findAll();
        model.addAttribute("address", address);
        return "address/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Address address = new Address();
        List<Employee> employee = employeeMapper.findAll();
        model.addAttribute("address", address);
        model.addAttribute("employee", employee);
        return "address/edit";
    }

    @PostMapping("create")
    public String create(Model model, Employee employee) {
        employeeMapper.insert(employee);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Address address = addressMapper.findOne(id);
        List<Employee> employee = employeeMapper.findAll();
        model.addAttribute("address", address);
        model.addAttribute("employee", employee);
        return "address/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Address address) {
        addressMapper.update(address);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        addressMapper.delete(id);
        return "redirect:list";
    }
}

