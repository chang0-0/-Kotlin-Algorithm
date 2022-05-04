import java.io.*;
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun main() {
    var path : String = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_1302.txt"
    var br = BufferedReader(File(path).bufferedReader());
    var N = Integer.parseInt(br.readLine())

    var map = HashMap<String, Int>();
    while(N-->0) {
        var name : String = br.readLine()
        map.put(name, map.getOrDefault(name, 0) +1);
    }

    val sortedMap = sortMapByKey(map);
    var max = Int.MIN_VALUE;
    var result : String = ""

    for((key, value) in sortedMap) {
        if(max < value) {
            max = value;
            result = key;
        }
    }

    print(result)
} // End of main

// key순으로 정렬
fun sortMapByKey(map : Map<String, Int>) : LinkedHashMap<String, Int> {
    val entries = LinkedList(map.entries)

    entries.sortBy{ it.key }

    val result = LinkedHashMap<String, Int>();
    for(entry in entries) {
        result[entry.key] = entry.value
    }

    return result
}