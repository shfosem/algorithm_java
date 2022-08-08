package algorithm_java.HelloWorld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3003 {

    public static void main(String[] args) throws IOException {
        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 총 필요한 말의 개수 배열로 선언
        int[] result = {1,1,2,2,2,8};

        //for output
        StringBuilder sb = new StringBuilder();
        // 각 입력마다 뺄셈을 통해 부족한 말의 수 저장
        for(int i=0;i< result.length;i++){
            int cnt = Integer.parseInt(st.nextToken());
            result[i]-=cnt;
            sb.append(result[i]);
            sb.append(" ");
        }
        //output
        System.out.println(sb);

    }
}