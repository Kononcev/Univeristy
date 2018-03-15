package constants;

import java.text.DecimalFormat;

public interface Constants {
    String DEPARTMENT_HEAD_QUERY = "SELECT department.department_name, lectors.name, lectors.surname FROM department\n" +
            "INNER JOIN lectors ON department.department_head=lectors.lectors_id\n" +
            "WHERE department_name=\"%s\";";

    String DEPARTMENT_STATISTICS_QUERY = "SELECT degree, COUNT(*) AS degree_count FROM degree\n" +
            "JOIN lectors ON degree.degree_id=lectors.degree_id\n" +
            "JOIN department ON lectors.department_id=department.department_id\n" +
            "WHERE department_name=\"%s\"\n" +
            "GROUP BY degree;";

    String AVERAGE_SALARY_FOR_DEPARTMENT_QUERY = "SELECT department_name, AVG(lectors.salary) FROM lectors\n" +
            "JOIN department ON lectors.department_id=department.department_id\n" +
            "WHERE department_name=\"%s\";";

    String EMPLOYEE_COUNT_OF_DEPARTMENT_QUERY = "SELECT department_name, COUNT(*) AS employee_count FROM lectors\n" +
            "JOIN department ON lectors.department_id=department.department_id\n" +
            "WHERE department_name=\"%s\";";

    String GET_DEPARTMENTS_QUERY = "SELECT department_name FROM university.department;";

    String GET_LECTORS_QUERY = "SELECT name, surname FROM university.lectors;";

    String GET_DEGREE_QUERY = "SELECT degree FROM university.degree;";

    String HELP_MENU = "\n1 - get head of department\n2 - get employee count of department\n3 - get department employee statistics\n4 - get average salary of department\nsearch - global search by template\nhelp - open help menu\nquit - exit from application";

    String INPUT_VALUE = "please input command";

    DecimalFormat DOUBLE_WITH_TWO_DIGITS = new DecimalFormat("0.00");

}
