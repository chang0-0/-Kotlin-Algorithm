import java.util.*
import kotlin.collections.LinkedHashMap

fun main() {
    val map = LinkedHashMap<Int, String>()
    map[70] = "a" // 삽입 방법 1
    map.put(1, "b") // 삽입 방법 2
    map.put(8, "c")
    println(map)
    // key를 기준으로 정렬

    val sortedMap = sortMapByKey(map)
    println(sortedMap)
} // End of main

private fun sortMapByKey(map : Map<Int, String>) : LinkedHashMap<Int, String> {
    val ent = LinkedList(map.entries)
    ent.sortBy { it.key }

    val result = LinkedHashMap<Int, String>()
    for(e in ent) {
        result.put(e.key, e.value)
    }
    return result
} // End of sortMapByKey