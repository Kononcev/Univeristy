package command;

import dao.UniversityDAO;
import dao.implementation.University;
import datahandler.Handler;
import model.Departments;

public class DepartmentHeadCommand implements Command {
    private Handler getHead;
    private UniversityDAO university;

    public DepartmentHeadCommand(){
        this.getHead = new Handler();
        this.university = new University();
    }

    public void execute(Departments department) {
        LOG.info(getHead.showDepartmentHead(university.getDepartmentHead(department)));
    }
}
