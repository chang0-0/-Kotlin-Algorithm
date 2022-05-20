import java.util.*;
import java.io.*;

private var N = 0; private var M = 0;
private var sb = StringBuilder();
private lateinit var arr : Array<Int>
private lateinit var visit : Array<Boolean>

// 중복(같은 숫자 연속 수열은 제외)
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input_bj_15649.txt"
    val br = BufferedReader( File(path).bufferedReader() )
    val st = StringTokenizer(br.readLine());

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    arr = Array<Int>(M, {0});
    visit = Array<Boolean>(N+1, {false});

    DFS(0)
    println(sb)
} // End of main

private fun DFS(depth : Int) {

    // 재귀 탈출조건
    if(depth == M) {
        arr.forEach{
            sb.append(it).append(' ')
        }
        sb.append('\n')
        return;
    }

    for(i in 1..N) {

        if(visit[i]) continue;

        visit[i] = true;
        arr[depth] = i;
        DFS(depth + 1);
        visit[i] = false;
    }
} // End of DFS