import java.io.*;
import java.util.*;

fun main() {
    var path : String = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_1152.txt";
    var br = BufferedReader( File(path).bufferedReader() );

    var str : String = br.readLine();

    var st = StringTokenizer(str);
    var count : Int = st.countTokens();
    print(count);
} // End of main


