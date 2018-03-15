package console;

import command.*;
import constants.Constants;
import model.Departments;
import model.User;
import org.apache.log4j.Logger;

import java.util.*;

public class ConsoleUniversity {
    private final static Logger LOG = Logger.getLogger(ConsoleUniversity.class);
    private User user;
    private Scanner scan;

    public ConsoleUniversity() {
        this.user = new User(new DepartmentHeadCommand(), new AverageSalaryCommand(), new DepartmentSummaryCommand(), new EmployeeCountCommand(), new SearchCommands());
        this.scan = new Scanner(System.in);
    }

    public void run(){
        mainMenu();
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
                case "search":
                    search();
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
            user.getDepartmentAverageSalary(inputDepartment());
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
            user.getDepartmentEmployeeCount(inputDepartment());
        }catch (NoSuchElementException e){
            LOG.info("Unknown department, please input one of department from list");
            getEmployeeCount();
        }
    }

    private void search(){
        LOG.info("please input search criterion like template name of table(-dep, -lec, -deg) and search criterion for example(-dep ivan)");
        String value = scan.nextLine();
        String tableValue = value.substring(0,4);
        if(tableValue.equalsIgnoreCase("-dep")){
            List<String> departments = searchByDepartments(value);
            if(departments.isEmpty())
                LOG.info("Don't found any department");
            else
                LOG.info("we found this departments in data base");
                departments.forEach(dep->LOG.info(dep+"\n"));
        }else if(tableValue.equalsIgnoreCase("-lec")){
            List<String> lectors = searchByLectors(value);
            if(lectors.isEmpty())
                LOG.info("Don't found any department");
            else
                LOG.info("we found this lectors in data base");
                lectors.forEach(lec ->LOG.info(lec+"\n"));
        }else if(tableValue.equalsIgnoreCase("-lec"))
        {
            List<String> degree = searchByDegree(value);
            if(degree.isEmpty())
                LOG.info("Don't found any department");
            else
                LOG.info("we found this degree in data base");
                degree.forEach(lec ->LOG.info(lec+"\n"));
        }else{
            LOG.info("invalid template");
            search();
        }
    }

    private List<String> searchByDepartments(String value){
        List<String> foundDepartments = new ArrayList<>();
        user.getDepartmentsName().forEach(dep -> {
            if (dep.contains(value.substring(5, value.length())))
                foundDepartments.add(dep);
        });
        return foundDepartments;
    }

    private List<String> searchByLectors(String value){
        List<String> foundLectors = new ArrayList<>();
        user.getLectorsName().forEach(lec -> {
            if (lec.contains(value.substring(5, value.length())))
                foundLectors.add(lec);
        });
        return foundLectors;
    }

    private List<String> searchByDegree(String value){
        List<String> foundDegree = new ArrayList<>();
        user.getLectorsName().forEach(deg -> {
            if (deg.contains(value.substring(5, value.length())))
                foundDegree.add(deg);
        });
        return foundDegree;
    }
}
