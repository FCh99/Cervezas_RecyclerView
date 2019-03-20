package udemy.fausto.com.Cervezas_RecyclerView



import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast


/*

data class Cerveza (val id: Int = 1, val precio: Double = 0.00, val nombre: String = "", val imagen: String = "", val fechaFabricacion: String = "1/1/1111", val alcohol: String = "No", val envase: String = "Ninguno" ) : Parcelable {

 */

class DBContract {
    companion object {



    }
}



class DBManager(contexto: Context) {

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


    //CREATE TABLE IF NOT EXISTS + Notas + (ID INTEGER PRIMARY KEY AUTOINCREMENT, Titulo TEXT NOT NULL, Descripcion TEXT NOT NULL)

    val sqlCrearTabla = "CREATE TABLE IF NOT EXISTS " + dbTabla + " (" + columnaID + " INTEGER PRIMARY KEY AUTOINCREMENT," + columnaPrecio + "INTEGER NOT NULL," + columnaFecha + "TEXT NOT NULL, "  + columnaAlcohol + "TEXT NOT NULL, " + columnaEnvase + "TEXT NOT NULL, " +
            columnaNombre + " TEXT NOT NULL," + columnaImagen + " TEXT NOT NULL)"

    var sqlDB: SQLiteDatabase? = null

    init {
        val db = DBHelperNotas(contexto)
        sqlDB = db.writableDatabase
    }


    inner class DBHelperNotas(contexto: Context) : SQLiteOpenHelper(contexto, dbNombre, null, dbVersion) {
        var contexto: Context? = contexto

        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(sqlCrearTabla)
            Toast.makeText(this.contexto, "Base datos creada", Toast.LENGTH_SHORT).show()
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("Drop table IF EXISTS" + dbTabla)
        }

    }

    fun insert(values: ContentValues): Long {
        val ID = sqlDB!!.insert(dbTabla, "", values)
        return ID
    }

    //Query retorna un objeto de tipo cursor
    //Projection: Columnas
    //Selection: Es el cuerpo de la sentencia WHERE con las columnas que condicionamos
    //SelectionArgs: Es una lista de los valores que se usaran para remplazar selection
    //OrderBy: Cómo queremos que se ordene

    fun query(projection: Array<String>, selection: String, selectionArgs: Array<String>, orderBy: String): Cursor {
        val consulta = SQLiteQueryBuilder()

        consulta.tables = dbTabla
        val cursor = consulta.query(sqlDB, projection, selection, selectionArgs, null, null, orderBy)
        return cursor
    }







    fun borrar(selection: String, selectionArgs: Array<String>): Int {
        val contador = sqlDB!!.delete(dbTabla, selection, selectionArgs)
        return contador
    }

    fun actualizar(values: ContentValues, selection: String, selectionArgs: Array<String>): Int {
        val contador = sqlDB!!.update(dbTabla, values, selection, selectionArgs)
        return contador
    }

}