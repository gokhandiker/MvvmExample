package com.melisa.mvvmexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melisa.mvvmexample.R
import com.melisa.mvvmexample.di.component.CoffeeApp
import com.melisa.mvvmexample.di.module.coffeeAppModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            // use Koin logger
            printLogger()
            // declare used modules
            modules(coffeeAppModule)
        }

        val coffeeShop = CoffeeApp()

        coffeeShop.maker.brew()
    }
}
