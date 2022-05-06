import java.io.*;
import java.util.*;

private var arr = Array(0, {Array(0, {0})})
private var visit = Array(0, {false})
private val sb = StringBuilder();

private var N : Int = 0; private var M : Int = 0;
private var count : Int = 0;

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_1260.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    N = Integer.parseInt(st.nextToken()); // 정점의 개수
    M = Integer.parseInt(st.nextToken()); // 간선의 개수
    var V = Integer.parseInt(st.nextToken()); // 노드의 개수
    arr = Array(N+1, {Array(N+1, {0})})
    visit = Array(N+1, {false});


    for(i in 1..M step 1) {
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt();
        val y = st.nextToken().toInt();

        arr[x][y] = 1;
        arr[y][x] = 1;
    }

    DFS(V);
    sb.append('\n');

    visit = Array(N+1, {false});
    BFS(V);

    print(sb);
} // End of main

fun DFS(nodeNum : Int) {
    visit[nodeNum] = true;
    sb.append("${nodeNum} ");

    if(count == N) {
        return;
    }
    count ++;

    for(i in 1..N step 1) {
        if(arr[nodeNum][i] == 1 && !visit[i] ) {
            DFS(i);
        }
    }

} // End of DFS

fun BFS(nodeNum : Int) {
    var que : Queue<Int> = LinkedList();
    que.offer(nodeNum);
    visit[nodeNum] = true;
    sb.append("${nodeNum} ");

    while( !que.isEmpty() ) {
        var nodeNum = que.poll();

        for(i in 1..N step 1) {

            if(arr[nodeNum][i] == 1 && !visit[i] ) {
                que.offer(i);
                visit[i] = true;
                sb.append("${i} ")
            }
        }
    }

    que.clear();
} // End of BFS