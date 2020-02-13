package com.jpr_hrms.db;
import com.jpr_hrms.modell.Employee;

import java.util.List;

public interface IDbHelper {

    public int createEmploye(Employee employe);

    public Employee getEmploye(String empId);

    public void updateEmploye(Employee employe);

    public int deleteEmploye(Employee employe);

    public List<Employee> getAllEmploye();

    public Employee getEmpByIDANDPassword(int empId, String password);

    public Employee getEmpByPin(int  pin);


}
