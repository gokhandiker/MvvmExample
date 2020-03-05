package com.melisa.mvvmexample.data.entity

interface Heater {

    fun on()
    fun off()
    fun isHot() : Boolean
}