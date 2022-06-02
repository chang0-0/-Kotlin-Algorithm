import java.util.*
import java.io.*

private lateinit var arr : Array<Array<Int>>
private var N = 0; private var M = 0; private var H = 0
private var result = 0
private var finish = false

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\15684.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    H = st.nextToken().toInt()
    arr = Array(H+1){Array(N+1) {0}}

    for(i in 0 until M) {
        st = StringTokenizer(br.readLine())
        var x = st.nextToken().toInt()
        var y = st.nextToken().toInt()
        arr[x][y] = 1
        arr[x][y+1] = 2
    }

    // i=0은 사다리를 하나도 추가하지 않았을 때, 정답이 될 수 있는지를 체크
    // 만약, 정답이 3보다 큰 값이면 -1을 출력한다. -> 사다리 개수가 3개를 초과할 경우 더 이상 탐색할 필요가 없음
    for(i in 0..3) {
        result = i
        DFS(1, 0) // 무조건 1부터 시작
        if(finish) break // 문제가 해결되어서 끝내도 된다를 알 수 있는 변수 finish
    }

    if(finish) {
        print(result)
    }
    else {
        print(-1)
    }
} // End of main

private fun DFS(x : Int, depth : Int) {
    //println("DFS(${x} , ${depth})")

    if(finish) return
    if(result == depth) {
        if(check()) {
            finish = true
        }
        return
    }

    for(i in x..H) {
        for(j in 1 until N) {

            if(arr[i][j] == 0 && arr[i][j+1] == 0) {
                arr[i][j] = 1
                arr[i][j+1] = 2
                DFS(i, depth+1)

                // 백트래킹
                // 만들어 놓은 사다리를 다시 돌려놓음
                arr[i][j] = 0
                arr[i][j+1] = 0
            }
        }
    }
} // End of DFS

// 만들어진 사다리가 정답이 될 수 있는지 체크하는 함수
private fun check() : Boolean {
    for(i in 1..N) {
        var x = 1; var y = i

        for(j in 0 until H) {
            if(arr[x][y] == 1) { // 1이면 우측으로 가기때문에 y를 1증가시킴
                y++
            }
            else if(arr[x][y] == 2) { // 2이면 좌측으로 가기때문에 y를 1감소시킴
                y--
            }
            x++; // 다음 행으로 넘어감
        }

        if(y != i) return false // 출발한 i와 마지막 도착지 인 y의 값이 다를 경우, 출발지와 도착지가 다름을 의미하기 때문에 정답이 될 수 없음
    }

    return true
} // End of check