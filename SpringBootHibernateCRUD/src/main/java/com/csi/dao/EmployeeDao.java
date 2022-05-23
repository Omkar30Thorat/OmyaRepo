package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void saveAllData();

    public List<Employee> getAllData();

    public  void updataData();

    public  void deleteData();

    void updataData(int empId, Employee employee);

    void deleteData(int empId);
}
