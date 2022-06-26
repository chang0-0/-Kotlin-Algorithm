import java.util.*
import java.io.*

// 0은 빈방, 1은 벽을 의미한다.

private var N = 0; private var M = 0
private var nowX = 0; private var nowY = 0

private var dirX = arrayOf(0, 0, -1, 1)
private var dirY = arrayOf(-1, 1, 0, 0)
private lateinit var arr : Array<IntArray>
private lateinit var visit : Array<BooleanArray>

private class Node(var x: Int, var y : Int, var wall : Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return wall - other.wall
    }
} // End of Node class

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\다익스트라 부수기\\res\\1261.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    arr = Array(M){IntArray(N)}
    visit = Array(M){BooleanArray(N)}
    for(i in 0 until M) {
        var ch = br.readLine().toCharArray()
        for(j in 0 until N) {
            arr[i][j] = ch[j] - '0'
        }
    }

    var result = BFS(0, 0)
    print(result)
} // End of main

private fun BFS(x : Int, y : Int) : Int {
    var que = PriorityQueue<Node>()
    que.offer(Node(x, y, 0))
    visit[x][y] = true

    while(!que.isEmpty()) {
        var node = que.poll()

        if(node.x == M-1 && node.y == N-1) return node.wall

        for(i in 0 until 4) {
            nowX = node.x + dirX[i]
            nowY = node.y + dirY[i]

            if(!rangeCheck() || visit[nowX][nowY]) continue

            // 값이 1일 경우
            if(arr[nowX][nowY] == 1) {
                visit[nowX][nowY] = true
                que.offer(Node(nowX, nowY, node.wall + 1))
            }

            if(arr[nowX][nowY] == 0) {
                visit[nowX][nowY] = true
                que.offer(Node(nowX, nowY, node.wall))
            }
        }
    }

    return 0
} // End of BFS

private fun rangeCheck() : Boolean {
    return (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N)
} // End of rangeCheck