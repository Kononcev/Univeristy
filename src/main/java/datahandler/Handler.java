package datahandler;

import constants.Constants;
import dao.UniversityDAO;
import dao.implementation.University;
import model.Departments;

import java.util.Map;

public class Handler {
    private String response = "Sorry data base don't contain such department\n";
    private UniversityDAO university;

    public  String showDepartmentHead(Map<String, String> departmentHead){
        for (Map.Entry<String, String> entry : departmentHead.entrySet())
        {
            response = String.format("Head of %s department is %s\n", entry.getKey(),entry.getValue());
        }
        return response;
    }

    public String showDepartmentSummary(Map<String, Integer> departmentSummary, Departments department){
        response = String.format("%s department statistics:\n",department.getName());
        for (Map.Entry<String, Integer> entry : departmentSummary.entrySet())
        {
            response += String.format("\t%s - %d\n", entry.getKey(), entry.getValue());
        }
        return response;
    }

    public String showDepartmentAverageSalary(Map<String, Double> departmentAverageSalary){
        for (Map.Entry<String, Double> entry : departmentAverageSalary.entrySet())
        {
            response = String.format("The average salary of %s department is %s$\n", entry.getKey(), Constants.DOUBLE_WITH_TWO_DIGITS.format(entry.getValue()));
        }
        return response;
    }

    public String showDepartmentEmployeeCount(Map<String, Integer> departmentEmployeeCount){
        for (Map.Entry<String, Integer> entry : departmentEmployeeCount.entrySet())
        {
            response = String.format("%s department has %d employee\n", entry.getKey(), entry.getValue());
        }
        return response;
    }
}
