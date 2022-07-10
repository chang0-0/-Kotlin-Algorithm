import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\9498.txt"
    val br = BufferedReader(File(path).bufferedReader())
    when(br.readLine().toInt()) {
        in 90..100 -> print('A')
        in 80..89 -> print('B')
        in 70..79 -> print('C')
        in 60..69 -> print('D')
        else -> print('F')
    }
} // End of main