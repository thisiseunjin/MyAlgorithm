import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];
    static ArrayList<Integer> resultList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int LIS[];
    static int idxArr[];
    static int resultLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        LIS = new int[N];
        idxArr = new int[N];
        arr = new int[N];

        Arrays.fill(idxArr, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        resultLength = 1;
        LIS[0] = arr[0];
        idxArr[0] = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > LIS[resultLength - 1]) {
                ++resultLength;
                LIS[resultLength - 1] = arr[i];
                idxArr[i] = resultLength - 1;
            } else {
                int idx = binarySearch(0, resultLength - 1, arr[i]);
                LIS[idx] = arr[i];
                idxArr[i] = idx;
            }
        }

        int findIdx = resultLength - 1;
        for (int i = N - 1; i > -1; i--) {
            if (idxArr[i] == findIdx) {
                sb.insert(0, arr[i] + " ");
                --findIdx;
                if(findIdx<0) break;
            }

        }

        System.out.println(resultLength);
        System.out.println(sb);
//        System.out.println(Arrays.toString(idxArr));
//        System.out.println(Arrays.toString(LIS));
    }

    public static int binarySearch(int startIdx, int endIdx, int key) {
        int midIdx = (endIdx + startIdx)/2;
        int resIdx=midIdx;

        while (startIdx <= endIdx) {
            midIdx = (endIdx + startIdx)/2;
            if (LIS[midIdx] >= key) {
                //왼쪽으로 간다.
                resIdx = midIdx;
                endIdx = midIdx-1;

            } else {
                //resIdx = midIdx;
                startIdx = midIdx + 1;
//                midIdx = (endIdx + startIdx)/2;
//                if(LIS[midIdx]>key){
//                    return startIdx;
//                }
            }
        }
        return resIdx;

    }
}