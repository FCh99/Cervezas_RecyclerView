package udemy.fausto.com.Cervezas_RecyclerView


import android.os.Parcel
import android.os.Parcelable

data class Cerveza (val id: Int = 1, val precio: Double = 0.00, val nombre: String = "", val imagen: String = "", val fechaFabricacion: String = "1/1/1111", val alcohol: String = "No", val envase: String = "Ninguno" ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeDouble(precio)
        parcel.writeString(nombre)
        parcel.writeString(imagen)
        parcel.writeString(fechaFabricacion)
        parcel.writeString(alcohol)
        parcel.writeString(envase)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cerveza> {
        override fun createFromParcel(parcel: Parcel): Cerveza {
            return Cerveza(parcel)
        }

        override fun newArray(size: Int): Array<Cerveza?> {
            return arrayOfNulls(size)
        }
    }
}






