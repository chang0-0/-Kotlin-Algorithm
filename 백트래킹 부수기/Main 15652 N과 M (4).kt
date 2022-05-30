import java.util.*;
import java.io.*;

private var N = 0; private var M = 0;
private lateinit var ans : Array<Int>;
private val sb = StringBuilder();

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input bj 15652.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val st = StringTokenizer(br.readLine());

    N = st.nextToken().toInt();
    M = st.nextToken().toInt();
    ans = Array(M, {0});

    DFS(1, 0);
    print(sb)
} // End of main

fun DFS(index : Int, depth : Int) {

    if(depth == M) {
        for(j in 0 until M) {
            sb.append(ans[j]).append(' ')
        }
        sb.append('\n')
        return;
    }

    for(i in index until N+1) {
        ans[depth] = i;
        DFS(i, depth+1)
    }
} // End of DFS