fun RequestCreator.into(
        target: ImageView, 
        func: __Callback.() -> Unit) {
    val callback = __Callback()
    callback.func()
    into(target, callback)
}

class __Callback : Callback {

    private var _onSuccess: (() -> Unit)? = null
    private var _onError: (() -> Unit)? = null

    override fun onSuccess() {
        _onSuccess?.invoke()
    }

    fun onSuccess(func: () -> Unit) {
        _onSuccess = func
    }

    override fun onError() {
        _onError?.invoke()
    }

    fun onError(func: () -> Unit) {
        _onError = func
    }
}
