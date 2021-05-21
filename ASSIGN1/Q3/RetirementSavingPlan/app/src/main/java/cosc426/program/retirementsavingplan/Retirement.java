package cosc426.program.retirementsavingplan;

public class Retirement {

    private int amount;

    //Function calculation
    public Retirement(float p, float a, float n, float r){

        //Convert rate
        r =(float)(r/100.0);
        //Calc
        amount = (int)(((p+(a/r))*((float)Math.pow((1.0+r),(double)n))-(a/r)));
    }

    public int getAmount() {
        return amount;
    }
}
