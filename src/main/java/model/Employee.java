package model;

public class Employee {
    private Integer id;
    private Integer departmentId;
    private String name;
    private String surname;
    private Integer salary;
    private Integer degreeId;

    public Employee(Integer id, Integer departmentId, String name, String surname, Integer salary, Integer degreeId) {
        this.id = id;
        this.departmentId = departmentId;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.degreeId = degreeId;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }
}
