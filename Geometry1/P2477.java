package Geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//2477

// 어려웠던 점 : 도형의 모양을 보고 즉시 넓이를 구하는 공식을 생각해내기 어려웠음
// 틀린 이유 : 도형을 일반화하여 세운 공식이 잘못됐음.
public class P2477 {

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //참외의 개수
        int k = Integer.parseInt(br.readLine());

        //길이 보관
        ArrayList<Integer> al = new ArrayList<>();
        int max_r=0;
        int max_c=0;
        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if(d<3 && max_r<l)
                max_r=l;
            else if(d>=3 && max_c<l)
                max_c=l;
            al.add(l);
        }

        //각 인덱스 구하기
        int a,b,c,d;
        a=al.indexOf(max_r);
        b=al.indexOf(max_c);
        c=(a+3)%6;
        d=(b+3)%6;

        //output
        int area=al.get(a)*al.get(b)- al.get(c)*al.get(d);

        System.out.println(area * k);


    }
}