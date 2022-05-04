import java.util.*;
import java.io.*;

fun main() {
    var path : String = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_1330.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    var num1 : Int = Integer.parseInt(st.nextToken())
    var num2 : Int = Integer.parseInt(st.nextToken())

    // when은 switch문의 대체이다.
    when {
        num1 > num2 -> print('>')
        num1 < num2 -> print('<')
        num1 == num2 -> print("==")
    }
} // End of main fun