package algorithm_java.Geometry1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//처음 봤을 때에는 까다로워 보였지만, 차근차근 경우를 따져보니 어렵지 않게 풀 수 있었다.
//1358번 하키
public class P1358 {

        public static void main(String[] args) throws IOException {
            //For input
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            StringTokenizer st = new StringTokenizer(br.readLine());

            //input
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int xPos = Integer.parseInt(st.nextToken());
            int yPos =Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken()); // 선수의 수

            //output
            int result = 0;

            // p명의 선수 입력
            for(int i=0; i<p; i++){
                st= new StringTokenizer(br.readLine());
                int pX = Integer.parseInt(st.nextToken());
                int pY = Integer.parseInt(st.nextToken());

                if(isInLink(width,height,xPos,yPos,pX,pY))
                    result++;
            }

            System.out.println(result);
        }
        //링크 안에 존재하는지 함수를 호출
        public static boolean isInLink(int w, int h, int x, int y, int pX, int pY){
            int radius = h/2;
            //왼쪽 반원을 벗어날 때
            if(pX<x)
            {
                if(getDistanceSQR(x,y+radius, pX,pY)>radius*radius)
                    return false;
            }
            //오른쪽 반원을 벗어날 때
            else if (pX > x+w)
            {
                if(getDistanceSQR(x+w,y+radius, pX,pY)>radius*radius)
                    return false;
            }
            //사각형 부분을 벗어날 때(높이)
            else{
                if(pY<y || pY>y+h){
                    return false;
                }
            }
            return true;
        }

        //거리의 제곱을 구하는 함수. 원으로 된 부분이 있어 벗어났는지 확인하기 위해 두 점 사이의 거리를 구함.
        public static int getDistanceSQR(int x1, int y1, int x2, int y2){
            return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
        }
    }

