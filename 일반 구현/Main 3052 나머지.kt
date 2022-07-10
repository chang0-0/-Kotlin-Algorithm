import java.io.*
import java.util.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\3052.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var list : MutableList<Int> = ArrayList<Int>()

    for(i in 0 until 10) {
        var mod = br.readLine().toInt() % 42
        if(!list.contains(mod)) list.add(mod)
    }

    print(list.size)
} // End of main