package algorithm_java.Geometry1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 어려웠던 점 : 문제를 처음 읽었을 때에는 난해했지만, 차근차근 생각해서 '최소'가 되는 경우를 생각해내면 풀 수 있는 문제였다.
public class P1004 {

    public static void main(String[] args) throws IOException {

        //For input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Test t번 반복
        int t = Integer.parseInt(st.nextToken());

        //시작 좌표와 도착 좌표


        ArrayList<Integer> result = new ArrayList<>();


        for(int i=0; i<t; i++) {
            //시작점과 도착점
            st=new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            //행성의 개수 n
            st=new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            //최소로 거쳐야 하는 행성계
            int min = 0;
            // 행성의 중심 좌표 (x,y) 와 반지름 r
            for(int j=0; j<n;j++) {
                st= new StringTokenizer(br.readLine());
                int c_x = Integer.parseInt(st.nextToken());
                int c_y = Integer.parseInt(st.nextToken());
                int c_r = Integer.parseInt(st.nextToken());

                int c_r_square = c_r*c_r;
                int distanceSq1 = getDistanceSquare(start_x,start_y,c_x,c_y);
                int distanceSq2 = getDistanceSquare(end_x,end_y,c_x,c_y);

                // 두 점이 서로 각 행성계의 안과 밖에 있을 때마다 ==> 행성계와의 중심과의 거리가 행성계의 반지름보다 크거나 작을 때
                if(( distanceSq1 > c_r_square && distanceSq2 < c_r_square) ||
                        ( distanceSq1 < c_r_square && distanceSq2 > c_r_square)){
                    min+=1;
                }
            }
            //각 반복 차수마다 결과값 저장
            result.add(i,min);
        }

        //결과 문자열 제작
        StringBuilder sb = new StringBuilder();
        for (Integer i : result){
            sb.append(i);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static int getDistanceSquare(int x1, int y1, int x2, int y2){

        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
    }
}