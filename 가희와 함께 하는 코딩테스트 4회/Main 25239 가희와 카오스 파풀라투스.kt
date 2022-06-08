import java.util.*
import java.io.*

private lateinit var visit : BooleanArray
private var Time = 0; private var Area = 0
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\25239.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st: StringTokenizer

    st = StringTokenizer(br.readLine(), ":")
    val hour = st.nextToken().toInt()
    val min = st.nextToken().toInt()
    Time = (hour*60) + min

    var arr = IntArray(7)
    visit = BooleanArray(7)

    st = StringTokenizer(br.readLine())
    for(i in 1..6) arr[i] = st.nextToken().toInt()

    var L = br.readLine().toInt()
    while(L-->0) {
        st = StringTokenizer(br.readLine())
        st.nextToken()
        var T = st.nextToken().toString()

        if(T == "^") {
            checkArea()
            visit[Area] = true
            if(checkVisit()) break
        }

        if(T == "10MIN") Time += 10
        else if(T == "30MIN") Time += 30
        else if(T == "50MIN") Time += 50
        else if(T == "2HOUR") Time += 120
        else if(T == "4HOUR") Time += 240
        else if(T == "9HOUR") Time += 540

        if(Time >= 720) Time -= 720
    }

    var h = 0
    for(i in 1..6)  if(!visit[i]) h += arr[i]

    if(h >= 100) h = 100

    print(h)
} // End of main

private fun checkVisit() : Boolean {
    for(i in 1..6) {
        if(!visit[i]) return false;
    }
    return true;
} // End of checkVisit

private fun checkArea() {
    Area = when(Time) {
        in 0 until 120 -> 1
        in 121 until 240 -> 2
        in 241 until 360 -> 3
        in 361 until 480 -> 4
        in 481 until 600 -> 5
        else -> 6
    }
} // End of checkArea