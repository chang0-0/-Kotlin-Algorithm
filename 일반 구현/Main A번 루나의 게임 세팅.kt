import java.io.*
import java.util.*

// 경우의 수 -> 백트래킹
private const val m : Long = 10000000007
private lateinit var arr : LongArray
private lateinit var ans : LongArray
private lateinit var visit : BooleanArray

private var N = 0; private var K = 0
private var result = 0
private var result2 = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\A.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    K = st.nextToken().toInt()
    arr = LongArray(N)
    visit = BooleanArray(N)
    ans = LongArray(K)

    st = StringTokenizer(br.readLine())
    for(i in 0 until N) arr[i] = st.nextToken().toLong()
    Arrays.sort(arr)

    DFS(0)
    println(result)
} // End of main

private fun DFS(depth : Int) {

    if(depth == K) {
        var bool = true
        var temp = 0L
        for(i in 0 until K) {
            var num = ans[i]
            if(temp > num) {
                bool = false
                break
            }
            temp = num
        }

        if(bool == true) {
            result ++
        }
        else {
            bool = true
            temp = 2001L
            for(i in 0 until K) {
                var num = ans[i]
                if(temp < num) {
                    bool = false
                    break
                }
                temp = num
            }
            if(bool == true) {
                result ++
            }
        }
        return
    }

    for(i in 0 until N) {
        if(visit[i]) continue
        visit[i] = true
        ans[depth] = arr[i]
        DFS(depth+1)
        visit[i] = false
    }
} // End of DFS