/**
 * Factorial of a number
 * @param number:Integer whose factorial is to be calculated
 */
fun factorial(number: Int) : Float {
    return if (number > 1) number * factorial(number-1) else  1.0f
}
/**
 * @usage
 * print(factorial(5))
 * @returns 120.0
 */