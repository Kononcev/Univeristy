import console.ConsoleUniversity;

public class Main {
    private ConsoleUniversity console;

    public Main(ConsoleUniversity console) {
        this.console = console;
    }

    public static void main(String[] args) {
        Main main = new Main(new ConsoleUniversity());
        main.console.run();
    }
}
