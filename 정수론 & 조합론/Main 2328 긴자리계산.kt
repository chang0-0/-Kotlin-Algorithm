import java.io.*
import java.math.BigInteger

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\정수론 & 조합론 부수기\\res\\2328.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var a : BigInteger = BigInteger(br.readLine())
    var b : BigInteger = BigInteger(br.readLine())

    sb.append(a.plus(b)).append('\n').append(a.minus(b)).append('\n').append(a.multiply(b))
    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main