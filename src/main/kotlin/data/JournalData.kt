package top.timewl.data

data class JournalData(
    val code : Int,
    val msg : String,
    val data : JournalContent,
    val time: String,
)

data class JournalContent(
    val id : Int,
    val text : String,
)