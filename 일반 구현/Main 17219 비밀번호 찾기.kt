import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\17219.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`));
    val sb = StringBuilder()
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()
    var map = HashMap<String, String>()

    while(N-->0) {
        st = StringTokenizer(br.readLine())
        map.put(st.nextToken(), st.nextToken())
    }

    while(M-->0) {
        st = StringTokenizer(br.readLine())
        sb.append(map.get(st.nextToken())).append('\n')
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main