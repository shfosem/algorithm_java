package algorithm_java.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P24416 {
    static int rslt1=0;
    static int rslt2=0;
    static int fib(int n){
        if(n==1 || n==2)
        {
            rslt1++;
            return 1;
        }
        else
            return fib(n-1)+fib(n-2);
    }

    static int[] f = new int[41];

    static int fibonacci(int n){
        if(f[n]!=0){
            return f[n];
        }
        else {
            rslt2++;
            return f[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        f[1]=1;
        f[2]=1;

        fib(n);
        fibonacci(n);

        StringBuilder sb = new StringBuilder();
        sb.append(rslt1);
        sb.append(" ");
        sb.append(rslt2);
        System.out.println(sb);


    }
}