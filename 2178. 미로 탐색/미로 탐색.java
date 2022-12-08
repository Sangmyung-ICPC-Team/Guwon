import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] miro = new char[N][M];
        int[][] dist = new int[N][M];
        
        //상하좌우 계산 좌표
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<Pair> qu = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1;
            }
        }
        
        //시작점 설정
        qu.offer(new Pair(0,0));
        dist[0][0] = 0;
        
        while(!qu.isEmpty()){
            Pair p = qu.poll();
            
            for(int i=0; i<4; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];
                
                //조건 - 벽에 부딪히거나 범위 넘어감
                if(nX<0 || nX>=N || nY<0 || nY>=M){
                    continue;
                }
                //조건 - 길이 아니거나 이미 방문한 길임
                if(miro[nX][nY]=='0' || dist[nX][nY]!=-1){
                    continue;
                }
                
                //큐에 이동한 좌표 넣기
                qu.offer(new Pair(nX, nY));
                //한 칸 이동 후 이전 출발 지점의 거리 +1
                dist[nX][nY] = dist[p.x][p.y] + 1;
            }
        }
        
        //출력
        System.out.print(dist[N-1][M-1] + 1);
    }
    
    //큐에 좌표를 넣기위한 클래스
    public static class Pair{
        int x, y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
    }
}