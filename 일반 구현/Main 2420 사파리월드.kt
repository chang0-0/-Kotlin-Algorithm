import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    print( Math.abs(st.nextToken().toLong() - st.nextToken().toLong() ))
}