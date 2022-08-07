import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var ch = br.readLine().toCharArray()
    println("${'a' - '0'}")
    println("${'Z' - '0'}")

    for(i in 0 until ch.size) {
        var temp = ch[i]
        println(temp)
        if( 17 >= temp-'0' && 42 <= temp - '0' ) {
            sb.append(Character.toLowerCase(temp))
        }
        else {
            sb.append(Character.toLowerCase(temp))
        }
    }

    print(sb)
} // End of main
// WrongAnswer