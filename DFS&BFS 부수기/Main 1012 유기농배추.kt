package `DFS&BFS 부수기`

import java.util.*;
import java.io.*;

private var T = 0; private var nowX = 0; private var nowY = 0;
private var N = 0; private var M = 0;
private lateinit var arr : Array<Array<Int>>
private lateinit var visit : Array<Array<Boolean>>

private val dirX = arrayOf(0, 0, -1, 1) // 상 하 좌 우
private val dirY = arrayOf(-1, 1, 0, 0)
private var sb = StringBuilder();

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DFS&BFS 부수기\\res\\1012.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st : StringTokenizer

    T = br.readLine().toInt();
    while(T-->0) {
        st = StringTokenizer(br.readLine())
        M = st.nextToken().toInt()
        N = st.nextToken().toInt()
        var K = st.nextToken().toInt()
        arr = Array(M) {Array(N) {0}}
        visit = Array(M) {Array(N) {false}}

        while(K-->0) {
            st = StringTokenizer(br.readLine())
            var x = st.nextToken().toInt();
            var y = st.nextToken().toInt();
            arr[x][y] = 1;
        }

        var count = 0;
        for(i in 0 until M) {
            for(j in 0 until N) {

                if(arr[i][j] == 1 && !visit[i][j]) {
                    count ++;
                    DFS(i,j)
                }
            }
        }
        sb.append(count).append('\n')
    }

    print(sb)
} // End of main

private fun DFS(x : Int, y : Int) {
    visit[x][y] = true;

    for(i in 0 until 4) {
        nowX = x + dirX[i];
        nowY = y + dirY[i];

        if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
            DFS(nowX, nowY);
        }
    }
} // End of BFS

private fun range_check() : Boolean {
    return nowX >= 0 && nowX < M && nowY >= 0 && nowY < N
} // End of range_check