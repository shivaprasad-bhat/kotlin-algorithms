package datastructures.searching

fun main() {
    print("Choose the searching type ->\n 1. Linear Search.\n 2. Binary Search.\n------->")
    when (readln().toInt()) {
        1 -> search(SearchTypes.LINEAR)
        2 -> search(SearchTypes.BINARY)
        else -> println("Invalid choice")
    }
}

/**
 * Function that performs search and publishes the result
 */
fun search(type: SearchTypes) {
    val array = mutableListOf<Int>()

    print("Enter the size of elements in the list: ")
    val size: Int = readln().toInt()

    for (i in 1..size) {
        print("Enter element $i: ")
        array.add(readln().toInt())
    }
    println("Array size is ${array.size}")

    print("Enter the element to be searched: ")
    val key = readln().toInt()

    val result = when (type) {
        SearchTypes.LINEAR -> linearSearch(key, array)
        else -> {
            array.sort()
            binarySearch(key, array)
        }
    }

    if (result == -1) println("Element not found") else println("Element found at the position $result")
}

/**
 * Function that performs the linear search
 * Complexity O(n)
 * Accepts the generic type and performs search
 * Returns -1 if element is not found
 * Returns the index if element is found
 */
fun <T> linearSearch(key: T, list: List<T>): Int {
    for ((index, element) in list.withIndex()) {
        if (element == key) return index
    }
    return -1
}

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

enum class SearchTypes {
    LINEAR, BINARY
}
