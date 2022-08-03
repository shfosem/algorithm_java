package algorithm_java.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//어려웠던 점 : 재귀함수를 써서 해결해야겠다고는 생각이 들었지만, 하나의 맵을 어떻게 쪼개서 재귀함수에 적용할지 판단하기가 어려웠다.

public class P2630 {

    // 2630
    static int white = 0;
    static int blue = 0;
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int x, int y, int size){
        if(size==1){
            if(map[x][y]==0)white++;
            else blue++;
            return;
        }
        if(isSame(x,y,map[x][y],size)){
            if(map[x][y]==0)white++;
            else blue++;
            return;
        }

        divide(x,y,size/2);
        divide(x+size/2,y,size/2);
        divide(x,y+size/2,size/2);
        divide(x+size/2,y+size/2,size/2);
    }

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