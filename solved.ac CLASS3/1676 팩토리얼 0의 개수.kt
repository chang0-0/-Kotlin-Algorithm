import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\solved\\ac CLASS 3\\res\\1676.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var N = br.readLine().toInt()
    var count = 0

    while(N >= 5) {
        count += N / 5
        N /= 5
    }
    print(count)
} // End of main

