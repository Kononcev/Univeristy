package model;

import command.Command;
import command.SearchCommand;
import command.SearchCommands;

import java.util.List;

public class User {
    private Command getHead;
    private Command getAverageSalary;
    private Command getDepartmentSummary;
    private Command getEmployeeCount;
    private SearchCommand searchCommand;

    public User(Command getHead, Command getAverageSalary, Command getDepartmentSummary, Command getEmployeeCount, SearchCommand searchCommand) {
        this.getHead = getHead;
        this.getAverageSalary = getAverageSalary;
        this.getDepartmentSummary = getDepartmentSummary;
        this.getEmployeeCount = getEmployeeCount;
        this.searchCommand = searchCommand;
    }

    public void getDepartmentHead(Departments department) {
        getHead.execute(department);
    }

    public void getDepartmentAverageSalary(Departments department) {
        getAverageSalary.execute(department);
    }

    public void getDepartmentSummary(Departments department) {
        getDepartmentSummary.execute(department);
    }

    public void getDepartmentEmployeeCount(Departments department) {
        getEmployeeCount.execute(department);
    }

    public List<String> getDepartmentsName(){
        return searchCommand.getDepartmentsName();
    }

    public List<String> getLectorsName(){
        return searchCommand.getLectorsName();
    }

    public List<String> getDegree(){
        return searchCommand.getDegree();
    }
}
