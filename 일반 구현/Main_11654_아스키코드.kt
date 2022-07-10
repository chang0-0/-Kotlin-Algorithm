import java.io.*;
import java.util.*

fun main() {
    var path : String = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_11654.txt"
    var br = BufferedReader(File(path).bufferedReader());

    var ch = StringTokenizer(br.readLine()).nextToken()[0]
    print("${ch.toInt()}")

} // End of main

