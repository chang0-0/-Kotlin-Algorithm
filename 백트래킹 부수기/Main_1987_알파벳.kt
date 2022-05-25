import java.util.*;
import java.io.*;

private val dirX = arrayOf(0, 0, -1, 1) // 상 하 좌 우
private val dirY = arrayOf(-1, 1, 0, 0) // 상 하 좌 우
private lateinit var arr : Array<Array<Char>>
private lateinit var alp : Array<Array<Int>>

private var R = 0;
private var C = 0;
private var nowX = 0; private var nowY = 0;
private var result = Int.MIN_VALUE;

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input_bj_1987.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    R= st.nextToken().toInt()
    C = st.nextToken().toInt()
    arr = Array(R){Array(C) {' '}}
    alp = Array(R){Array(C) {0}}

    for(i in 0..R-1) {
        var temp = br.readLine()
        for(j in 0..C-1) {
            arr[i][j] = temp[j];
        }
    }

    // 비트레이트 연산
    DFS(0, 0, 1 shl arr[0][0]-'A', 1);
    println(result)
} // End of main

private fun DFS(x : Int, y : Int, bit : Int, count : Int) {

    if(alp[x][y] == bit) return;
    alp[x][y] = bit;

    result = Math.max(result, count);

    for(i in 0..3) {
        nowX = x + dirX[i];
        nowY = y + dirY[i];

        if(nowX<0||nowY<0||nowX==R||nowY==C) continue;
        if( (bit and (1 shl arr[nowX][nowY]-'A')) !=0 ) continue;
        DFS(nowX, nowY, bit or (1 shl arr[nowX][nowY]-'A'), count+1)
    }
} // End of DFS