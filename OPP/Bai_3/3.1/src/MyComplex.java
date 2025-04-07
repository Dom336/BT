public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;
    
    public MyComplex() {
    }
    
    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    
    public double getReal() {
        return real;
    }
    
    public void setReal(double real) {
        this.real = real;
    }
    
    public double getImag() {
        return imag;
    }
    
    public void setImag(double imag) {
        this.imag = imag;
    }
    
    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    
    public String toString() {
        if (imag < 0) {
            return "(" + real + " - " + Math.abs(imag) + "i)";
        } else {
            return "(" + real + " + " + imag + "i)";
        }
    }
    
    public boolean isReal() {
        return (imag == 0);
    }
    
    public boolean isImaginary() {
        return (real == 0);
    }
    
    public boolean equals(double real, double imag) {
        return (this.real == real && this.imag == imag);
    }
    
    public boolean equals(MyComplex another) {
        return (this.real == another.real && this.imag == another.imag);
    }
    
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }
    
    public double argument() {
        return Math.atan2(imag, real);
    }
    
    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }
    
    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.imag + right.imag);
    }
    
    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }
    
    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.real, this.imag - right.imag);
    }
    
    public MyComplex multiply(MyComplex right) {
        double tempReal = (this.real * right.real) - (this.imag * right.imag);
        double tempImag = (this.real * right.imag) + (this.imag * right.real);
        this.real = tempReal;
        this.imag = tempImag;
        return this;
    }
    
    public MyComplex divide(MyComplex right) {
        double denominator = right.real * right.real + right.imag * right.imag;
        double tempReal = (this.real * right.real + this.imag * right.imag) / denominator;
        double tempImag = (this.imag * right.real - this.real * right.imag) / denominator;
        this.real = tempReal;
        this.imag = tempImag;
        return this;
    }
    
    public MyComplex conjugate() {
        this.imag = -this.imag;
        return this;
    }
}