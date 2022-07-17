import java.util.*
import java.io.*

private var N = 0
private var sharkSize = 2
private var eatCount = 0
private var nowX = 0; private var nowY = 0
private var result = 0

// 방향 우선순위 : 상 좌 우 하
private val dirX = arrayOf(-1, 0, 0, 1)
private val dirY = arrayOf(0, -1, 1, 0)
private lateinit var arr: Array<IntArray>

class Shark(var x: Int, var y: Int, var dist: Int) : Comparable<Shark> {
    override fun compareTo(o: Shark): Int {
        if(dist == o.dist) {
            if(x == o.x) return Integer.compare(y, o.y)
            return Integer.compare(x, o.x)
        }
        return Integer.compare(dist, o.dist)
    }
}

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\solved ac CLASS3\\res\\16236.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var startX = 0; var startY = 0

    N = br.readLine().toInt()
    arr = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            arr[i][j] = st.nextToken().toInt()
            if (arr[i][j] == 9) {
                startX = i; startY = j
                arr[i][j] = 0
            }
        }
    }

    BFS(startX, startY)
    print(result)
} // End of main

private fun BFS(x: Int, y: Int) {
    val que = PriorityQueue<Shark>()
    var visit = Array(N){BooleanArray(N)}
    que.offer(Shark(x, y, 0))
    visit[x][y] = true

    while(!que.isEmpty()) {
        var sh = que.poll()
        for(i in 0 until 4) {
            nowX = dirX[i] + sh.x
            nowY = dirY[i] + sh.y

            if(!range_check() || visit[nowX][nowY]) continue
            visit[nowX][nowY] = true

            if(arr[nowX][nowY] <= sharkSize) que.offer(Shark(nowX, nowY, sh.dist+1))
        }

        if(!que.isEmpty()) {
            var peekSh = que.peek()

            if(arr[peekSh.x][peekSh.y] < sharkSize && arr[peekSh.x][peekSh.y] > 0) {
                eatCount++
                if(eatCount == sharkSize) {
                    sharkSize++
                    eatCount = 0
                }
                arr[peekSh.x][peekSh.y] = 0

                que.clear()
                que.offer(Shark(peekSh.x, peekSh.y, 0))
                result += peekSh.dist
                visit = Array(N){BooleanArray(N)}
                visit[peekSh.x][peekSh.y] = true
            }
        }
    }
} // End of BFS

private fun range_check(): Boolean {
    return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N
} // End of range_check