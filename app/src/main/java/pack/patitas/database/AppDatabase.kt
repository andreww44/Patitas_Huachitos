package pack.patitas.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pack.patitas.dao.mascotaDao
import pack.patitas.identies.mascotasEntity

@Database(entities = [mascotasEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mascotaDao(): mascotaDao
}