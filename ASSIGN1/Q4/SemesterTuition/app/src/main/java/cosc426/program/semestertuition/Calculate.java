package cosc426.program.semestertuition;

//calculations

public class Calculate {
    private int value;
    //constructor
    public Calculate(int credits, double state, int grad, int otherVal){
        int creditsCost = (int)(grad * state);
        int tuition = credits * creditsCost;
        value = tuition+otherVal;
    }

    public int getValue() {
        return value;
    }
}