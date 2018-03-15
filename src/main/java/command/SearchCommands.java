package command;

import dao.UniversityDAO;
import dao.implementation.University;
import java.util.List;

public class SearchCommands implements SearchCommand {
    private UniversityDAO university;

    public SearchCommands() {
        this.university = new University();
    }

    @Override
    public List<String> getDepartmentsName() {
        return university.getDepartments();
    }

    @Override
    public List<String> getLectorsName() {
        return university.getLectors();
    }

    @Override
    public List<String> getDegree() {
        return university.getDegree();
    }
}
