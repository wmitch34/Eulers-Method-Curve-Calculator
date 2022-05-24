import java.lang.*;
import java.util.*;

import javafx.event.EventDispatchChain;

public class Eulers{

    // only y vals are needed to answer the question, but by saving x vals,
    // i have the ability to later plot points on a graph using this data.
    private static ArrayList<Double> y_vals = new ArrayList<>();
    private static ArrayList<Double> x_vals = new ArrayList<>();

    private static Double y_prime(double x, double y, double h){
        // this function will need to change depending on what your vale for dy/dx is
        // I pass in the x val because some functions may use the value
        return  (y + (.04 * (292.0 - y)) * h);
    }

    private static void eulers(Double y,Double  x, Double h, double target, double step){
        // Base case
        if(step == target){
            return;
        }

        y = y_prime(x, y, h);
        x_vals.add(x);
        y_vals.add(y);
        step += h;
        // most simple way to fix binary rounding error on Doubles(bit shift does not work):
        step = Math.round(step * 10000000) / 10000000.0;
        eulers(y, x + h, h, target, step);
    }
    public static void main(String args[]){
        // if this program requires the user to change the above function to run,
        // You may as well hard code in the input values as well,
        // nontheless, here is a command line user interface for getting values
        // y_0 = f(x)
        // x_0 is the initial value 
        // target is the end of the interval
        // h is the increment value 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter y_0");
        Double y_0 = sc.nextDouble();
        System.out.println("Enter x_0");
        Double x_0 = sc.nextDouble();
        System.out.println("Enter h");
        Double h = sc.nextDouble();
        System.out.println("Enter target");
        Double target = sc.nextDouble();
        sc.close();

        eulers(y_0, x_0, h, target, 0.0000000000);

        int i = 0;
        for(Double val : y_vals){
            // for debug purposes, just wanted to make sure I got all 0 -299 values between 0 and 30:
            // System.out.println(i);
            System.out.println(val);
            i++;
        }

    }
}