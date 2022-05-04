import java.util.*;
import java.io.*;

var max_height : Long = Long.MIN_VALUE /16;
var min_height = 1L;
var M = 0L;

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_2805.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine());

    var N : Long = st.nextToken().toLong(); // 나무의 수 N
    M = (st.nextToken()).toLong() // 나무의 길이 M
    val trees = LongArray(N.toInt()); // 나무 길이가 담긴 배열

    st = StringTokenizer(br.readLine())
    for(i in 0 until N) {
        trees[i.toInt()] = (st.nextToken()).toLong();
        max_height = Math.max(max_height, trees[i.toInt()]);
    }

    binary_search(trees);

} // End of main

// 절단기로 설정할 수 있는 높이의 최대값
private fun binary_search(trees : LongArray) {
    var middle_height = 0L;
    var sum = 0L;

    while(max_height >= min_height) {
        sum = 0;

        trees.forEach {
            // 나무의 길이가 절단기의 높이보다 크거나 같아야 자를 수 있음
            if(it >= middle_height) {
                sum += it - middle_height;
            }
        }

        // 잘라진 나무길이의 합(sum)이 원하는 나무 길이(M) 보다 클 경우
        // 높이를 높여야 함
        if(sum >= M) {
            min_height = middle_height + 1;
        }
        else {
            max_height = middle_height - 1;
        }

        middle_height = (max_height + min_height) / 2;
    }

    print(middle_height)
} // End of binary_search