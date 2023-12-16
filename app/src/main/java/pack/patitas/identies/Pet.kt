package pack.patitas.identies

import android.os.Parcel
import android.os.Parcelable

data class Pet(
    val name: String? = "",
    val region: String? = "",
    val age: String? = "",
    val types: String? = "",
    val state: String? = "",
    val gender: String? = "",
    val description: String? = "",
    val urlImage: String? = ""
) : Parcelable {

    constructor(parcel: Parcel) : this(

        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(region)
        parcel.writeString(age)
        parcel.writeString(types)
        parcel.writeString(state)
        parcel.writeString(gender)
        parcel.writeString(description)
        parcel.writeString(urlImage)
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
