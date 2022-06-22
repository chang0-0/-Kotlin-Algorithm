import java.io.*
import java.util.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\10818.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    var min = 1000000
    var max = -1000000
    var N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    while(N-->0) {
        var num = st.nextToken().toInt()
        min = Math.min(min, num)
        max = Math.max(max, num)
    }

    sb.append(min).append(' ').append(max)
    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main