import java.util.*;
import java.io.*;

// 인접리스트 생성
private lateinit var list: MutableList<MutableList<Node>>
private lateinit var dist: IntArray
private const val INF = Integer.MAX_VALUE / 16 // 오버플로우 방지 / 16
private var N = 0;
private var M = 0;

private class Node(var nodeNum : Int, var weight: Int) : Comparable<Node> { // Node class
    override fun compareTo(other: Node): Int {
        return weight - other.weight;
    }
}

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\다익스트라 부수기\\res\\input_bj_1916.txt"
    var br = BufferedReader(File(path).bufferedReader())
    N = br.readLine().toInt()
    M = br.readLine().toInt()

    dist = IntArray(N+1){INF};
    // 노드의 개수 만큼 인접리스트 생성
    list = ArrayList()
    for(i in 0..N) {
        list.add(ArrayList())
    }

    for(i in 1..M) {
        var st = StringTokenizer(br.readLine());
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()
        var weight = st.nextToken().toInt()
        list.get(start).add(Node(end, weight));
    }

    var st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    println(dijkstra(start, end))

} // End of main

fun dijkstra(start : Int, end : Int) : Int {
    var que : PriorityQueue<Node> = PriorityQueue();
    var visit : BooleanArray = BooleanArray(N + 1);
    dist[start] = 0;
    que.offer(Node(start, 0))

    while( !que.isEmpty() ) {
        var queNode : Node = que.poll();
        var start_nodeNum = queNode.nodeNum;

        if( !visit[start_nodeNum] ) {
            visit[start_nodeNum] = true;

            list.get(start_nodeNum).forEach {

                if( !visit[it.nodeNum] && dist[it.nodeNum] > (dist[start_nodeNum] + it.weight)) {
                    dist[it.nodeNum] = dist[start_nodeNum] + it.weight
                    que.offer(Node(it.nodeNum, dist[it.nodeNum]))
                }

            }
        }
    }

    return dist[end];
} // End of dijkstras