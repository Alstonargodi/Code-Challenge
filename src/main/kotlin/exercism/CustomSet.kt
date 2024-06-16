package exercism

import java.util.HashSet


class CustomSet(vararg elements: Int) {

    // TODO: implement proper constructor
    private val data: MutableSet<Int> = if (elements.isEmpty()){
        HashSet<Int>()
    } else{
        elements.toMutableSet()
    }

    fun isEmpty(): Boolean = data.isEmpty()

    fun isSubset(other: CustomSet): Boolean = other.data.containsAll(data)

    fun isDisjoint(other: CustomSet): Boolean = intersection(other).isEmpty()

    fun contains(other: Int): Boolean = data.contains(other)

    fun intersection(other: CustomSet): CustomSet {
        val intersection = CustomSet()
        intersection.data.addAll(data)
        intersection.data.retainAll(other.data)
        return intersection
    }

    fun add(other: Int) {
        data.add(other)
    }

    override fun equals(other: Any?): Boolean =
        other is CustomSet && data == other.data

    operator fun plus(other: CustomSet): CustomSet {
        val result = CustomSet()
        result.data.addAll(data)
        result.data.addAll(other.data)
        return result
    }

    operator fun minus(other: CustomSet): CustomSet {
        val result = CustomSet()
        result.data.addAll(data)
        result.data.removeAll(other.data)
        return result
    }
}
