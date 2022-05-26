import java.util.*;
import java.io.*;

private val N = 9;
private val arr = Array(N){Array(N){0}}
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\input_bj_2580.txt"
    val br = BufferedReader( File(path).bufferedReader() )

    for(i in 0 until N) {
        var st = StringTokenizer(br.readLine())
        for(j in 0 until N) {
            arr[i][j] = st.nextToken().toInt()
        }
    }
    
    sdoku(0, 0)
} // End of main

fun sdoku(x : Int, y : Int) {

    // 열이 9일 경우 다음행으로 넘어감 (줄바꿈)
    if(y == N) {
        sdoku(x + 1, 0);
        return;
    }

    // 행이 9가 됬을 경우, 모든 탐색 완료 종료.
    if(x == N) {
        val sb = StringBuilder();

        for(i in 0 until N) {
            for(j in 0 until N) {
                sb.append(arr[i][j]).append(' ')
            }
            sb.append('\n')
        }
        println(sb)
        System.exit(0);
    }

    // 스도쿠 배열에서 빈칸을 만났을 때,
    if(arr[x][y] == 0) {

        // 1 ~ 9까지 모든 숫자를 대입해보면서 조건에 맞는 숫자를 찾음
        for(i in 1 until 10) {
            
            // 조건이 true일 경우, 빈칸에 해당 숫자를 넣고
            // 다음 줄로 넘어감.
            if(check(x, y, i)) {
                arr[x][y] = i;
                sdoku(x, y + 1);
            }
        }

        arr[x][y] = 0;
        return;
    }

    sdoku(x, y + 1);
} // End of sdoku

fun check(x : Int , y : Int, value : Int) : Boolean {

    // 열에 value가 있으면, false를 반환
    for(i in 0 until N) {
        if(arr[x][i] == value) {
            return false;
        }
    }

    // 행도 검사해서 value가 있으면 false 처리
    for(i in 0 until N) {
        if(arr[i][y] == value) {
            return false;
        }
    }

    // x, y를 기준으로 3*3 배열의 시작점을 찾음
    val setX = (x / 3) * 3;
    val setY = (y / 3) * 3;

    // 3*3 배열에서 value와 겹치는 숫자가 있는지 검사
    for(i in setX until setX+3) {
        for(j in setY until setY+3) {
            if(arr[i][j] == value) {
                return false;
            }
        }
    }
    
    // 모든 조건 통과 하면 true를 반환
    return true;
} // End of check