private var result = Integer.MAX_VALUE
private lateinit var Words : Array<String>
private lateinit var visit : Array<Boolean>
private lateinit var Target : String

fun main() {
    var begin = "hit"
    var target = "cog"
    var words : Array<String> = arrayOf<String>( "hot", "dot", "dog", "lot", "log", "cog" )

    println(solution(begin, target, words))
} // End of main

fun solution(begin: String, target: String, words: Array<String>): Int {
    Words = words;
    visit = Array<Boolean>(Words.size, {false})
    Target = target;

    DFS(begin, 0);

    if(result == Int.MAX_VALUE) {
        return 0;
    }

    return result;
} // End of solution

fun DFS(begin : String, count : Int) {

    if( begin.equals(Target) ) {
        result = Math.min(result, count);
        return;
    }

    var len = Words.size;
    for(i in 0..len-1) {

        if(visit[i]) continue;

        if( check(begin, Words[i]) ) {
            visit[i] = true
            DFS(Words[i], count + 1);
            visit[i] = false;
        }
    }

} // End of DFS

fun check(begin : String, word : String) : Boolean {
    var count = 0;

    for(i in 0..begin.length-1) {
        var ch = begin[i];
        var ch2 = word[i]

        if(ch == ch2) {
            count ++;
        }
    }

    if( count == begin.length-1 ) {
        return true;
    }

    return false;
} // End of check