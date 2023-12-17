package pack.patitas.identies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mascotas")
data class mascotasEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,
    val age: String,
    val state: String,
    val gender: String,
    val physicalDescription: String,
    val personalityDescription: String,
    val additionalDescription: String,
    val sterilized: Int,
    val vaccinated: Int,
    val imageUrl: String,
    val team: String,
    val region: String,
    val commune: String,
    val url: String
)
fun mascotasEntity.toPet(): Pet {
    return Pet(
        id = this.id,
        name = this.name,
        types = this.type,
        age = this.age,
        state = this.state,
        gender = this.gender,
        desF = this.physicalDescription,
        desP = this.personalityDescription,
        desA = this.additionalDescription,
        sterilized = this.sterilized,
        vaccines = this.vaccinated,
        urlImage = this.imageUrl,
        team = this.team,
        region = this.region,
        commune = this.commune,
        url = this.url
    )
}