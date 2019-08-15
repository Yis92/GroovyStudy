package com.yis.study.objectorention

/**
 * 类的定义
 * groovy默认都是public
 */
class Person implements Action {

    String name

    Integer age

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }

    /**
     * 一个方法找不到时，调用它替代
     * @param name
     * @param args
     * @return
     */
    def invokeMethod(String name, Object args) {
        return "这样就不会出错了"
    }

    /**
     * 优先级高于invokeMethod
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name, Object args) {
        return "the method ${name} is missing"
    }
}
