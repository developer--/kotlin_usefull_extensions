# kotlin useful extensions

Example of painfull function for adding listener to get view's height, width or any property 
```kotlin
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
```

after that you can write 
```java
mAnyTypeView.afterMeasured {
  // inside this block the view is completely drawn
  // you can get an initialized height, width and e.t.c
}
