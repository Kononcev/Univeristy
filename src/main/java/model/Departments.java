package model;

import java.util.stream.Stream;

public enum Departments {
    BUSINESS("Business"), CHEMISTRY("Chemistry"), CRIMINOLOGY("Criminology"), ARTS("Arts"), ENGLISH("English"), HISTORY("History"), MATHEMATICS("Mathematics");

    private String name;

    Departments(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Stream<Departments> stream() {
        return Stream.of(Departments.values());
    }
}
