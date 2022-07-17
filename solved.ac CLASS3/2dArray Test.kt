import java.util.*
private lateinit var arr : Array<String?>
fun main() {
    var N = 3
    arr = emptyArray()
    println(Arrays.toString(arr))

    arr = arrayOfNulls(N)
    println(Arrays.toString(arr))
} // End of main