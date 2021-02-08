package com.wlcookies.funsometools

import org.junit.Test

// 定义一个具体行为
interface ITask {
    fun doTask()
}

// 具体实现行为的类 A
class ConcreteA : ITask {
    override fun doTask() {
        println("我是A，我在做事情……")
    }
}

// 具体实现行为的类 B
class ConcreteB : ITask {
    override fun doTask() {
        println("我是B，我在做事情……")
    }
}

class Delegate(task: ITask) : ITask by task


// 负责在各个具体角色实例之间做出决策，判断并调用具体实现的方法
//class Delegate(private val flag: String) : ITask {
//    override fun doTask() {
//        when (flag) {
//            "A" -> {
//                // 通过A做事情
//                ConcreteA().doTask()
//            }
//            "B" -> {
//                // 通过B做事情
//                ConcreteB().doTask()
//            }
//            else -> {
//                println("我自己啥都不会做")
//            }
//        }
//    }
//}

class ExampleUnitTest {
    @Test
    fun client() {
        Delegate(ConcreteA()).doTask()
        Delegate(ConcreteB()).doTask()
    }
}