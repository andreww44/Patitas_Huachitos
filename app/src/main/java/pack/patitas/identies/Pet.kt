package pack.patitas.identies

import android.os.Parcel
import android.os.Parcelable

data class Pet(
    val id: Int = 0,
    val name: String? = "",
    val types: String? = "",
    val age: String? = "",
    val state: String? = "",
    val gender: String? = "",
    val desF: String? = "",
    val desP: String? = "",
    val desA: String? = "",
    val sterilized: Int = 0,
    val vaccines: Int = 0,
    val urlImage: String? = "",
    val team: String? = "",
    val region: String? = "",
    val commune: String? = "",
    val url: String? = ""

) : Parcelable {

    constructor(parcel: Parcel) : this(

        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(types)
        parcel.writeString(age)
        parcel.writeString(name)
        parcel.writeString(state)
        parcel.writeString(gender)
        parcel.writeString(desF)
        parcel.writeString(desP)
        parcel.writeString(desA)
        parcel.writeInt(sterilized)
        parcel.writeInt(vaccines)
        parcel.writeString(urlImage)
        parcel.writeString(team)
        parcel.writeString(region)
        parcel.writeString(commune)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }

}
