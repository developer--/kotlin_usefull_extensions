# kotlin useful extensions

<b>Ex: Retrofit enqueue in java</b>
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


<b>Kotlin way</b>
```kotlin
request.enqueue(callback({ r -> callBack.onResponse(r.body())}, { t -> callBack.onFailed(t.message)}))
```




<b>Example of painfull function in java for adding listener to get view's height and width</b>
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

<b>Let's do the same in Kotlin</b>
```kotlin
mView.afterMeasured {
  // inside this block the view is completely drawn
}
