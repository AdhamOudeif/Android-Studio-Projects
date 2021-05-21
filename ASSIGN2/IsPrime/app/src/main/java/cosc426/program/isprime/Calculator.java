package cosc426.program.isprime;

public class Calculator {
    private int prime;

    public void setPrime(int prime) {
        this.prime = prime;
    }
    public String getOutput(){

        boolean isPrime;
        String isitPrime;
        if (prime <= 1)
            return isitPrime = "False";

            // Check from 2 to n-1
            for (int i = 2; i < prime; i++)
                if (prime % i == 0)
                    return isitPrime = "False";

        isPrime = true;
        return isitPrime = "True";
    }
}

