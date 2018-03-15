package model;

public class Department {
    private Integer departmentId;
    private String departmentHead;
    private String departmentName;

    public Department(Integer departmentId, String departmentHead, String departmentName) {
        this.departmentId = departmentId;
        this.departmentHead = departmentHead;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
