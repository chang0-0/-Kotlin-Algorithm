import java.io.*
import java.util.*

private val sb = StringBuilder()
private lateinit var arr : IntArray
private lateinit var ans : IntArray
private var N = 0; private var M = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\15656.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    arr = IntArray(N)
    ans = IntArray(M)

    st = StringTokenizer(br.readLine())
    for(i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }
    Arrays.sort(arr)

    DFS(0)
    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main

private fun DFS(depth : Int) {
    if(depth == M) {
        for(i in 0 until M) {
            sb.append(ans[i]).append(' ')
        }
        sb.append('\n')
        return;
    }

    for(i in 0 until N) {
        ans[depth] = arr[i]
        DFS(depth+1)
    }
} // End of DFS