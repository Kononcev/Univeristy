package command;

import dao.UniversityDAO;
import dao.implementation.University;
import datahandler.Handler;
import model.Departments;

public class DepartmentSummaryCommand implements Command {
    private Handler getSummary;
    private UniversityDAO university;

    public DepartmentSummaryCommand(){
        this.getSummary = new Handler();
        this.university = new University();
    }

    public void execute(Departments department) {
        LOG.info(getSummary.showDepartmentSummary(university.getDepartmentSummary(department), department));
    }
}
