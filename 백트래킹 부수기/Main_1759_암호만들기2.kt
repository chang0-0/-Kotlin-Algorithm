import java.io.*;
import java.util.*


fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input_bj_1759.txt"
    val br = BufferedReader( File(path).bufferedReader() )
    var st = StringTokenizer(br.readLine());
    var sb = StringBuilder()

    var L = st.nextToken().toInt();
    var C = st.nextToken().toInt();
    var arr = Array(C, {' '});
    var visit = Array(C, {false});

    st = StringTokenizer(br.readLine());

    for(i in 0..C-1) {
        arr[i] = st.nextToken()[0];
    }
    Arrays.sort(arr)

    fun check(str : String) : Boolean {

        var ch = str.toCharArray()
        val len = ch.size;
        var count = 0;
        var count2 = 0;

        for(i in 0..len-1) {

            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
                count++;
            }
            else {
                count2++;
            }
        }

        if(count > 0 && count2 >=2 ) {
            return true;
        }

        return false;
    } // End of check

    fun DFS(index : Int, depth : Int, str : String) {

        if(depth == L) {
            if(check(str)) {
                sb.append(str).append('\n')
                return;
            }
            return;
        }

        for(i in index..C-1) {

            if(visit[i]) continue;

            visit[i] = true;
            DFS(i+1, depth+1, str+arr[i]);
            visit[i] = false;
        }
    } // End of DFS

    DFS(0, 0, "");
    println(sb);

} // End of main
