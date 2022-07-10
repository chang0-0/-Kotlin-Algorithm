import java.io.*;
import java.util.*;

private lateinit var arr : Array<Array<Int>>

fun main() {
    var path : String = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_1152.txt";
    var br = BufferedReader( File(path).bufferedReader() );

    var str : String = br.readLine();

    var st = StringTokenizer(str);
    var count : Int = st.countTokens();
    println(count);

    arr = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    println("arr : ${Arrays.deepToString(arr)}")

} // End of main


