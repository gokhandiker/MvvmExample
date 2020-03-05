package com.melisa.mvvmexample.di.component

import com.melisa.mvvmexample.data.entity.CoffeeMaker
import org.koin.core.KoinComponent
import org.koin.core.inject

class CoffeeApp : KoinComponent {
    val maker:CoffeeMaker by inject()
}