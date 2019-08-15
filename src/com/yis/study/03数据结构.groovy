/**
 * 数据结构
 */
package com.yis.study

/** ========================列表======================== */
def arrayList = new ArrayList()//java定义方式
def list = [1, 2, 3, 4, 5]
println list.class //输出ArrayList，所以默认定义的是ArrayList

//？？疑问：这不就是数组么？那么groovy中还有数组么？答案是有的
//1、将List转为数据
def array = [1, 2, 3, 4, 5] as int[]
println array.class
//直接强定义为数组类型
int[] array2 = [1, 2, 3, 4, 5]
println array2.class

/**
 * 列表排序
 */
def sortList = [6, -3, 9, 2, -7, 1, 5]
//Collections.sort(sortList)//java中排序
//sortList.sort()//groovy中排序
//自定义排序规则,绝对值排序
sortList.sort {
    a, b ->
        a == b ? 0 :
                Math.abs(a) < Math.abs(b) ? 1 : -1
}
println sortList

/**
 * 列表的查找
 */
def findList = [-3, 9, 6, 2, -7, 1, 5]
//int result = findList.find { return it % 2 == 0 }
//def result = findList.findAll {return it % 2 != 0 }
//def result = findList.any { return it % 2 != 0 }
//def result = findList.every() { return it % 2 == 0 }
//println findList.min{return Math.abs(it)}
//println findList.max{return Math.abs(it)}
//def num = findList.count { return it % 2 == 0 }

/** ========================映射======================== */
//def map = new HashMap() //java定义方式
//定义的时候可以省略单引号，默认为单引号
def colors = [red  : 'ff0000',
              green: '00ff00',
              blue : '0000ff']
//查找元素
println colors['red']
println colors.red
//添加单个元素
colors.yellow = 'ffff00'
//添加一个map
colors.complex = [red  : 'ff0000',
                  green: '00ff00',
                  blue : '0000ff']
println colors.toMapString()
println colors.getClass()//默认是LinkedHashMap，如果需要指定特定的Map可以使用 as 关键字，或者强类型定义

/**
 * Map操作详解
 */
def students = [
        1: [number: '0001', name: 'Bob',
            score : 55, sex: 'male'],
        2: [number: '0002', name: 'Johnny',
            score : 62, sex: 'female'],
        3: [number: '0003', name: 'Claire',
            score : 73, sex: 'female'],
        4: [number: '0004', name: 'Amy',
            score : 66, sex: 'male'],
]

/**
 * 遍历
 */
//遍历
//students.each {
//    println "this key is ${it.key};this value is ${it.value}"
//}
//
////带索引的遍历
//students.eachWithIndex { def student, int index ->
//    println "当前索引：${index} this key is ${student.key};this value is ${student.value}"
//}
//
////直接遍历key value
//students.each { key, value ->
//    println "this key is ${key};this value is ${value}"
//}
//
//students.eachWithIndex { key, value, index ->
//    println "当前索引：${index} this key is ${key};this value is ${value}"
//}

/**
 * 查找
 */
//查找第一个符合条件的
def entry = students.find { it.value.score > 60 }
println entry

//所有符合条件的
def entrys = students.findAll { it.value.score > 60 }
println entrys

//组合查找
def names = students.findAll {
    it.value.score > 60
}.collect {
    return it.value.name
}
println names

//统计所有符合的个数
def count = students.count { it.value.score > 60 }
println count

//分组
def group = students.groupBy {
    it.value.score >= 60 ? '及格' : '不及格'
}
println group.toMapString()

/**
 * 排序
 */
def sort = students.sort { def student1, def student2 ->
    Number score1 = student1.value.score
    Number score2 = student2.value.score
    return score1 == score2 ? 0 : score1 < score2 ? -1 : 1
}
println sort.toMapString()

/** ========================范围Range======================== */
//Range 继承与List ，操作可以参考List
def range = 1..10
println range[4]
println range.contains(10)
println range.from//起始值
println range.to//终止值

range.each {
    print it
}

def getGrade(Number number) {
    def result
    switch (number) {
        case 0..<60:
            result = '不及格'
            break
        case 60..100:
            result = '及格'
            break
    }
    return result
}

println getGrade(59)

