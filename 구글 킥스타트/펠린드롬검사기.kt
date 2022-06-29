import java.util.*
import java.io.*

fun main() {
    var r = 0; var sum = 0; var temp = 0;
    var n = 454

    temp = n
    while(n>0) {
        r = n % 10
        sum = (sum * 10) + r
        n = n/10
    }

    if(temp == sum) print("is palindrome")
    else print("is not palindrome")
} // End of main