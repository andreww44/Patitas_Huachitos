package pack.patitas.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pack.patitas.identies.mascotasEntity

@Dao
interface mascotaDao {
    @Insert
    suspend fun insertAll(vararg pets: mascotasEntity)

    @Query("SELECT * FROM mascotas")
    suspend fun getAllPets(): List<mascotasEntity>
    @Query("SELECT * FROM mascotas WHERE id = :id AND name = :name")
    suspend fun findMascotaByIdAndName(id: Int, name: String): mascotasEntity?
}
