
/**
 * Created by jemo on 12/8/16.
 */

inline fun View.afterMeasured(crossinline f: View.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredHeight > 0 && measuredWidth > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                f()
            }
        }
    })
}

fun View.stayVisibleOrGone(stay: Boolean) {
    if (stay) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

fun View.stayVisibleOrInVisible(stay: Boolean) {
    if (stay) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.INVISIBLE
    }
}

fun View.toast(msg: String, toastLength: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, msg, toastLength).show()
}
