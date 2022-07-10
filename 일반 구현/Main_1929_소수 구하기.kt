import java.util.*;
import java.io.*;

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_1929.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())
    var sb = StringBuilder();

    var M = st.nextToken().toInt()
    var N = st.nextToken().toInt()
    var arr = Array(N+1, {false})
    arr[0] = true; arr[1] = true;

    for(i in 2.. Math.sqrt(N+1.toDouble()).toInt()) {
        if(arr[i] == true) {
            continue;
        }

        for(j in i*i..N step +i) {
            arr[j] = true;
        }
    }

    for(i in M..N) {
        if(arr[i] == false) {
            sb.append(i).append('\n')
        }
    }

    print(sb)
} // End of main
