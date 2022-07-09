import java.io.*
import java.util.*

// 경우의 수 -> 백트래킹
private const val m : Long = 10000000007
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\A.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    var N = st.nextToken().toLong()
    var K = st.nextToken().toLong()
    var memo = LongArray(N.toInt())

    st = StringTokenizer(br.readLine())
    for(i in 0 until N) memo[i.toInt()] = st.nextToken().toLong()
    Arrays.sort(memo)

    var num = 2;
    memo[0] = N
    memo[1] = N*num

    for(i in 2 until K) {
        num *= 2
        if(memo[i.toInt()] == 0L) {
            memo[i.toInt()] = (memo[(i-1).toInt()] * num) % m
        }
    }

    println(Arrays.toString(memo))

    println(memo[K.toInt()-1])
} // End of main
