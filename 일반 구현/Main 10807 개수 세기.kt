import java.io.*
import java.util.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현 부수기\\res\\10807.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var N = br.readLine().toInt()
    val arr = IntArray(N)

    val st = StringTokenizer(br.readLine())
    for(i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }

    val v = br.readLine().toInt()
    var result = 0
    arr.forEach {
        if(it == v) {
            result++
        }
    }

    print(result)
}