package com.wlcookies.library.utils

import android.app.Activity

/**
 * ```
 * Activity栈简单管理，一般在BaseActivity中 onCreate 添加、onDestroy 移除
 *
 * 创建时间： 2/8/21
 * 更新说明： `[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]`
 *  1. -
 * ```
 * @author wg
 */
object ActivityControllerUtil {

    // 存储Activity容器
    private val activities = ArrayList<Activity>()

    /**
     * 向容器中添加一个Activity
     *
     * @param [activity] Activity
     */
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    /**
     * 在容器中移除一个Activity
     *
     * @param [activity] Activity
     */
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    /**
     * 清除容器中所有Activity
     */
    fun removeAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }
}