import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\10952.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    var temp : String = br.readLine()
    while( temp != null) {
        var st = StringTokenizer(temp)
        var num1 = st.nextToken().toInt()
        var num2 = st.nextToken().toInt()
        if(num1 == 0) break

        sb.append(num1 + num2).append('\n')
        temp = br.readLine()
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main