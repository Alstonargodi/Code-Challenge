class Accumulate {

//    static accumulate(Collection collection, Closure func) {
//        return collection.collate(func)
//    }

    //https://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Collection.html

    static accumulate(Collection collection, Closure func) {
        collection ? [func(collection.head()), *accumulate(collection.tail(),func)] : []
    }
}
