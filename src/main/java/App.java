import command.AverageSalaryCommand;
import command.DepartmentHeadCommand;
import command.DepartmentSummaryCommand;
import command.EmployeeCountCommand;
import constants.Constants;
import model.Departments;
import model.User;
import org.apache.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class App {
    private final static Logger LOG = Logger.getLogger(App.class);
    private User user;
    private Scanner scan;

    public App() {
        this.user = new User(new DepartmentHeadCommand(), new AverageSalaryCommand(), new DepartmentSummaryCommand(), new EmployeeCountCommand());
        this.scan = new Scanner(System.in);
    }

    public static void main(String[] args) {
        App app = new App();
        app.mainMenu();
    }

    private void mainMenu(){
        LOG.info("Hello you are in main menu, type (help) for more information");
        while(true){
            LOG.info(Constants.INPUT_VALUE);
            String value = scan.nextLine();
            switch(value){
                case "help":
                    helpMenu();
                    break;
                case "1":
                    getDepartmentHead();
                    break;
                case "2":
                    getEmployeeCount();
                    break;
                case "3":
                    getDepartmentSummary();
                    break;
                case "4":
                    getAverageSalary();
                    break;
                case "quit":
                    System.exit(0);
                default:
                    LOG.info("Unknown command, for more info type (help)");
            }
        }
    }

    private void helpMenu(){
        LOG.info(Constants.HELP_MENU);
    }

    private Departments inputDepartment(){
        LOG.info("please input department name");
        String value = scan.nextLine();
        Departments department;
        Optional<Departments> result = Departments.stream().filter(dep->dep.getName().equalsIgnoreCase(value)).findFirst();
        if(result.isPresent())
            return department = result.get();
        else
            Departments.stream().forEach(dep->LOG.info(dep.getName()));
            throw new NoSuchElementException();
    }

    private void getDepartmentHead(){
        try {
            LOG.info("Show head of department");
            user.getDepartmentHead(inputDepartment());
        }catch (NoSuchElementException e){
            LOG.info("Unknown department, please input one of department from list");
            getDepartmentHead();
        }
    }

    private void getAverageSalary(){
        try {
            LOG.info("Show the average salary for department");
            user.getDepartmentAvarageSalary(inputDepartment());
        }catch (NoSuchElementException e){
            LOG.info("Unknown department, please input one of department from list");
            getAverageSalary();
        }
    }

    private void getDepartmentSummary(){
        try {
            LOG.info("Show departments statistic of employee");
            user.getDepartmentSummary(inputDepartment());
        }catch (NoSuchElementException e){
            LOG.info("Unknown department, please input one of department from list");
            getDepartmentSummary();
        }
    }

    private void getEmployeeCount(){
        try {
            LOG.info("Show count of employee for department");
            user.getDepartmentEployeeCount(inputDepartment());
        }catch (NoSuchElementException e){
            LOG.info("Unknown department, please input one of department from list");
            getEmployeeCount();
        }
    }
}
