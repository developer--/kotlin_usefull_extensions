# kotlin useful extensions

Ex: Retrofit enqueue
```kotlin
request.enqueue(callback({ r -> callBack.onResponse(r.body())}, { t -> callBack.onFailed(t.message)}))
```

Example of painfull function in java for adding listener to get view's height and width
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

Let's do the same in Kotlin
```kotlin
mView.afterMeasured {
  // inside this block the view is completely drawn
}
