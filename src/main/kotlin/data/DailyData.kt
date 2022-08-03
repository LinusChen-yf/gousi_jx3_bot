package top.timewl.data

data class DailyData(
    val code : Int,
    val msg : String,
    val data : DailyContent,
    val time: String,
)

data class DailyContent(
    val date : String,
    val week : String,
    val war: String,
    val battle: String,
    val camp: String,
    val relief: String,
    val team: List<String>,
)

