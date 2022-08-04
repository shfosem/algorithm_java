package algorithm_java.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11659 {

    // 11659 구간 합 구하기 4
    // 틀린 이유 : 매 인덱스마다 부분합을 따로 구해서 시간초과 -> 아예 부분합들로 배열을 저장해서 index 계산해서 빼주었다.
    public static void main(String[] args) throws IOException {
       //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수의 개수 N, 합을 구해야 하는 횟수 M
        int n= Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        
        //각 인덱스까지의 누적합을 저장하기 위한 배열 arr 과 누적합을 구하기 위한 변수 partSum
        ArrayList<Integer> arr = new ArrayList<>();
        int partSum=0;
        for(int i=0 ;i <n;i++){
            int x = Integer.parseInt(st.nextToken());
            partSum+=x;
            arr.add(partSum);
        }

        //for output
        StringBuilder result =new StringBuilder();
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken()), end= Integer.parseInt(st.nextToken());
            if(start==1){ // 1부터 시작했을 경우 배열에 저장된 값 그대로 반환
                result.append(arr.get(end-1));
            }
            else { //그 외에는 start 이전까지의 누적합 빼기
                result.append(arr.get(end-1) - arr.get(start-2));
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}
