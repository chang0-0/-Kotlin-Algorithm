import java.util.*;
import java.io.*;

private var N = 0;
private var M = 0;
private lateinit var arr : Array<Int>;
private val sb = StringBuilder();

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input_bj_15651.txt"
    var br = BufferedReader( File(path).bufferedReader())
    var st = StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 1 ~ N
    M = Integer.parseInt(st.nextToken()); // 자리수

    arr = Array<Int>(M, {0});

    DFS(0);
    println(sb);
} // End of main

private fun DFS(depth : Int) {

    if(M == depth) {
        arr.forEach {
            sb.append(it).append(' ')
        }
        sb.append('\n');
        return;
    }

    for(i in 1..N) {
        arr[depth] = i;
        DFS(depth + 1);
    }

} // End of DFS