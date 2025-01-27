class Solution {
    public double myPow(double x, int n) {
        // If n is 0, any number raised to the power 0 is 1
        if (n == 0) {
            return 1.0;
        }
        
        // Handle the case where n is negative
        if (n < 0) {
            x = 1 / x;  // Take the reciprocal of x
            n = -n;     // Make n positive
        }
        
        // Recursive function for exponentiation by squaring
        return power(x, n);
    }
    
    private double power(double x, int n) {
        if (n == 0) {
            return 1.0;  // Base case: x^0 is 1
        }
        
        double half = power(x, n / 2);  // Compute x^(n/2) recursively
        if (n % 2 == 0) {
            return half * half;  // If n is even: x^n = (x^(n/2))^2
        } else {
            return half * half * x;  // If n is odd: x^n = (x^(n/2))^2 * x
        }
    }
}
