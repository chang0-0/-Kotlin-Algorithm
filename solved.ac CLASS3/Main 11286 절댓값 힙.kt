import java.util.*
import java.io.*
import kotlin.math.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\solved\\ac CLASS3\\res\\11286.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val pque = PriorityQueue<Int>( Comparator { o1, o2 ->
        var abs1 = abs(o1)
        var abs2 = abs(o2)
        // 두 값의 값이 같을 경우, 부호를 비교해서 오름차순으로 정렬.
        // 두 값이 다를 경우, 그냥 절댓값에서 숫자의 크기로 비교해서 오름차순으로 정렬
        when {
            abs1 == abs2 -> o1 - o2
            else -> abs1 - abs2
        }
    })

    var N = br.readLine().toInt()
    while(N-->0) {
        var x = br.readLine().toInt()

        if(x != 0) pque.offer(x)
        else {
            if(pque.isEmpty()) sb.append(0).append('\n')
            else sb.append(pque.poll()).append('\n')
        }
    }

    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main