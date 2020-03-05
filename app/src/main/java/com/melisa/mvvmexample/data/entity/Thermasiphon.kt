package com.melisa.mvvmexample.data.entity

class Thermasiphon(private val heater: Heater): Pump{
    override fun pump() {
        if (heater.isHot()) {
            println("=> => pumping => =>")
        }
    }

}