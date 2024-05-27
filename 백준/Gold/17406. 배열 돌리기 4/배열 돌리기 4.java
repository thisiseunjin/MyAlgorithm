import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int Y;
    static int X;
    static int C;
    static int[][] origin;
    static int[][] map;
    static int[][] order;
    static int order2[];
    static int used[];
    static int ans=Integer.MAX_VALUE;
    
    public static int getAns(){//최종 형태에서 배열 값 구하는 함수
        int ret=Integer.MAX_VALUE;
        for(int i=0;i<Y;i++){
            int temp=0;
            for(int j=0;j<X;j++){
                temp+=map[i][j];
            }
            if(temp<ret){
                ret=temp;
            }
        }
        return ret;
    }
    public static void makeOrder(int d){//순열 만드는 함수
        if(d==order2.length){//순열이 완성되면
            for(int i=0;i<Y;i++){
                for(int j=0;j<X;j++){
                    map[i][j]=origin[i][j];
                }
            }
            for(int i=0;i<d;i++){//순열대로
                //배열을 회전시킨다(order2가 순열)
                rotate(order[order2[i]][0]-order[order2[i]][2]-1,order[order2[i]][1]-order[order2[i]][2]-1,order[order2[i]][0]+order[order2[i]][2]-1,order[order2[i]][1]+order[order2[i]][2]-1);
            }
            int t=getAns();
            if(ans>t){
                ans=t;
            }
        }
        for(int i=0;i<C;i++){//순열 만들기
            if(used[i]==0){
                order2[d]=i;
                used[i]=1;
                makeOrder(d+1);
                used[i]=0;
            }
        }

    }
    public static void rotate(int col1,int row1,int col2,int row2){//회전시키기
        if(row1>row2){
            return;
        }
        int arr[]=new int[4*(row2-row1)];//순서대로 쫙 넣어줄 변수
        int p=0;
        //순서대로 쫙 넣어준 다음에
        for(int i=row1;i<row2;i++){
            arr[p++]=map[col1][i];
        }
        for(int i=col1;i<col2;i++){
            arr[p++]=map[i][row2];
        }
        for(int i=row2;i>row1;i--){
            arr[p++]=map[col2][i];
        }
        for(int i=col2;i>col1;i--){
            arr[p++]=map[i][row1];
        }
        //한칸씩 미뤄서 순서대로 쭉 뺴준다
        p=0;
        for(int i=row1+1;i<=row2;i++){
            map[col1][i]=arr[p++];
        }
        for(int i=col1+1;i<=col2;i++){
            map[i][row2]=arr[p++];
        }
        for(int i=row2-1;i>=row1;i--){
            map[col2][i]=arr[p++];
        }
        for(int i=col2-1;i>=col1;i--){
            map[i][row1]=arr[p++];
        }
        rotate(col1+1, row1+1, col2-1, row2-1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Y=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new int[Y][X];
        origin=new int[Y][X];

        for(int i=0;i<Y;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<X;j++){
                origin[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        order=new int[C][3];
        order2=new int[C];
        used=new int[C];
        for(int i=0;i<C;i++){
            st=new StringTokenizer(br.readLine());
            order[i][0]=Integer.parseInt(st.nextToken());
            order[i][1]=Integer.parseInt(st.nextToken());
            order[i][2]=Integer.parseInt(st.nextToken());
        }
        makeOrder(0);
        System.out.println(ans);
    }
}