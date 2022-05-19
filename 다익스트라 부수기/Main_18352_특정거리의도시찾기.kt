import java.util.*;
import java.io.*;

private const val INF = Int.MAX_VALUE;
private lateinit var list : MutableList<MutableList<City>>
private lateinit var dist : Array<Int>
private var N : Int = 0;
private var M : Int = 0
private var K : Int = 0;
private var X : Int = 0;

private class City(var CityNum : Int, var weight : Int) : Comparable<City> {
    override fun compareTo(other: City): Int {
        return weight - other.weight;
    }
} // End of City class

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\다익스트라 부수기\\res\\input_bj_18352.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var st : StringTokenizer
    var sb = StringBuilder()

    st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    K = st.nextToken().toInt()
    X = st.nextToken().toInt()

    dist = Array<Int>(N+1, {INF});
    list = ArrayList();
    for(i in 0..N+1) {
        list.add(ArrayList())
    }

    while(M-->0) {
        st = StringTokenizer(br.readLine());
        var x = st.nextToken().toInt()
        var y = st.nextToken().toInt()
        list.get(x).add(City(y, 1))
    }

    dijkstra(X)

    for(i in 1..N) {
        if(dist[i] == K) {
            sb.append(i).append('\n')
        }
    }

    if(sb.length == 0) {
        println(-1)
    }
    else {
        println(sb)
    }

} // End of main

private fun dijkstra(cityNum : Int) {
    var que : PriorityQueue<City> = PriorityQueue<City>();
    var visit = Array<Boolean>(N + 1, {false})
    dist[cityNum] = 0;
    que.offer(City(cityNum, 0));

    while( !que.isEmpty()) {
        var city : City = que.poll();
        var num = city.CityNum;

        if(visit[num]) continue;
        visit[num] = true;

        for(c in list.get(num)) {

            if( !visit[c.CityNum] && dist[c.CityNum] > (c.weight + dist[num]) ) {
                dist[c.CityNum] = (c.weight + dist[num])
                que.offer(City(c.CityNum, dist[c.CityNum]))
            }
        }
    }

} // End of dijkstra