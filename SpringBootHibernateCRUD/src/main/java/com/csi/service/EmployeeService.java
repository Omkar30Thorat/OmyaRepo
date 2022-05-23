package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void saveAllData();

    public List<Employee> getAllData();

    public  void updataData(int empId, Employee employee);

    public  void deleteData(int empId);
}
