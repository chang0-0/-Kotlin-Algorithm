import java.io.*;
import kotlin.streams.asSequence

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_11718.txt"
    var br = BufferedReader(File(path).bufferedReader())

    var it = br.lines().asSequence().iterator()
    it.forEach { println(it) }

} // End of main