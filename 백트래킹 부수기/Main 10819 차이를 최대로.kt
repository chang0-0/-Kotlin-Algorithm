import java.util.*;
import java.io.*;

private var N = 0;
private lateinit var arr : Array<Int>
private lateinit var visit : Array<Boolean>
private lateinit var ans : Array<Int>
private var result = Integer.MIN_VALUE;

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input_bj_10819.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt()
    arr = Array(N, {0})
    visit = Array(N, {false})
    ans = Array(N, {0})

    var st = StringTokenizer(br.readLine())
    for(i in 0..N-1) {
        arr[i] = st.nextToken().toInt()
    }
    Arrays.sort(arr)

    DFS(0)
    print(result)
} // End of main

private fun DFS(depth : Int) {
    
    // 재귀 탈출 조건
    if(depth == N) {
        var sum = 0;

        for(i in 1 until N) {
            sum += Math.abs(ans[i-1] - ans[i])
        }

        result = Math.max(result, sum)
        return
    }

    for(i in 0 until N) {

        if(visit[i]) continue;
        visit[i] = true;
        ans[depth] = arr[i];
        DFS(depth + 1)
        visit[i] = false;
    }

} // End of DFS