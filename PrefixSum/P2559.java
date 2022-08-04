package algorithm_java.PrefixSum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2559 {

    //2559 수열
    //틀린 이유 : 1.메모리 초과 2. 마지막 처리 미흡
    // 메모리 초과 되어서 나는 큐를 사용했는데, 다른 사람들의 풀이를 보니 그냥 ArrayList 말고, int형 배열을 써서 쉽게 풀이한 사람들도 확인할 수 있었다.
    public static void main(String[] args) throws IOException {
        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //온도를 측정한 전체 날짜 수 N, 합을 구하기 위한 연속적인 날짜의 수
        int n = Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());

        //기존에 누적합을 저장하는 배열을 만들었으나 메모리 초과가 나서, 큐를 활용하기로 함
        Queue<Integer> queue = new LinkedList<>();
        st=new StringTokenizer(br.readLine());
        int partSum = 0;

        //N은 2이상 100,000이하이고 k역시 1과N 사이 정수. 온도는 -100부터 100까지이므로 최소가 될 수 있는 값은 -10,000,000
        //따라서 max 값을 구하기 위한 result 변수 -10,000,000 로 초기화
        int result = -100000000;
        for(int i=0; i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            //queue의 사이즈가 k 보다 작을경우 add 하면서 합을 누적
            if(queue.size()<k){
                partSum+=x;
                queue.add(x);
            }
            else {//queue의 사이즈가 k라면 누적합이 최대인지 비교해보고, 다음에 비교해 볼 누적합을 구한 뒤 반복
                result = Math.max(result,partSum);
                partSum+=x;
                queue.add(x);
                partSum-=queue.poll();
            }
        }
        //맨 마지막에 처리되지 않은 누적합이 최대일 수 있으므로 한번 더 비교
        result=Math.max(result,partSum);

        //for output
        System.out.println(result);
    }
}