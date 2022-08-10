package algorithm_java.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10986 {

    //시간초과 날거 같은데 ㅋㅋ.. => 진짜 시간 초과 났었음
    // 나머지가 같은것끼리 뺄셈을 한다는 풀이방법이 어려웠음

    //10986
    static int n;
    static int m;
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        //정수의 개수 N 나누는 수 M
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = new int[m];
        int sum=0;
        long result = 0;

        st=new StringTokenizer(br.readLine());
        //나머지연산을 해서 나머지만 따로 저장
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            sum+=a;
            sum%=m;
            cnt[sum]+=1;
        }
        //자체로 나누어 떨어지면 +1
        result += cnt[0];
        // 각 나머지별 수에 대해서  kC2
        for(int i = 0; i<m; i++){
            result+=(long) cnt[i]*(cnt[i]-1)/2;
        }

        //for output
        System.out.println(result);
    }
}