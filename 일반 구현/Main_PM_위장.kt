import java.util.*

fun main() {
    var clothes = arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"))
    println(solution(clothes))
} // End of main

fun solution(clothes: Array<Array<String>>): Int {
    var map = HashMap<String, Int>();

    clothes.forEach {
        var type = it[1]
        map.put(type, map.getOrDefault(type, 0) + 1);
    }

    var answer = 1;
    var it : Iterator<Int> = map.values.iterator()

    while(it.hasNext()) {
        answer *= it.next() + 1;
    }

    // none, none 조합 제거
    return answer - 1;
} // End of solution