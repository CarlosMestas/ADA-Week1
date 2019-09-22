/**
 * This class will be help us to calculate mathematical problems through numerical methods
 * One of those methods is Bisection Method
 * @author Carlos A. Mestas Escarcena
 * @ 
 */
public class NRoot{

    public static void main(String [] args){
        NRoot o = new NRoot();
        double ansBisection = o.bisect(0.9 , 1.0, 0d, 1, 0.91001);
        System.out.println("\nAnswer: " + ansBisection);
    }

    /**
     * This recursive method will help us to calculate the approximate root 
     * @param _xL Left point of the inverval
     * @param _xR Right point of the interval
     * @param _xM Middle Point
     * @param _ite Number of iterations
     * @param _ans Answer to witch we approach
     * @return Recursive method or approximate answer
     */
    public double bisect(double _xL, double _xR, double _xM, int _ite, double _ans){
        double eA , eT;
        double xMtemp = _xM;
        _xM = (_xL + _xR) / 2;
        eA = (_ite == 1) ? 100 : error(xMtemp , _xM);
        eT = error( _xM , _ans);
        if(eA < eT)
            return xMtemp;
        if(Math.signum(function(_xL)) != function(_xR))
            _xR = _xM;
        else
            _xL = _xM;
        _ite++;
        return bisect(_xL , _xR , _xM, _ite , _ans);
    }
 
    /**
     * Method where we define our function respecto to x
     * @param _x Value of x
     * @return Value of the function with the value of x
     */
    public double function(double _x){
        double f;
        f = 3 * Math.pow( _x , 2) - Math.pow( Math.E , _x);
        return f;
    }
    
    /**
     * Method to calculate the error
     * It depends on the type of error we are going to calculate
     * Approximate error or true error
     * @param _a Previous value or actual value
     * @param _b Actual value or expected value
     * @return 
     */
    public double error(double _a, double _b){
        double e;
        e = Math.abs((_a - _b) / _b);
        return e * 100;
    }

}
