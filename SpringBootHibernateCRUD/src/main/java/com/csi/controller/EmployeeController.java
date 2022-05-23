package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/savadata")
    public  String saveAllData(@RequestBody Employee employee){
        log.info("***************Trying to save Data***************"+employee.getEmpName());
        employeeServiceImpl.saveAllData();
        return "Data save SucessFully";
    }

    @GetMapping("/getdata")
    public List<Employee> getAllData(){
        return employeeServiceImpl.getAllData();
    }

    @PutMapping("/updatedata/{empId}")
    public String updateData(@PathVariable int empId, @RequestBody Employee employee ){
        log.info("***************Trying to update Data***************"+employee.getEmpName());
        employeeServiceImpl.updataData(empId ,employee);
        return "Data Updated Successfully";
    }

    @DeleteMapping("/deletedata/{empId}")
    public String deleteData(@PathVariable int empId){
        employeeServiceImpl.deleteData(empId);
        return "Data Deleted Succesfully";
    }
}
