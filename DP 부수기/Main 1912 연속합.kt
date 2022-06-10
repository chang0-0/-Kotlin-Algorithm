import java.util.*
import java.io.*

private lateinit var arr : IntArray
private lateinit var memo : IntArray
private const val min = Integer.MIN_VALUE;
private var max = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DP 부수기\\res\\1912.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var N = br.readLine().toInt()
    arr = IntArray(N)
    memo = IntArray(N, {min})

    val st = StringTokenizer(br.readLine())
    for(i in 0 until N) arr[i] = st.nextToken().toInt()

    memo[0] = arr[0]
    max = arr[0]

    DP(N-1)
    print(max)
} // End of main

private fun DP(N : Int) : Int {

    if(memo[N] == min) {
        memo[N] = Math.max(DP(N-1) + arr[N], arr[N])
        max = Math.max(memo[N], max);
    }

    return memo[N];
} // End of DP