import java.io.*;
import java.util.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\2475.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val st = StringTokenizer(br.readLine())

    var sum = 0;
    for(i in 0 until 5) {
        var num = st.nextToken().toInt()
        sum += num * num;
    }

    print(sum % 10)
} // End of main

