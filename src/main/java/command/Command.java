package command;

import model.Departments;
import org.apache.log4j.Logger;

public interface Command {
    Logger LOG = Logger.getLogger(Command.class);
    void execute(Departments department);
}
