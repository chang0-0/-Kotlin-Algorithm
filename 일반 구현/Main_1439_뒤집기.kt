import java.io.*;

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_1439.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var S = br.readLine().toCharArray();

    var one = 0;
    var zero = 0;
    var ch = ' ';

    for(s in S) {

        // 서로 다른 문자가 들어올 때 한번만 count함.
        if(ch != s) {
            ch = s
            when(s) {
                '1' -> one++;
                else -> zero++;
            }
        }
    }

    one = Math.min(one, zero);
    print(one)
} // End of main