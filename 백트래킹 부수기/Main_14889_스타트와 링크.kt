import java.io.*;
import java.util.*;

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input_bj_14889.txt"
    var br = BufferedReader( File(path).bufferedReader() )
    var N = br.readLine().toInt();
    var arr = Array(N){Array(N) {0}} // Int형 2차원 배열 생성 및 초기화
    var visit = Array<Boolean>(N, {false});
    var result = Integer.MAX_VALUE;

    for(i in 0..N-1) {
        var st = StringTokenizer(br.readLine());
        for(j in 0..N-1) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    fun diff() {
        var team_start = 0;
        var team_link = 0;

        for(i in 0..N-2) {
            for(j in i+1..N-1) {

                if(visit[i] && visit[j]) {
                    team_start += arr[i][j] + arr[j][i];
                }
                else if( !visit[i] && !visit[j] ) {
                    team_link += arr[i][j] + arr[j][i];
                }
            }
        }

        var dif = Math.abs(team_start - team_link);
        result = Math.min(result, dif);

        if(result == 0) {
            println(result)
            System.exit(0);
        }

    } // End of diff

    fun DFS(idx : Int, depth : Int) {

        if(depth == N/2) {
            diff();
            return;
        }

        for(i in idx..N-1) {
            if(visit[i]) continue;

            visit[i] = true;
            DFS(i+1, depth + 1);
            visit[i] = false;
        }

    }// End of DFS

    DFS(0, 0)
    println(result)

} // End of main