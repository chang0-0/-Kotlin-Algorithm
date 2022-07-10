import java.io.*;

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_10809.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var sb = StringBuilder();

    var arr = IntArray(26, {-1});
    var str = br.readLine();
    var len = str.length;

    for(i in 0..len-1) {
        var ch = str[i].toInt() - 97;
        if(arr[ch] == -1) {
            arr[ch] = i;
        }
    }

    arr.forEach { sb.append("${it} ") }
    print(sb)
} // End of main