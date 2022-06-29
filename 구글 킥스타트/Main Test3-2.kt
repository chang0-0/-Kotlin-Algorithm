import java.util.*
import java.io.*

// https://www.acmicpc.net/problem/23932
// 펠린드롬 검사기 생성 
// 가능한지 여부를 따져서 만들 수 있는 개수 파악
private var map = HashMap<Char, Int>()
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\구글 킥스타트\\res\\test3.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    var T = br.readLine().toInt()
    for(i in 0 until T) {
        sb.append("Case #").append(i+1).append(": ")
        var st = StringTokenizer(br.readLine())
        var N = st.nextToken().toInt() // 전체 문자열 길이
        var Q = st.nextToken().toInt() // 질문의 수
        var str = br.readLine()

        var result = 0
        while(Q-->0) {
            st = StringTokenizer(br.readLine())
            var L = st.nextToken().toInt()
            var R = st.nextToken().toInt()

            if(checkPalindromes(str.substring(L-1, R))) result++
            map.clear()
        }
        sb.append(result).append('\n')
    }

    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main

private fun checkPalindromes(str : String) : Boolean {
    if(str.length == 1) return true

    // 알파벳의 개수가 홀수2개 이상일 경우 false임
    var size = str.length
    var holCount = 0
    for(i in 0 until size) {
        map.put(str[i], map.getOrDefault(str[i], 0)+1)
    }

    map.forEach {
        if(it.value % 2 != 0) holCount++
        if(holCount >= 2) return false
    }
    return true
} // End of checkPalindromes