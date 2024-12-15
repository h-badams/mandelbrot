public class Complex {

    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }
    public double getImag() {
        return imag;
    }

    public Complex add(Complex other) {
        double newReal = this.getReal() + other.getReal();
        double newImag = this.getImag() + other.getImag();

        return new Complex(newReal, newImag);
    }

    public void scale(double d) {
        real *= d;
        imag *= d;
    }

    public Complex multiply(Complex other) {
        double newReal = this.getReal() * other.getReal() - this.getImag() * other.getImag();
        double newImag = this.getReal() * other.getImag() + other.getReal() * this.getImag();

        return new Complex(newReal, newImag);
    }

    public String toString() {
        if(this.getImag() >= 0) {
            return this.getReal() + "+" + this.getImag() + "i";
        } else {
            return "" + this.getReal() + this.getImag() + "i";
        }
    }
}
