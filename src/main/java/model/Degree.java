package model;

public enum Degree {

    ASSISTANT(1), ASSOCIATE_PROFFESSOR(2), PROFFESSOR(3);
    private Integer id;

    Degree(Integer id){
        this.id = id;
    }

    public Integer id(){
        return id;
    }
}
