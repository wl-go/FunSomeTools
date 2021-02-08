package com.wlcookies.library.utils

import android.annotation.SuppressLint
import com.orhanobut.logger.Logger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow

fun Any.log() {
    Logger.d(this)
}

fun String.md5() = try {
    val instance: MessageDigest = MessageDigest.getInstance("MD5")//获取md5加密对象
    val digest: ByteArray = instance.digest(this.toByteArray())//对字符串加密，返回字节数组
    val sb: StringBuffer = StringBuffer()
    for (b in digest) {
        val i: Int = b.toInt() and 0xff//获取低八位有效值
        var hexString = Integer.toHexString(i)//将整数转化为16进制
        if (hexString.length < 2) {
            hexString = "0$hexString"//如果是一位的话，补0
        }
        sb.append(hexString)
    }
    sb.toString()
} catch (e: Exception) {
    e.printStackTrace()
    ""
}

/**
 * 获取UUID，去除'-'
 */
fun getUUID() = UUID.randomUUID().toString().replace("-", "")

/**
 * 时间戳(yyyyMMddHHmmss) + num位随机数
 *
 * @param [num] Int 随机数个数，默认6位
 */
fun getTimeUUID(num: Int = 6) =
    Date().format(FORM_DATE_STR_2) + ((Math.random() * 9 + 1) * (10.0.pow(num * 1.0)
        .toInt())).toInt()


const val FORM_DATE_STR_1 = "yyyy-MM-dd HH:mm:ss"
const val FORM_DATE_STR_2 = "yyyyMMddHHmmss"

@SuppressLint("SimpleDateFormat")
fun Date.format(formatStr: String = FORM_DATE_STR_1) =
    SimpleDateFormat(formatStr).format(this)