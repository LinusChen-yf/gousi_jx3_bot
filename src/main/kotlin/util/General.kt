package top.timewl.util


import com.alibaba.fastjson.JSON
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import top.timewl.Jx3
import top.timewl.data.DailyData
import top.timewl.data.JokeData
import top.timewl.data.JournalData

internal val httpClient by lazy {
    Jx3.client
}

internal val logger by lazy {
    Jx3.logger
}

internal suspend fun getDaily() : String{

    val response : HttpResponse = httpClient.get("https://www.jx3api.com/app/daily"){
        parameter("server","梦江南")
    }
    val body: String = response.body()
    val dailyData = JSON.parseObject(body, DailyData::class.javaObjectType)
    val result = StringBuffer("大师兄日常播报\n");
    result.append("[时间] ${dailyData.data.date} 星期${dailyData.data.week}\n")
    result.append("[大战] ${dailyData.data.war}\n")
    result.append("[战场] ${dailyData.data.battle}\n")
    result.append("[驰援] ${dailyData.data.relief}\n")
    result.append("[阵营] ${dailyData.data.camp}\n")
    result.append("[周常] ${dailyData.data.team[1]}\n        ${dailyData.data.team[2]}\n")
    result.append("[公共] ${dailyData.data.team[0]}\n")

    return result.toString()

}

internal suspend fun getJoke() : String{

    val response : HttpResponse = httpClient.get("https://www.jx3api.com/app/random")
    val body: String = response.body()
    val jokeData = JSON.parseObject(body, JokeData::class.javaObjectType)

    return jokeData.data.text;

}

internal suspend fun getJournal() : String{

    val response : HttpResponse = httpClient.get("https://www.jx3api.com/transmit/random")
    val body: String = response.body()
    val jokeData = JSON.parseObject(body, JournalData::class.javaObjectType)

    return jokeData.data.text;

}