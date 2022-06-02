import java.io.*;

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DP 부수기\\res\\11727.txt"
    val br = BufferedReader(File(path).bufferedReader())

    val N = br.readLine().toInt();
    val memoization = Array(1001, {0})
    memoization[1] = 1;
    memoization[2] = 3;
    memoization[3] = 5;

    for(i in 4..N) {
        memoization[i] = (memoization[i-1] + 2 * memoization[i-2]) % 10007
    }

    print(memoization[N])
} // End of main