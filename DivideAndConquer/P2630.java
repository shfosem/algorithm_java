package algorithm_java.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//어려웠던 점 : 재귀함수를 써서 해결해야겠다고는 생각이 들었지만, 하나의 맵을 어떻게 쪼개서 재귀함수에 적용할지 판단하기가 어려웠다.

public class P2630 {

    // 2630번 색종이 만들기
    //for output
    static int white = 0;
    static int blue = 0;

    //재귀함수 호출을 용이하게 하기 위한 전역변수
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        //for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //입력으로 주어지는 한 변의 길이 N
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        //하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어짐
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //0,0,n 에 대해 재귀함수를 호출하여 각 white, blue 값을 구함
        divide(0,0,n);
        //for output
        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int x, int y, int size){
        //사이즈가 1이라면 각 0 에 대해 white +1, 각 1에대해 blue +1
        if(size==1){
            if(map[x][y]==0)white++;
            else blue++;
            return;
        }
        // 같은 색종이라면, white에 대해 +1, blue에 대해 +1
        if(isSame(x,y,map[x][y],size)){
            if(map[x][y]==0)white++;
            else blue++;
            return;
        }
        //각 사분면별로 재귀함수 호출
        divide(x,y,size/2);
        divide(x+size/2,y,size/2);
        divide(x,y+size/2,size/2);
        divide(x+size/2,y+size/2,size/2);
    }
    // 같은 색종이인지 여부 확인하기 위한 함수 정의
    static boolean isSame(int x, int y, int color, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(color!=map[i][j])
                    return false;
            }
        }
        return true;
    }
}