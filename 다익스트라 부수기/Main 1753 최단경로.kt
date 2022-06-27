package 최단경로
import java.util.*;
import java.io.*

private const val INF = Integer.MAX_VALUE;
private var V = 0; private var E = 0; private var K = 0
private lateinit var list : MutableList<MutableList<Node>>
private lateinit var dist : IntArray

private class Node(var nodeNum : Int, var weight : Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {return weight - other.weight}
}

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\다익스트라 부수기\\res\\1753.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var st = StringTokenizer(br.readLine())

    V = st.nextToken().toInt() // 정점(노드)의 개수
    E = st.nextToken().toInt() // 간선의 개수
    K = br.readLine().toInt() // 출발 노드

    dist = IntArray(V+1 , {INF})
    list = ArrayList()
    for(i in 0 until V+1) list.add(ArrayList())

    for(i in 0 until E) {
        st = StringTokenizer(br.readLine())
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()
        var w = st.nextToken().toInt()
        list.get(start).add(Node(end, w));
    }
    dijkstra(K)

    for(i in 1..V) {
        if(dist[i] == INF) {
            sb.append("INF").append('\n')
            continue
        }
        sb.append(dist[i]).append('\n')
    }

    bw.write(sb.toString());bw.flush();bw.close()
} // End of main

private fun dijkstra(start : Int) {
    val que = PriorityQueue<Node>()
    val check = BooleanArray(V+1)
    dist[start] = 0
    que.offer(Node(start, 0))

    while(!que.isEmpty()) {
        var queNode = que.poll()
        var startNum = queNode.nodeNum

        if(!check[startNum]) {
            check[startNum] = true

            list.get(startNum).forEach {
                if(!check[it.nodeNum] &&dist[it.nodeNum] > (dist[startNum] + it.weight)) {
                    dist[it.nodeNum] = dist[startNum] + it.weight
                    que.offer(Node(it.nodeNum, dist[it.nodeNum]))
                }
            }
        }
    }
} // End of dijkstra