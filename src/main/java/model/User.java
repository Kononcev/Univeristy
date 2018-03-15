package model;

import command.Command;

public class User {
    private Command getHead;
    private Command getAverageSalary;
    private Command getDepartmentSummary;
    private Command getEmployeeCount;

    public User(Command getHead, Command getAverageSalary, Command getDepartmentSummary, Command getEmployeeCount) {
        this.getHead = getHead;
        this.getAverageSalary = getAverageSalary;
        this.getDepartmentSummary = getDepartmentSummary;
        this.getEmployeeCount = getEmployeeCount;
    }

    public void getDepartmentHead(Departments department) {
        getHead.execute(department);
    }

    public void getDepartmentAvarageSalary(Departments department) {
        getAverageSalary.execute(department);
    }

    public void getDepartmentSummary(Departments department) {
        getDepartmentSummary.execute(department);
    }

    public void getDepartmentEployeeCount(Departments department) {
        getEmployeeCount.execute(department);
    }
}
