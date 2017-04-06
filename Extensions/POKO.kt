/**
* check if any view is not null
*/
fun Any?.isNotNull(): Boolean = this != null


/**
* check if view is null
*/
fun Any?.isNull(): Boolean = this == null

/**
* check if the string isn't null or empty
*/
fun String?.isNotNullOrEmpty() = !isNullOrEmpty()
