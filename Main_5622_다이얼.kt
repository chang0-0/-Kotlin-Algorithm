import java.io.*;

var arr = intArrayOf(3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10);

fun main(args: Array<String>) {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_5622.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var result = 0;

    var str = br.readLine().toCharArray();
    for(ch in str) {
        result += check_num(ch);
    }

    println(result)

} // End of main

fun check_num(num : Char) :Int {
    var result = arr[num.toInt() - 65];

    return result
} // End of check_num2