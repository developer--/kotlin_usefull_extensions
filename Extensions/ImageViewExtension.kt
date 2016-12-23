fun ImageView.loadImage(imgUrl: String?) {
    if (imgUrl.isNotNull()) {
        this.visibility = View.VISIBLE
        Glide.with(context).load(imgUrl).into(this)
    } else {
        this.visibility = View.GONE
    }
}

fun ImageView.loadImage(imgUrl: Int?) {
    Glide.with(context).load(imgUrl).into(this)
}

fun ImageView.loadImage(imgDrawable: Drawable?) {
    this.setImageDrawable(imgDrawable)
}