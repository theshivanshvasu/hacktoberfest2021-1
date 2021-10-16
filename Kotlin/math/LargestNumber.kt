/**
 *  This Function Finds the largest value in a list
 */
/**
 * @param list: List<Int>
 * @return largest: Int
 */
fun findLargest(list: List<Int>) : Int{
        var largest: Int = list[0]
        for (i in list) {
            if (i > largest){
                largest = i;
            }
        }
        return largest
    }
/**
 * @Usage
 *  main() {
 *      print("Largest number :${findLargest(listOf(1,2,3,4,565,43,21))}")
 *  }
 *  @output
 *  565
 */