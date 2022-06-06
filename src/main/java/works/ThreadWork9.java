package works;

import java.util.Scanner;

public class ThreadWork9 {
    public static void runOne() {
        var arg = new argument();
        new tab(arg);
        new inf(arg);
    }

    public static void runTwo() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        int i;
        double x = 2;
        System.out.println("Enter an array separated by commas: ");
        var str = scanner.nextLine().split(",");
        var mas1 = new double[n+1];
        for (i = 0; i<n;i++)
        {
            mas1[i] = Double.parseDouble(str[i].trim()); //trim удаляет пробелы
        }

        System.out.println("Input array:");
        for (i = 0; i < n; i++)
            System.out.print(mas1[i]+", ");

        System.out.println("\nEnter the element you are looking for: ");
        x = scanner.nextDouble();
        scanner.close();
        for (i = 0, mas1[n] = x; mas1[i] != x; i++) { }

        if (i==n)
            System.out.println("Array does not contain desired value");
        else
            System.out.println ("Found element in array with number: "+i);
    }
}

class argument
{
    double x,y;
}

class tab extends Thread{

    argument arg;
    tab(argument arg){
        super("New thread");
        this.arg = arg;
        start();
    }

    public void run() {
        synchronized (arg){ //заблокировать доступ к методу или части кода, если его уже использует другой поток
            System.out.println("Function tabulation: ");
            final double pi4 = 0.7853981633974483;
            double a = 2.857,
                    b = 3.25,
                    k = 2,
                    h = 0.5;
            arg.x = -1;
            arg.y =0;
            System.out.println("\tX\t|\t\tZ");
            while (arg.x <= k) {
                if (arg.x > pi4)
                    arg.y = a * Math.sin(arg.x) - b * arg.x;
                else if (0 <= arg.x || arg.x >= pi4)
                    arg.y = a * Math.exp(-arg.x) - arg.x;
                else if (arg.x < 0)
                    arg.y = Math.pow(arg.x, 3) + Math.pow(arg.x, 2) + Math.exp(arg.x) + 1.5;

                System.out.printf("%.2f\t|\t%.3f\n", arg.x, arg.y);
                arg.x += h;
            }
        }
    }
}

class inf extends Thread{
    final argument arg;
    inf(argument arg){
        super("New stream1");
        this.arg = arg;
        start();
    }

    public void run() {
        synchronized (arg){
            System.out.println("\nEndless rows: ");
            final double e = 0.00001;
            double xn = 0.1,
                    xk = 1,
                    h = 0.1,
                    T=1;
            int n = 1;
            arg.x = xn;
            arg.y = 0;
            System.out.println("\tX\t|\t\tZ");

            while (arg.x <= xk && Math.abs(T) > e)
            {
                arg.y += T;
                T *= ((arg.x*Math.pow((n+1),2)+arg.x)*Math.pow(2,n))/
                        ((n+1)*Math.pow(2,(n+1))*((Math.pow(n,2)+1)*Math.pow(arg.x,2)));
                System.out.printf("%.2f\t|\t%.3f\n",arg.x,arg.y);
                arg.x+=h;
                n++;
            }
        }
    }
}

