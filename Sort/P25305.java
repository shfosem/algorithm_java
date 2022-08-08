package algorithm_java.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P25305 {

    //25305
    public static void main(String[] args) throws IOException {
        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 응시자 수 N, 받는 사람 k
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //점수를 담기 위한 배열 선언
        int[] score = new int[n];

        st=new StringTokenizer(br.readLine());
        //내장된 sort함수가 오름차순으로 정렬하기 때문에 점수를 음수로 저장
        for(int i = 0 ;i<n; i++){
            score[i]=Integer.parseInt(st.nextToken())*-1;
        }

        //정렬(내장함수)
        Arrays.sort(score);

        //음수로 점수를 저장했으므로 꺼낼 때도 * -1 output
        System.out.println(score[k-1]*-1);


    }
}