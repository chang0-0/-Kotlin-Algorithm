import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\정수론 & 조합론 부수기\\res\\11921.txt"
    val br = BufferedReader(File(path).bufferedReader())
    print(br.readLine().toInt() + br.readLine().toInt())
} // End of main