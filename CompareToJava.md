# kotlin useful extensions

<b>Retrofit in Java</b>
```java
request.enqueue(new Callback<RegisterResponse>() {
       @Override
       public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response)                 
             //response hendling goes here
       }

       @Override
       public void onFailure(Call<RegisterResponse> call, Throwable t) {
            //error hendling goes here
       }       
});
```


<b>Retrofit in Kotlin</b>
```kotlin
request.enqueue(callback(
   { resp -> hendle response here }, 
   { err -> hendle error here }
))
```


<b>Picasso in Java</b>
```Java
Picasso.with(context).load(imageUrl).into(imageView,
        object : Callback {
            override fun onSuccess() {
                //we are happy here
            }

            override fun onError() {
                // bla bla bla
            }
        })
```

<b>Picasso in Kotlin</b>
```kotlin
Picasso.with(context).load(imageUrl).into(imageView) {
    onSuccess {
        //we are happier here
    }
}
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
```


<b>Animation listner (all callbacks are optional ;) )</b>
```kotlin
animation.setAnimationListener {
    onAnimationRepeat {
        // do something
    }

    onAnimationEnd {
        // do something
    }
    
    onAnimationStart {
        // do something
    }
}
```
