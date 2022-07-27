import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\정수론 & 조합론 부수기\\res\\1138.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val sb = StringBuilder()
    var N = br.readLine().toInt()
    val arr = IntArray(N)
    val ans = IntArray(N)
    val st = StringTokenizer(br.readLine())
    for(i in 0 until N) arr[i] = st.nextToken().toInt()

    for(i in 0 until N) {
        var count = arr[i]
        println("count : ${count}")

        for(j in 0 until N) {
            println("j : ${j}")

            if(count == 0) { // 본인 왼쪽에 키가 큰 사람이 아무도 없음
                if(ans[j] == 0) { // 자리가 비어 있음
                    ans[j] = i + 1
                    break
                }
            }
            else if(ans[j] == 0) count--

        }
        println(Arrays.toString(ans))
    }

    ans.forEach { sb.append(it).append(' ') }
    print(sb)
} // End of main