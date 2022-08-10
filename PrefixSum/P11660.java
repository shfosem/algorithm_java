package algorithm_java.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11660 {
    //11660
    // 어려웠던 점 : 2차원 배열이여서 처음에는 헷갈렸지만, 침착하게 누적 합 계산해서 연산해주니 정답처리 받았음
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //표의 크기 N, 합을 구해야 하는 횟수 M
        int n,m;
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        // 누적합을 저장할 2차원 배열, 같은 x 값을 갖는 것 끼리 누적합을 구함
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            int part = 0;
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                part+=Integer.parseInt(st.nextToken());
                arr[i][j]=part;
            }
        }
        //for output
        StringBuilder sb = new StringBuilder();
        int x1, x2, y1, y2;
        for(int i=0; i<m; i++){
            int result = 0;
            st=new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            //맨처음이 시작이 아니라면, (뺄 구간이 있다면)
            if(y1>1){
                for(int j = x1; j<=x2; j++) {
                    result += arr[j - 1][y2 - 1];
                    result -= arr[j - 1][y1 - 2];
                }
            }
            else{
                for(int j = x1; j<=x2; j++){
                    result+=arr[j-1][y2-1];
                }

            }
            sb.append(result);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
