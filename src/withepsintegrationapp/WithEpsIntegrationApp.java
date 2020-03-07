/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withepsintegrationapp;


public class WithEpsIntegrationApp {


    public static void main(String[] args) {
        int sizeOfLineSegments = 10;
        
        double a = 0.0;
        double b = 4.0;
        
        double eps = 0.00000001;
        
        int i = 1;
        double fin_integr = 0;
        while(Math.abs(integ(i, a, b) - integ(2*i, a, b))/3 > eps){
            fin_integr = integ(i, a, b);
            i *= 2;
        }
        
        System.out.println("Function: 1/(1+sqrt(x))");
        System.out.println("[" + a + "]" + "[" + b +"]");
        System.out.println("n = " + sizeOfLineSegments);
        System.out.println("eps = " + eps);
        System.out.println("Integration with a given accuracy's method");
        System.out.println("****************");
        System.out.println("Integral = " + fin_integr);
        System.out.println("Num of steps = " + i);
    }
    
    static double integ(int n, double a1, double b1){
        int sizeOfPoints = n + 1;
        
        double h = (b1 - a1) / n;
        
        double[] x = new double[sizeOfPoints];
        x[0] = a1;
        x[sizeOfPoints - 1] = b1;
        for(int i = 1; i < sizeOfPoints - 1; i++)
            x[i] = x[0] + i*h;
        
        double[] y = new double[sizeOfPoints];
        for(int i = 0; i < sizeOfPoints; i++)
            y[i] = 1 / (1 + Math.sqrt(x[i]));
           
        double integral = 0.0;
        for(int i = 0; i < sizeOfPoints; i++)
            if(i == 0 || i == sizeOfPoints - 1)
                integral += y[i] / 2;
            else
                integral += y[i];
        integral *= h;
        return integral;
    }
}
