import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\10869.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var sb = StringBuilder()
    val st = StringTokenizer(br.readLine())

    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    sb.append(N + M).append('\n')
    sb.append(N - M).append('\n')
    sb.append(N * M).append('\n')
    sb.append(N / M).append('\n')
    sb.append(N % M)

    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main