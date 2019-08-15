package com.yis.study.objectorention

def person = new Person(name: 'liu', age: 18)
//.name = getName 无论你是直接.还是调用get/set最终都是调用get/set
println "the name is ${person.name} , the age is ${person.getAge()}"

//调用一个没有定义的方法
println person.cry()

////为类动态的添加一个属性
Person.metaClass.sex = 'male'
def person2 = new Person(name: 'liu', age: 18)
println "新添加的性别是：${person2.sex}"

//为类动态的添加方法
Person.metaClass.sexUpperCase = { sex.toUpperCase() }
def person3 = new Person(name: 'liu', age: 18)
println person3.sexUpperCase()

//为类动态的添加静态方法
Person.metaClass.static.createperson = {
    String name, int age -> new Person(name: name, age: age)
}
def person4 = Person.createperson("dayi", 23)
println person4.name + " and " + person4.age

