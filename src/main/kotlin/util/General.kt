package top.timewl.util


import com.alibaba.fastjson.JSON
import net.mamoe.mirai.utils.info
import okhttp3.*
import top.timewl.Jx3
import top.timewl.data.DailyData


internal val logger by lazy {
    Jx3.logger
}

internal fun getDaily() : String{

    val client = OkHttpClient()
    val headers = Headers.Builder().build()
    val formBody: FormBody = FormBody.Builder()
        .add("server", "梦江南")
        .build()
    val request: Request = Request.Builder().url("https://www.jx3api.com/app/daily")
        .headers(headers).post(formBody).build()
    val response: Response = client.newCall(request).execute()
    val body = response.body?.string()
    val dailyData = JSON.parseObject(body, DailyData::class.javaObjectType)

    val result = StringBuffer("大师兄日常播报\n");
    result.append("[时间] ${dailyData.data.date} 星期${dailyData.data.week}\n")
    result.append("[大战] ${dailyData.data.war}\n")
    result.append("[战场] ${dailyData.data.battle}\n")
    result.append("[驰援] ${dailyData.data.relief}\n")
    result.append("[阵营] ${dailyData.data.camp}\n")
    result.append("[周常] ${dailyData.data.team[1]}\n        ${dailyData.data.team[2]}\n")
    result.append("[公共] ${dailyData.data.team[0]}\n")

    logger.info { "test" + dailyData }

    return result.toString()

}