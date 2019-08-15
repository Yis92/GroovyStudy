package com.yis.study

import com.yis.study.objectorention.Person
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def list = [
        new Person(name: "张三", age: 12),
        new Person(name: "李四", age: 15)
]

//将数据bean解析成String类型的json串
def jsonData = JsonOutput.toJson(list)
//通过JsonOutput对json输出格式进行格式化输出
println JsonOutput.prettyPrint(jsonData)

//将json解析成数据bean
def jsonSlurper = new JsonSlurper()
List<Person> per = jsonSlurper.parseText(jsonData)
println per[0].name

//网络请求获取数据并解析
def response = getNetworkData("http://ip-api.com/json/?lang=zh-CN")
println response.city

def getNetworkData(String url) {
    //发送Http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    //将json转化为实体对象
    def jsonSluper = new JsonSlurper()
    return jsonSluper.parseText(response)
}
