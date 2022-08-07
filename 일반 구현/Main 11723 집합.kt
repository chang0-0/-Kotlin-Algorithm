import java.util.*
import java.io.*
import kotlin.collections.HashSet

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현 부수기\\res\\11723.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    val set = HashSet<Int>()

    var M = br.readLine().toInt()
    while(M-->0) {
        val st = StringTokenizer(br.readLine())
        val str = st.nextToken()

        var x = 0
        if( !str.equals("all") && !str.equals("empty")) x = st.nextToken().toInt()

        if(str.equals("add")) set.add(x);
        else if(str.equals("remove")) set.remove(x);
        else if(str.equals("check")) {
            if(set.contains(x)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
        else if(str.equals("toggle")) {
            if(set.contains(x)) set.remove(x);
            else set.add(x);
        }
        else if(str.equals("all")) {
            for(i in 1..20) set.add(i);
        }
        else if(str.equals("empty")) set.clear();
    }

    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main