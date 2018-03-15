package dao;

import model.Departments;

import java.util.List;
import java.util.Map;

public interface UniversityDAO {
    Map<String, String> getDepartmentHead(Departments departmentName);
    Map<String, Integer> getDepartmentSummary(Departments departmentName);
    Map<String,Double> getDepartmentAverageSalary(Departments departmentName);
    Map<String,Integer> getDepartmentEmployeeCount(Departments departmentName);
    List<String> getDepartments();
    List<String> getLectors();
    List<String> getDegree();
}
