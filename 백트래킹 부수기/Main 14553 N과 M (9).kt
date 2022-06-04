import java.util.*
import java.io.*

private var N = 0; private var M = 0;
private lateinit var arr : Array<Int>
private lateinit var visit : Array<Boolean>
private lateinit var ans : Array<Int>
private val set : HashSet<String> = HashSet()
private val sb = StringBuilder()

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\15663.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter( OutputStreamWriter(System.`out`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt();
    M = st.nextToken().toInt();
    arr = Array(N, {0})
    visit = Array(N, {false})
    ans = Array(M, {0})

    st = StringTokenizer(br.readLine())
    for(i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }
    Arrays.sort(arr)
    DFS(0)

    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main

private fun DFS(depth : Int) {

    if(depth == M) {
        val temp = StringBuilder();

        for(i in 0 until M) {
            temp.append(ans[i]).append(' ')
        }

        if(!set.contains(temp.toString())) {
            set.add(temp.toString())
            sb.append(temp).append('\n')
        }
        return;
    }

    for(i in 0 until N) {

        if(visit[i]) continue;
        visit[i] = true;
        ans[depth] = arr[i]
        DFS(depth+1)
        visit[i] = false;
    }
} // End of DFS