var flag: Boolean = false
fun isPrime(num: Int) = when {
    num > 1 -> { for (i in 2..num) flag = if (num % i == 0) true else false }
    else -> flag = false
}