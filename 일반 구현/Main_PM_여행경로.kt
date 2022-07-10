import java.util.*;

private lateinit var Tickets : Array<Array<String>>
private lateinit var visit : Array<Boolean>
private var len : Int = 0;
private var list : MutableList<String> = ArrayList<String>();
private var sb = StringBuilder();

fun main() {
    var tickets = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL","SFO"),
    );

    println( Arrays.toString(solution(tickets)) );
} // End of main

fun solution(tickets: Array<Array<String>>): Array<String> {
    Tickets = tickets;
    len = tickets.size;
    visit = Array<Boolean>(len, {false});

    // tickests (문자형)2차원 배열 정렬
    Tickets.sortWith{x,y->
            if(x[0].equals(y[0])) {
                x[1].compareTo(y[1])
            }
            else x[0].compareTo(y[0])
    }

    DFS("ICN", "ICN", 0);

    var result = list.get(0);
    var st = StringTokenizer(result);
    var answer = Array<String>(len+1, {""});
    for(i in 0..len) {
        answer[i] = st.nextToken();
    }

    return answer
} // End of solution


private fun DFS( boarding : String, route : String, depth : Int) {
    sb = StringBuilder();

    if(depth == len) {
        list.add( route )
        return;
    }

    for(i in 0..len-1) {
        if(visit[i]) continue;

        if(Tickets[i][0].equals(boarding)) {
            visit[i] = true;
            sb.append(route).append(" ").append(Tickets[i][1]);
            DFS(Tickets[i][1], sb.toString() , depth + 1);
            visit[i] = false;
        }
    }

} // End of DFS