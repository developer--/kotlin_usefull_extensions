/**
* The function receives the two sets of items, and another function. This last parameter will be used in areItemsTheSame 
* to decide whether two items are the same or not.
*/

fun <T> RecyclerView.Adapter<*>.autoNotify(oldList: List<T>, newList: List<T>, compare: (T, T) -> Boolean) {
    val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return compare(old[oldItemPosition], newList[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size
    })

    diff.dispatchUpdatesTo(this)
}


// usage example 
// var items: List<Content> by Delegates.observable(emptyList()) {
//    prop, oldList, newList ->
//    autoNotify(oldList, newList) { o, n -> o.id == n.id }
// }