package algorithm_java.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//P24416 피보나치 수 1

public class P24416 {
    //for output
    static int rslt1=0;
    static int rslt2=0;
    // 문제에서 의사코드로 제시한 function1
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

    // 문제에서 의사코드로 제시한 function2
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

        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 주어지는 입력 n (5<=n<=40)
        int n = Integer.parseInt(st.nextToken());

        f[1]=1;
        f[2]=1;
        //주어진 입력 n를 매개변수로 각 함수 호출
        fib(n);
        fibonacci(n);

        //for output
        StringBuilder sb = new StringBuilder();
        sb.append(rslt1);
        sb.append(" ");
        sb.append(rslt2);
        System.out.println(sb);


    }
}