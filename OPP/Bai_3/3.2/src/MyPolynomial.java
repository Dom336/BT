public class MyPolynomial {
    private double[] coeffs;
    
    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }
    
    public int getDegree() {
        return coeffs.length - 1;
    }
    
    public String toString() {
        if (coeffs.length == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (sb.length() > 0 && coeffs[i] > 0) {
                    sb.append("+");
                }
                
                if (i == 0) {
                    sb.append(coeffs[i]);
                } else if (i == 1) {
                    if (coeffs[i] == 1) {
                        sb.append("x");
                    } else if (coeffs[i] == -1) {
                        sb.append("-x");
                    } else {
                        sb.append(coeffs[i]).append("x");
                    }
                } else {
                    if (coeffs[i] == 1) {
                        sb.append("x^").append(i);
                    } else if (coeffs[i] == -1) {
                        sb.append("-x^").append(i);
                    } else {
                        sb.append(coeffs[i]).append("x^").append(i);
                    }
                }
            }
        }
        
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
    
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }
    
    public MyPolynomial add(MyPolynomial right) {
        int maxLength = Math.max(coeffs.length, right.coeffs.length);
        double[] resultCoeffs = new double[maxLength];
        
        for (int i = 0; i < coeffs.length; i++) {
            resultCoeffs[i] += coeffs[i];
        }
        
        for (int i = 0; i < right.coeffs.length; i++) {
            resultCoeffs[i] += right.coeffs[i];
        }
        
        return new MyPolynomial(resultCoeffs);
    }
    
    public MyPolynomial multiply(MyPolynomial right) {
        int resultDegree = this.getDegree() + right.getDegree();
        double[] resultCoeffs = new double[resultDegree + 1];
        
        for (int i = 0; i < coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                resultCoeffs[i + j] += coeffs[i] * right.coeffs[j];
            }
        }
        
        return new MyPolynomial(resultCoeffs);
    }
}