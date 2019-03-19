package udemy.fausto.com.Cervezas_RecyclerView


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.*


// TODO ojo con los Int id y Double Precio, y los arguments que son String

class CervezaDBHelper(private var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "Cerveza.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "cervezaTabla"

        const val COLUMN_ID = "id"
        const val COLUMN_PRECIO = "precio"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_IMAGEN = "imagen"
        const val COLUMN_FECHAFAB = "fechaFabricacion"
        const val COLUMN_ALCOHOL = "alcohol"
        const val COLUMN_ENVASE = "envase"


    }

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INT PRIMARY KEY," +
                COLUMN_PRECIO + "INT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_IMAGEN + "TEXT, " +
                COLUMN_FECHAFAB + "TEXT, " +
                COLUMN_ALCOHOL + "TEXT, " +
                COLUMN_ENVASE + "TEXT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME



    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertCerveza(cerveza: Cerveza): Boolean {
        // Gets the data repository in write mode
        val db = writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(COLUMN_ID, cerveza.id)
        values.put(COLUMN_NOMBRE, cerveza.nombre)
        values.put(COLUMN_PRECIO, cerveza.precio)
        values.put(COLUMN_FECHAFAB, cerveza.fechaFabricacion)
        values.put(COLUMN_IMAGEN, cerveza.imagen)
        values.put(COLUMN_ALCOHOL, cerveza.alcohol)
        values.put(COLUMN_ENVASE, cerveza.envase)


        // Insert the new row, returning the primary key value of the new row
        val newRowId = db.insert(TABLE_NAME, null, values)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteCerveza(id: Int): Boolean {
        // Gets the data repository in write mode
        val db = writableDatabase
        // Define 'where' part of query.
        val selection = COLUMN_ID + " LIKE ?"

        // Specify arguments in placeholder order.
        val selectionArgs = arrayOf(id.toString())  // TODO era Int ?????
        // Issue SQL statement.
        db.delete(TABLE_NAME, selection, selectionArgs)

        return true
    }

    fun readCerveza(cervezaId: Int): ArrayList<Cerveza> {
        val cervezas = ArrayList<Cerveza>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + TABLE_NAME + " WHERE " + COLUMN_ID + "='" + cervezaId + "'", null)
        } catch (e: SQLiteException) {
            // if table not yet present, create it
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var id : Int
        var nombre:String
        var precio: Double
        var imagen: String
        var edad: String
        var alcohol: String
        var envase: String


        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                precio = cursor.getDouble(cursor.getColumnIndex(COLUMN_PRECIO))
                imagen = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGEN))
                edad = cursor.getString(cursor.getColumnIndex(COLUMN_FECHAFAB))
                alcohol = cursor.getString(cursor.getColumnIndex(COLUMN_ALCOHOL))
                envase = cursor.getString(cursor.getColumnIndex(COLUMN_ENVASE))

                cervezas.add(Cerveza(id, precio, nombre, imagen, edad, alcohol, envase))
                cursor.moveToNext()
            }
        }
        return cervezas
    }

    fun readAllCervezas(): ArrayList<Cerveza> {
        val cervezas = ArrayList<Cerveza>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + TABLE_NAME, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var id : Int
        var nombre:String
        var precio: Double
        var imagen: String
        var edad: String
        var alcohol: String
        var envase: String



        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {


                id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                precio = cursor.getDouble(cursor.getColumnIndex(COLUMN_PRECIO))
                imagen = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGEN))
                edad = cursor.getString(cursor.getColumnIndex(COLUMN_FECHAFAB))
                alcohol = cursor.getString(cursor.getColumnIndex(COLUMN_ALCOHOL))
                envase = cursor.getString(cursor.getColumnIndex(COLUMN_ENVASE))

                cervezas.add(Cerveza(id, precio, nombre, imagen, edad, alcohol, envase))
                cursor.moveToNext()
            }
        }
        return cervezas
    }


}