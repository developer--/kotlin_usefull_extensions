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