import java.util.*;
import java.io.*;
import kotlin.math.*;

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_1546.txt"
    var br = BufferedReader(File(path).bufferedReader())

    var N = Integer.parseInt(br.readLine())
    var st = StringTokenizer(br.readLine())
    var arr = IntArray(N);
    var max = Integer.MIN_VALUE / 16;

   for(i : Int in 0 until N) {
        var num = st.nextToken().toInt();
        arr[i] = num;
        max = max(max, num);
    }

    var sum = 0.00;
    for(i in arr) {

        sum += (100.00*i)/max;
    }

    print(sum / N)
} // End of main fun