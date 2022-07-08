import java.util.*
import java.io.*

private const val earth = 15; private const val sun = 28; private const val moon = 19
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\중국인의 나머지 정리 부수기\\res\\1476.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val st = StringTokenizer(br.readLine())
    val E = st.nextToken().toInt()
    val S = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val n = earth * sun * moon
    val N1 = n/earth; val N2 = n/sun; val N3 = n/moon
    val x1 = find_mod(N1, earth); val x2 = find_mod(N2, sun); val x3 = find_mod(N3, moon)

    val x = (E*N1*x1) + (S*N2*x2) + (M*N3*x3)
    val result = x%n
    if(result != 0) print(result)
    else print(n)
} // End of main

private fun find_mod(n : Int, n2 : Int) : Int {
    for(i in 1..100) {
        if((n*i) % n2 == 1) return i
    }
    return 0
} // End of main