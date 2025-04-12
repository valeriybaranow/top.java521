package lessons.Generics;

public class Pair <T,U>{
    private T variableOne;
    private U variableTwo;

    public Pair(T variableOne, U variableTwo) {
        this.variableOne = variableOne;
        this.variableTwo = variableTwo;
    }

    public T getVariableOne() {
        return variableOne;
    }

    public void setVariableOne(T variableOne) {
        this.variableOne = variableOne;
    }

    public U getVariableTwo() {
        return variableTwo;
    }

    public void setVariableTwo(U variableTwo) {
        this.variableTwo = variableTwo;
    }

}
