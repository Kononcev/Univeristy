package command;

import dao.UniversityDAO;
import dao.implementation.University;
import datahandler.Handler;
import model.Departments;

public class AverageSalaryCommand implements Command {
    private Handler getSalary;
    private UniversityDAO university;

    public AverageSalaryCommand() {
        this.getSalary = new Handler();
        this.university = new University();
    }

    public void execute(Departments department) {
        LOG.info(getSalary.showDepartmentAverageSalary(university.getDepartmentAverageSalary(department)));
    }
}
