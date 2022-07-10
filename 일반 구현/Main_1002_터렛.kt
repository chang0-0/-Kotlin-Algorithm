import java.io.*;
import java.util.*;

// 두 원의 중심이 같고, 반지름도 같을 때, (접점의 개수가 무한개) -> -1
// 접점이 없을 때, 두 점 사이의 거리가 각 원의 반지름의 합보다 클 때 (겹치는 부분이 없을 때) -> 0
// 한 원 안에 다른 원이 있으면서 접점이 없을 때 (내접 해서 접점이 없을 때,) -> 0
// 이 외는 접점이 있음.

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현.res\\input_bj_1002.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var sb = StringBuilder()

    var arr : IntArray = IntArray(6);
    var N = br.readLine().toInt()
    while(N-->0) {
        var st = StringTokenizer(br.readLine());

        var x1 = st.nextToken().toInt();
        var y1 = st.nextToken().toInt();
        var r1 = st.nextToken().toInt();
        var x2 = st.nextToken().toInt();
        var y2 = st.nextToken().toInt();
        var r2 = st.nextToken().toInt();

        sb.append(geometry(x1, y1, r1, x2, y2, r2)).append('\n')

    }

    println(sb)

} // End of main

fun geometry(x1 : Int, y1 : Int, r1 : Int, x2 : Int, y2 : Int, r2 : Int) : Int{

    var distance_pow = ( Math.pow((x2 - x1).toDouble(), 2.0) + Math.pow((y2 - y1).toDouble(), 2.0)).toInt();
    println("distance_pow : ${distance_pow}")

    if(x1 == x2 && y1 == y2 && r1 == r2) {
        return -1;
    }
    else if(distance_pow > Math.pow((r1 + r2).toDouble(), 2.0) ){
        return 0;
    }
    else if(distance_pow < Math.pow((r2 - r1).toDouble(), 2.0) ) {
        return 0;
    }
    else if(distance_pow == (Math.pow((r2 - r1).toDouble() , 2.0)).toInt()) {
        return 1;
    }

    else if(distance_pow == Math.pow((r1 + r2).toDouble() , 2.0).toInt() ) {
        return 1;
    }

    else {
        return 2;
    }

} // End of geometry