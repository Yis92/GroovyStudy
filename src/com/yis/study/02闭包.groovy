/**
 * 闭包
 */
package com.yis.study

//定义闭包
def par = { println 'Hello groovy' }
//两种调用闭包的方式
par.call()
par()

/** ========================参数======================== */
//参数  '->' 之前是参数，之后是闭包体
def myName = { String name -> println "Hello 名字 ${name}" }
myName.call('liu')
myName('liu')

//如果只有一个参数可以不定义，默认为it
def itName = { println "Hello 名字 ${it}" }
itName.call('itName')
itName('itName')

//多个参数
def student = { String name, int age -> println "Hello 名字 ${name} , 年龄：${age}" }
student.call('liu', 18)
student('liu', 18)

/** ========================返回值======================== */
//闭包始终是有返回值的,默认以最后一行作为返回值，如果没有返回值则返回null
def closure = {
    println 'hello groovy'
}

//疑问，closure 是什么类型？（输出：$_run_closure5）
println closure.class

def result = closure.call()

println result

/** ========================与基本类型的结合使用======================== */
int x = fab(5)
println x
//用来求指定number的阶乘
int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

/** ========================与String类型的结合使用======================== */
//each 遍历
String str = 'the 2 and 3 is 5'
//str.each {print it}

//find来查找符合条件的第一个
def findResult = str.find { it.isNumber() }
println findResult

/** ========================闭包三个重要变量 this owner delegate======================== */

//这么看三个输出都是一样的，都是输出当前类对象
//def scriptClosure = {
//    println "scriptClosure this : ${this}"//代表闭包定义处的类
//    println "scriptClosure owner : ${owner}"//代码闭包定义处的类或者对象
//    println "scriptClosure delegate : ${delegate}"//对表任意对象，默认值与owner一致
//}
//scriptClosure.call()

/**
 * 当在闭包嵌套的情况下就可以看出 this 与 owner、delegate 的区别了
 * this 指向的一直都是当前最近(目前指的是02闭包类，如果this是在内部类中，就会指向内部类)的脚本类对象
 * owner、delegate 都是指向最近的闭包对象
 */
def outClosure = {
    def inClosure = {
        println "scriptClosure this : " + this//代表闭包定义处的类
        println "scriptClosure owner : " + owner //代码闭包定义处的类或者对象
        println "scriptClosure delegate : " + delegate//对表任意对象，默认值与owner一致
    }
    inClosure.call()
}
outClosure.call()

/**
 * owner 、delegate 的区别
 *
 * 默认情况下delegate = owner，但是当我们主动去修改了delegate的时候，此时二者就不相同了
 *
 */
class PersonBean {}

PersonBean p = new PersonBean()

def outTwoClosure = {
    def inTwoClosure = {
        println "scriptClosureTwo this : " + this//代表闭包定义处的类
        println "scriptClosureTwo owner : " + owner //代码闭包定义处的类或者对象
        println "scriptClosureTwo delegate : " + delegate//对表任意对象，默认值与owner一致
    }
    inTwoClosure.delegate = p //修改默认的delegate
    inTwoClosure.call()
}
outTwoClosure.call()

/** ========================闭包委托策略======================== */
class Student {
    String name
    def pretty = { "My name is ${name}" }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: "liu")
def teacher = new Teacher(name: "zhang")

stu.pretty.delegate = teacher //修改闭包包委托对象
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST//设置委托策略

//原本应该输出的是liu，但是输出了委托对象Teacher中的值zhang
println stu.toString()