import java.io.*
import java.util.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\1384.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var N = br.readLine().toInt()

    var GroupNum = 1
    while( N != 0 ) {
        sb.append("Group ${GroupNum}").append('\n')
        val arr = Array(N, {Array(N+1) {""}})

        // N행 N열 2차원 배열 생성
        for(i in 0 until N) {
            var st = StringTokenizer(br.readLine())
            for(j in 0 until N) {
                arr[i][j] = st.nextToken()
            }
        }

        var num = 0
        var bol = true // N이 있는지 없는지 여부를 체크하는 boolean값 bol이 true를 유지할 경우 N이 없는것으로 간주
        for(i in 0 until N) {
            for(j in 0 until N) {
                if(arr[i][j].equals("N")) {
                    num = i - j
                    if(num < 0) num += N // num값이 0보다 작을 경우 N값을 더함.

                    sb.append(arr[num][0]).append(" was nasty about ").append(arr[i][0]).append('\n')
                    bol = false
                }
            }
        }
        if(bol == true) sb.append("Nobody was nasty").append('\n')

        GroupNum++
        N = br.readLine().toInt()
        sb.append('\n')
    }
    bw.write(sb.toString());bw.flush();bw.close()
} // End of main