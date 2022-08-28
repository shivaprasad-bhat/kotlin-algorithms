package datastructures.searching

fun main() {
    val list = mutableListOf<Int>()
    var size: Int = 0

    print("Enter the size of elements in the list: ")
    size = readln().toInt()

    for (i in 1..size) {
        print("Enter element $i: ")
        list.add(readln().toInt())
    }
    println("Array size is ${list.size}")
    // Sorting because binary search require sorted collections
    list.sort()

    print("Enter the element to be searched: ")
    val key = readln().toInt()

    val result = binarySearch(key, list)
    if (result == -1) println("Element not found") else println("Element found at the position $result")
}

/**
 * Function that performs the binary search
 * Complexity O(log_n)
 * Accepts the Int type and performs search
 * Returns -1 if element is not found
 * Returns the index if element is found
 */
fun binarySearch(element: Int, list: List<Int>): Int {
    var low = 0
    var high = list.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        when {
            element < list[mid] -> {
                high = mid - 1
            }

            element > list[mid] -> {
                low = mid + 1
            }

            else -> return mid
        }
    }
    return -1
}