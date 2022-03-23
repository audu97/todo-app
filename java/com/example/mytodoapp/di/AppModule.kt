package com.example.mytodoapp.di

import android.app.Application
import androidx.room.Room
import com.example.mytodoapp.data.TodoDataBase
import com.example.mytodoapp.data.TodoRepository
import com.example.mytodoapp.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDataBase{
        return Room.databaseBuilder(
            app,
            TodoDataBase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDataBase): TodoRepository{
        return TodoRepositoryImpl(db.dao)
    }

}