package com.yis.study.objectorention

/**
 * 类似于抽象类与接口的结合体
 * 定义方式像抽象类，但是实现方式又于接口一样
 */
trait DefaultAction {

    abstract void eat()

    void play() {
        println 'i can play'
    }
}