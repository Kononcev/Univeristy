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

    public void run() {
        mainMenu();
    }

    private void mainMenu() {
        LOG.info(Constants.GREATINGS);
        while (true) {
            LOG.info(Constants.INPUT_VALUE);
            String value = scan.nextLine();
            switch (value) {
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
                    LOG.info(Constants.UNKNOWN_COMMAND);
            }
        }
    }

    private void helpMenu() {
        LOG.info(Constants.HELP_MENU);
    }

    private Departments inputDepartment() {
        LOG.info("please input department name");
        String value = scan.nextLine();
        Departments department;
        Optional<Departments> result = Departments.stream().filter(dep -> dep.getName().equalsIgnoreCase(value)).findFirst();
        if (result.isPresent())
            return department = result.get();
        else
            Departments.stream().forEach(dep -> LOG.info(dep.getName()));
        throw new NoSuchElementException();
    }

    private void getDepartmentHead() {
        try {
            LOG.info(Constants.SHOW_HEAD_OF_DEPARTMENT);
            user.getDepartmentHead(inputDepartment());
        } catch (NoSuchElementException e) {
            LOG.info(Constants.UNKNOWN_SEARCH_VALUE);
            getDepartmentHead();
        }
    }

    private void getAverageSalary() {
        try {
            LOG.info(Constants.SHOW_AVERAGE_SALARY);
            user.getDepartmentAverageSalary(inputDepartment());
        } catch (NoSuchElementException e) {
            LOG.info(Constants.UNKNOWN_SEARCH_VALUE);
            getAverageSalary();
        }
    }

    private void getDepartmentSummary() {
        try {
            LOG.info(Constants.SHOW_DEPARTMENT_STATISTICS);
            user.getDepartmentSummary(inputDepartment());
        } catch (NoSuchElementException e) {
            LOG.info(Constants.UNKNOWN_SEARCH_VALUE);
            getDepartmentSummary();
        }
    }

    private void getEmployeeCount() {
        try {
            LOG.info(Constants.SHOW_EMPLOYEE_COUNT_OF_DEPARTMENT);
            user.getDepartmentEmployeeCount(inputDepartment());
        } catch (NoSuchElementException e) {
            LOG.info(Constants.UNKNOWN_SEARCH_VALUE);
            getEmployeeCount();
        }
    }

    private void search() {
        LOG.info(Constants.SEARCH_HELP);
        String value = scan.nextLine();
        String tableValue = value.substring(0, 4);
        if (value.length() > 4) {
            if (tableValue.equalsIgnoreCase("-dep")) {
                List<String> departments = searchByDepartments(value);
                if (departments.isEmpty())
                    LOG.info(Constants.NO_SEARCH_RESULT);
                else
                    LOG.info(Constants.SEARCH_RESULTS);
                departments.forEach(dep -> LOG.info(dep + "\n"));
            } else if (tableValue.equalsIgnoreCase("-lec")) {
                List<String> lectors = searchByLectors(value);
                if (lectors.isEmpty())
                    LOG.info(Constants.NO_SEARCH_RESULT);
                else
                    LOG.info(Constants.SEARCH_RESULTS);
                lectors.forEach(lec -> LOG.info(lec + "\n"));
            } else if (tableValue.equalsIgnoreCase("-deg")) {
                List<String> degree = searchByDegree(value);
                if (degree.isEmpty())
                    LOG.info(Constants.NO_SEARCH_RESULT);
                else
                    LOG.info(Constants.SEARCH_RESULTS);
                degree.forEach(lec -> LOG.info(lec + "\n"));
            } else {
                LOG.info(Constants.INVALID_TEMPLATE);
                search();
            }
        }else {
            LOG.info(Constants.INVALID_TEMPLATE);
            search();
        }
    }

    private List<String> searchByDepartments(String value) {
        List<String> foundDepartments = new ArrayList<>();
        user.getDepartmentsName().forEach(dep -> {
            if (dep.contains(value.substring(5, value.length())))
                foundDepartments.add(dep);
        });
        return foundDepartments;
    }

    private List<String> searchByLectors(String value) {
        List<String> foundLectors = new ArrayList<>();
        user.getLectorsName().forEach(lec -> {
            if (lec.contains(value.substring(5, value.length())))
                foundLectors.add(lec);
        });
        return foundLectors;
    }

    private List<String> searchByDegree(String value) {
        List<String> foundDegree = new ArrayList<>();
        user.getDegree().forEach(deg -> {
            if (deg.contains(value.substring(5, value.length())))
                foundDegree.add(deg);
        });
        return foundDegree;
    }
}
