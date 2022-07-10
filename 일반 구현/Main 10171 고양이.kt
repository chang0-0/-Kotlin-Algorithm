import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    sb.append("\\    /\\").append('\n')
    sb.append(" )  ( ')").append('\n')
    sb.append("(  /  )").append('\n')
    sb.append(" \\(__)|").append('\n')

    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main