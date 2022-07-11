import java.util.*
import java.io.*

private var memo = Array(11){IntArray(11)}
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\정수론 & 조합론 부수기\\res\\11050.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val st = StringTokenizer(br.readLine())

    var N = st.nextToken().toInt()
    var K = st.nextToken().toInt()
    DP(N)
    print(memo[N][K])
} // End of main

private fun DP(N : Int) {
    for(i in 0..N) {
        memo[i][0] = 1
        for (j in 1..i) memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j])
    }
} // End of DP