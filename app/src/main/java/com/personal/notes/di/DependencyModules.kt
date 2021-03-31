package com.personal.notes.di

import org.koin.dsl.module.module

object DependencyModules {
    private val appModule = module {

    }
    val list = listOf(appModule)
}