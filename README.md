# kotlin useful extensions

<H3><b>Retrofit enqueue in java</b></H3>
```java
request.enqueue(new Callback<RegisterResponse>() {
       @Override
       public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response)                 
              callback.onResponse(response.body());
       }

       @Override
       public void onFailure(Call<RegisterResponse> call, Throwable t) {
            callback.onFailed(t.getMessage());
       }       
});
```


<H3><b>Kotlin way</b></H3>
```kotlin
request.enqueue(callback({ r -> callBack.onResponse(r.body())}, { t -> callBack.onFailed(t.message)}))
```




<H3><b>Example of painfull function in java for adding listener to get view's height and width</b></H3>
```java
ViewTreeObserver vto = mView.getViewTreeObserver(); 
vto.addOnGlobalLayoutListener (new OnGlobalLayoutListener() { 
    @Override 
    public void onGlobalLayout() {
        layout.getViewTreeObserver().removeOnGlobalLayoutListener(this); 
        int width  = layout.getMeasuredWidth();
        int height = layout.getMeasuredHeight(); 

    } 
});
```

<H3><b>Let's do the same in Kotlin</b></H3>
```kotlin
mView.afterMeasured {
  // inside this block the view is completely drawn
}
