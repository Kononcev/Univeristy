package command;

import dao.UniversityDAO;
import dao.implementation.University;
import datahandler.Handler;
import model.Departments;

public class EmployeeCountCommand implements Command {
    private Handler employeeCount;
    private UniversityDAO university;

    public EmployeeCountCommand(){
        this.employeeCount = new Handler();
        this.university = new University();
    }

    public void execute(Departments department) {
        LOG.info(employeeCount.showDepartmentEmployeeCount(university.getDepartmentEmployeeCount(department)));
    }
}
