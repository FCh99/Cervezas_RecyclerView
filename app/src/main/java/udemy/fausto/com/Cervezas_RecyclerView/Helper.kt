package udemy.fausto.com.Cervezas_RecyclerView

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class Helper {
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun seleccionarURL(marca: String): String {
    return  when(marca) {
        "Coronita" -> "https://abarrotesdonacuca.com/303-large_default/cerveza-corona-355ml-grupo-modelo.jpg"
        "Mahou" -> "https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/1800x/040ec09b1e35df139433887a97daa66f/2/4/2441.jpg"
        "San Miguel" -> "https://www.lomejordelmercado.com/4279-tm_thickbox_default/botellin-de-cerveza-san-miguel.jpg"
        "Woll-Damn" -> "https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/3/1/3107.jpg"
        "Cruzcampo" -> "https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/3/2/3271.jpg"
        "Estrella de Galicia" -> "https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/2/4/2448.jpg\n"
        else -> "Error"

    }
}

/*
data class Cerveza (val id: Int = 1, val precio: Double = 0.00, val nombre: String = "", val imagen: String = "", val fechaFabricacion: String = "1/1/1111", val alcohol: String = "No", val envase: String = "Ninguno" ) : Parcelable {


 companion object {
        //Atributos de la BD
        const val dbNombre = "CervezasDb"
        const val dbTabla = "CervezasTable"
        const val dbVersion = 1
        const val columnaID = "Id"
        const val columnaPrecio = "Precio"
        const val columnaNombre = "Nombre"
        const val columnaImagen = "Imagen"
        const val columnaFecha = "Fecha_Fabricacion"
        const val columnaAlcohol = "Alcohol"
        const val columnaEnvase = "Envase"
    }


val sqlCrearTabla = "CREATE TABLE IF NOT EXISTS " + dbTabla + " (" + columnaID + " INTEGER PRIMARY KEY AUTOINCREMENT," + columnaPrecio + "INTEGER NOT NULL," + columnaFecha + "TEXT NOT NULL, "  + columnaAlcohol + "TEXT NOT NULL, " + columnaEnvase + "TEXT NOT NULL, " +
            columnaNombre + " TEXT NOT NULL," + columnaImagen + " TEXT NOT NULL)"





Coronita
https://abarrotesdonacuca.com/303-large_default/cerveza-corona-355ml-grupo-modelo.jpg
Mahou
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/1800x/040ec09b1e35df139433887a97daa66f/2/4/2441.jpg
San Miguel
https://www.lomejordelmercado.com/4279-tm_thickbox_default/botellin-de-cerveza-san-miguel.jpg
Woll-Damn
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/3/1/3107.jpg
Cruzcampo
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/3/2/3271.jpg
Estrella de Galicia
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/2/4/2448.jpg


 */
