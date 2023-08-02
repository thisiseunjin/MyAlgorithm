import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        //왼쪽자식1, 오른쪽2
        tree = new char[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i][0] = st.nextToken().charAt(0);  //부모
            tree[i][1] = st.nextToken().charAt(0);  //왼쪽
            tree[i][2] = st.nextToken().charAt(0);  //오른쪽
        }

        preorder(tree[0][0]);
        sb.append("\n");
        inorder(tree[0][0]);
        sb.append("\n");
        postorder(tree[0][0]);

        System.out.println(sb);

    }

    public static void preorder(char root) {
        //전위순회 : root -> left -> right
        for (int i = 0; i < N; i++) {
            if (tree[i][0] == root) {
                sb.append(tree[i][0]);

                //왼쪽이 안비어 있으면? 왼쪽~!
                if (tree[i][1] != '.') preorder(tree[i][1]);
                if (tree[i][2] != '.') preorder(tree[i][2]);

                break;
            }
        }
    }

    public static void inorder(char root) {
        //중위 :  left -> root -> right
        for (int i = 0; i < N; i++) {
            if (tree[i][0] == root) {


                //왼쪽이 안비어 있으면? 왼쪽~!
                if (tree[i][1] != '.') inorder(tree[i][1]);
                sb.append(tree[i][0]);
                if (tree[i][2] != '.') inorder(tree[i][2]);

                break;
            }
        }
    }

    public static void postorder(char root) {
        //중위 :  left -> root -> right
        for (int i = 0; i < N; i++) {
            if (tree[i][0] == root) {


                //왼쪽이 안비어 있으면? 왼쪽~!
                if (tree[i][1] != '.') postorder(tree[i][1]);
                if (tree[i][2] != '.') postorder(tree[i][2]);
                sb.append(tree[i][0]);
                break;
            }
        }
    }

}