package com.personal.notes.di

import com.personal.notes.data.Database
import com.personal.notes.data.NotesManager
import com.personal.notes.viewmodels.NotesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object DependencyModules {
    private val module = module {
        single { Database() }
        factory { NotesManager(get()) }
        viewModel { NotesViewModel(get()) }
    }
    val list = listOf(module)
}