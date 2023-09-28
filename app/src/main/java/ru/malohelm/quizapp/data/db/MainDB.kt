//package ru.malohelm.quizapp.data.db
//
//import android.content.Context
//
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import ru.malohelm.quizapp.data.dao.Dao
//import ru.malohelm.quizapp.data.entity.Answer
//import ru.malohelm.quizapp.data.entity.Question
//
//@Database(entities = [Answer::class, Question::class], version = 1)
//abstract class MainDB: RoomDatabase() {
//    abstract fun getDao(): Dao
//
//    companion object{
//        fun getDb(context: Context): MainDB{
//            return Room.databaseBuilder(
//                context.applicationContext,
//                MainDB::class.java,
//                "quizapp.db"
//            ).build()
//        }
//    }
//}