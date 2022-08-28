package datastructures.searching

/**
 * As example, passing list of integers
 */
fun main() {
    val array = mutableListOf<Int>()
    var size: Int = 0

    print("Enter the size of elements in the list: ")
    size = readln().toInt()

    for (i in 1..size) {
        print("Enter element $i: ")
        array.add(readln().toInt())
    }
    println("Array size is ${array.size}")

    print("Enter the element to be searched: ")
    val key = readln().toInt()

    val result = linearSearch(key, array)
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