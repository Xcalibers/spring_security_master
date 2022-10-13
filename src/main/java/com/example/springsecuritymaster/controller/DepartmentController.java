package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.DepartmentDao;
import com.example.springsecuritymaster.ds.Department;
import com.example.springsecuritymaster.security.annotations.departments.IsDepartmentAdmin;
import com.example.springsecuritymaster.security.annotations.departments.IsDepartmentCreate;
import com.example.springsecuritymaster.security.annotations.departments.IsDepartmentDelete;
import com.example.springsecuritymaster.security.annotations.departments.IsDepartmentRead;
import org.hibernate.boot.jaxb.spi.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;
    @IsDepartmentRead
    @GetMapping("/department")
    public String showDepartments(Model model){
        model.addAttribute("department",departmentDao.findAll());
        return "department";
    }
    @IsDepartmentCreate
    @GetMapping("/createDepartment")
    public String createDepartment(Model model){
        model.addAttribute("department",new Department());
        return "department-form";
    }

    @IsDepartmentCreate
    @PostMapping("/createDepartment")
    public String saveDepartment(@Valid Department department, BindingResult result){
        if (result.hasErrors()){
            return "department-form";
        }
        departmentDao.save(department);
        return "redirect:/department";
    }

    @IsDepartmentDelete
    @GetMapping("/department/delete")
    public String deleteDepartment(@RequestParam("id") int id){
        departmentDao.deleteById(id);
        return "redirect:/department";
    }

}
