import java.io.*
import java.util.*

private lateinit var memo : IntArray
private lateinit var arr : IntArray

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DP 부수기\\res\\11053.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var A = br.readLine().toInt()
    memo = IntArray(A)
    arr = IntArray(A)

    val st = StringTokenizer(br.readLine())
    for(i in 0 until A) arr[i] = st.nextToken().toInt()

    for(i in 0 until A) {
        memo[i] = 1;

        for(j in 0 until i) {
            if(arr[j] < arr[i] && memo[i] < memo[j]+1) memo[i] = memo[j] + 1
        }
    }

    var max = 0;
    for(i in 0 until A) {
        if(memo[i] > max) max = memo[i]
    }

    print(max)
} // End of main