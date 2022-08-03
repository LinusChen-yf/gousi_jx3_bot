package top.timewl.data

data class JokeData(
    val code : Int,
    val msg : String,
    val data : JokeContent,
    val time: String,
)

data class JokeContent(
    val id : Int,
    val text : String,
)