import java.io.*
import java.util.*

private var N = 0; private var M = 0;
private var csize = 0; private var hsize = 0;
private var result = Integer.MAX_VALUE;

private lateinit var arr : Array<Array<Int>>
private lateinit var visit : Array<Boolean>
private var chickenList : MutableList<Node> = ArrayList<Node>();
private var houseList : MutableList<Node> = ArrayList<Node>();

private class Node(var x : Int, var y : Int)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input bj 15686.txt"
    val br = BufferedReader( File(path).bufferedReader() )
    var st : StringTokenizer;

    st = StringTokenizer(br.readLine());
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    arr = Array(N){Array(N) {0}}
    for(i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for(j in 0 until N) {
            arr[i][j] = st.nextToken().toInt()

            if(arr[i][j] == 1) {
                houseList.add(Node(i, j));
            }
            else if(arr[i][j] == 2) {
                chickenList.add(Node(i, j));
            }
        }
    }

    csize = chickenList.size;
    hsize = houseList.size;
    visit = Array(csize, {false})

    DFS(0, 0)
    print(result)
} // End of main

private fun DFS(index : Int, depth : Int) {

    if (depth == M) {
        var sum = 0;

        for(i in 0 until hsize) {
            var temp = Integer.MAX_VALUE;

            for(j in 0 until csize) {
                if(visit[j]) {
                    if(temp == 1) break;

                    var dist = Math.abs(houseList.get(i).x - chickenList.get(j).x) + Math.abs(houseList.get(i).y - chickenList.get(j).y)
                    temp = Math.min(temp, dist)
                }
            }
            sum += temp;    
        }

        result = Math.min(result, sum)
        return;
    }

    for(i in index until csize) {
        visit[i] = true;
        DFS(i+1, depth+1)
        visit[i] = false;
    }

} // End of DFS