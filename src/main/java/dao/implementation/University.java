package dao.implementation;

import connector.ConnectionFactory;
import constants.Constants;
import dao.UniversityDAO;
import model.Departments;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class University implements UniversityDAO{
    private final static Logger LOG = Logger.getLogger(University.class);

    public Map<String, String> getDepartmentHead(Departments departmentName) {
        LOG.debug("get department head from database");
        Map<String, String> departmentHead = new HashMap<String, String>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(String.format(Constants.DEPARTMENT_HEAD_QUERY, departmentName.getName()));
            while (rs.next()){
                departmentHead.put(rs.getString(1), (rs.getString(2)+" "+rs.getString(3)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return departmentHead;
    }

    public Map<String, Integer> getDepartmentSummary(Departments departmentName) {
        LOG.debug("get department summary from database");
        Map<String, Integer> departmentSummary = new HashMap<String, Integer>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(String.format(Constants.DEPARTMENT_STATISTICS_QUERY, departmentName.getName()));
            while (rs.next()){
                departmentSummary.put(rs.getString(1), Integer.valueOf(rs.getString(2)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return departmentSummary;
    }

    public Map<String,Double> getDepartmentAverageSalary(Departments departmentName) {
        LOG.debug("get average salary of department from database");
        Map<String,Double> averageSalary = new HashMap<String, Double>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(String.format(Constants.AVERAGE_SALARY_FOR_DEPARTMENT_QUERY, departmentName.getName()));
            while (rs.next()){
                averageSalary.put(rs.getString(1), Double.valueOf(rs.getString(2)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return averageSalary;
    }

    public Map<String,Integer> getDepartmentEmployeeCount(Departments departmentName) {
        LOG.debug("get count of department employee head from database");
        Map<String,Integer> employeeCount = new HashMap<String, Integer>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(String.format(Constants.EMPLOYEE_COUNT_OF_DEPARTMENT_QUERY, departmentName.getName()));
            while (rs.next()){
                employeeCount.put(rs.getString(1), Integer.valueOf(rs.getString(2)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employeeCount;
    }
}
