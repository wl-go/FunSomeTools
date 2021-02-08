package com.wlcookies.library.config

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


/**
 * ```
 * Logger配置
 *
 * 创建时间： 2/8/21
 * 更新说明： `[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]`
 *  1. -
 * ```
 * @author wg
 */
object LoggerConfig {
    /**
     *  日志工具相关配置
     *
     * @param [tag] String 设置日志标签
     * @param [logControl] Boolean 日志开关控制
     */
    fun init(tag: String, logControl: Boolean = false) {
        Logger.addLogAdapter(object :
            AndroidLogAdapter(
                PrettyFormatStrategy
                    .newBuilder()
                    .tag(tag)
                    .build()
            ) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return logControl
            }
        })
    }
}