package com.melisa.mvvmexample.di.module

import com.melisa.mvvmexample.data.entity.*
import org.koin.dsl.module

val coffeeAppModule = module {
    single { CoffeeMaker(get(), lazy { get<Heater>() }) }
    single<Pump> {Thermasiphon(get())}
    single<Heater> { ElectricHeater() }
}