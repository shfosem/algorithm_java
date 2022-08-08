package algorithm_java.Repetitive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P25304 {


    public static void main(String[] args) throws IOException {
        //25304
        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //금액 X
        int x = Integer.parseInt(st.nextToken());

        //물건 종류의 수 N
        st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 총 물건 금액의 합을 저장하기 위한 변수 total
        int total = 0;
        //반복하여 물건 가격, 수 를 입력받아 total에 더해줌
        for(int i = 0 ; i<n; i++){
            st= new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            total += price*cnt;
        }

        //X와 total 비교
        if(x==total)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}