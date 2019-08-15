/**
 * 定义变量
 */
package com.yis.study

/**
 * 强类型定义，申明的时候使用关键字指明变量类型
 * 基本类型的变量都会被转换成包装类对象类型
 */
int i = 1

println(i.class)//输出为Integer类型

/**
 * 若类型定义，申明的时候不需要指明变量的类型，会根据变量值动态的推导出变量的类型
 */
def j = 2

println(j.class)//输出为Integer类型

j = '哈哈'

println(j)//输出为String类型

//总结：当变量只用于当前自己模块使用的时候，可以使用def若类型进行变量的申明；
//如果当前模块会被其他模块调用的时候最好还是使用强类型对变量进行约束

/** ========================String======================== */
def name = 'Mr.liu'

println name.class//输出为String类型

//带格式的字符串
def content = '''
    good
    不错
'''

println content.class//输出为String类型

def age = "18岁"

println age.class//输出为String类型

def student = "${name}18岁"

println student.class//输出为GString类型

//总结：双引号相对与单引号可以使用扩展表达式
//String和GString是可以相互传递相互调用的，使用的时候不用刻意的去关注是什么类型

/** ========================Switch======================== */
def x = 1.23
def result
switch (x) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [4, 5, 6, 'inlist']: //列表
        result = 'list'
        break
    case 12..30:
        result = 'range' //范围
        break
    case Integer:
        result = 'Integer'
        break
    case BigDecimal:
        result = 'BigDecimal'
        break
    default: result = 'default'
}

println result

/** ========================for循环======================== */
def sum = 0
for (s in 0..9) {
    sum += s
}

/**
 * 对 List 循环
 */
for (ii in [1, 2, 3, 4, 5, 6, 7]) {
    sum += ii
}

/**
 * 对 Map 进行循环
 */
for (iii in ['a': 1, 'b': 2, 'c': 3]) {
    sum += iii.value
}


