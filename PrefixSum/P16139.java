package algorithm_java.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 처음에는 문제를 제대로 안읽어서 50점으로만 맞춤
// 어려웠던 점 : Arrays.copyOf 사용법을 제대로 익히지 않아서, 런타임오류가 났었다.
public class P16139 {

    //char형을 int형으로 바꿔 index로 접근하기 위한 상수 선언
    static final int convert = 97;
    // 누적합을 저장할 2차원 배열 (0으로 초기화)
    static int[][] arr = new int[200001][26];
    //16139
    public static void main(String[] args) throws IOException {

        //For input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //문자열 S
        String s;
        s=br.readLine();
        // 문자열 S의 각 idx마다 알파벳 간 누적합 계산하여 2차원 배열에 저장
        for(int i=0; i<s.length();i++){
            if (i != 0) {
                arr[i] = Arrays.copyOf(arr[i-1],arr[i-1].length);
            }
            arr[i][s.charAt(i)-97]++;
        }

        st= new StringTokenizer(br.readLine());
        // 질문의 수 Q
        int q = Integer.parseInt(st.nextToken());

        //For output
        StringBuilder sb= new StringBuilder();
        int cnt;
        //소문자 알파, l, r 을 받아서 답 계산
        for(int i=0 ;i<q;i++){
            st=new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int idx = c.charAt(0)-97;

          /*
          50점 짜리 매번 누적합을 계산하던 방식
          char[] part = new char[200000];
             s.getChars(l,r+1,part,0);

            int cnt =0;
            for(char b :part){
                if(b == c.charAt(0))
                    cnt++;
            }*/

            if(l==0){
                cnt=arr[r][idx];
            }
            else{
                cnt=arr[r][idx]-arr[l-1][idx];
            }
            sb.append(cnt);
            sb.append("\n");
        }
        //output
        System.out.println(sb);
    }
}