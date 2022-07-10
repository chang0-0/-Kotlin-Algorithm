import java.io.*;
import java.util.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_2960.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine());

    var N = st.nextToken().toInt();
    var K = st.nextToken().toInt();
    var arr = BooleanArray(N+1);
    var count = 0;

    for(i in 2..N) {
        for(j in i..N step +i) {

            if(!arr[j]) {
               count++;
                arr[j] = true;
            }

            if(count == K) {
                println(j);
                return;
            }
        }
    }

} // End of main
