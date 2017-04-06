package com.sec.android.app.sns323.outer.extensions

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by user-00 on 4/6/17.
 */
fun <T> callback1(fn: (Throwable?, Response<T>?) -> Unit): Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) = fn(null, response)
        override fun onFailure(call: Call<T>, t: Throwable) = fn(t, null)
    }
}

fun <T> callback(success: (Response<T>) -> Unit, failure: (t: Throwable) -> Unit): Callback<T>? {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) = success(response)
        override fun onFailure(call: Call<T>, t: Throwable) = failure(t)
    }
}