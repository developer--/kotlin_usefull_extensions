inline fun Animation.setAnimationListener(
        func: __AnimationListener.() -> Unit) {
    val listener = __AnimationListener()
    listener.func()
    setAnimationListener(listener)
}
