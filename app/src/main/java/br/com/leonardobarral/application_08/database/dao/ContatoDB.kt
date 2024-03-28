package br.com.leonardobarral.application_08.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.leonardobarral.application_08.models.Contato

@Database(
    entities = [Contato::class],
    version = 1
)
abstract class ContatoDB: RoomDatabase(){
    abstract fun ContatoDao(): ContatoDao

    companion object{
        private lateinit var instance:ContatoDB

        fun getDatabase(context: Context):ContatoDB{
            if(!::instance.isInitialized){
                instance = Room.databaseBuilder(
                    context,
                    ContatoDB::class.java,
                    "contato_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}