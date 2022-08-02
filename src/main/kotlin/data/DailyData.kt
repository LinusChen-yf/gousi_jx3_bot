package top.timewl.data

data class DailyData(
    val code : Int,
    val msg : String,
    val data : Data,
    val time: String,
)

data class Data(
    val date : String,
    val week : String,
    val war: String,
    val battle: String,
    val camp: String,
    val relief: String,
    val team: List<String>,
)

