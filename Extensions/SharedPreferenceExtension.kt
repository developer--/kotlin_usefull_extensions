fun SharedPreferences.apply(vararg pairs: Pair<String, Any?>) {
    edit().apply {
        pairs.forEach {
            when (it.second) {
                null -> remove(it.first)
                is Boolean -> putBoolean(it.first, it.second as Boolean)
                is Float -> putFloat(it.first, it.second as Float)
                is Int -> putInt(it.first, it.second as Int)
                is Long -> putLong(it.first, it.second as Long)
                is String -> putString(it.first, it.second as String)
            }
        }
    }.apply()
}

inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}
fun SharedPreferences.Editor.set(pair: Pair<String, Any>) {
    when {
        pair.second is Boolean -> putBoolean(pair.first, pair.second as Boolean)
        pair.second is String -> putString(pair.first, pair.second as String)
        pair.second is Long -> putLong(pair.first, pair.second as Long)
        pair.second is Int -> putInt(pair.first, pair.second as Int)
    }
}
