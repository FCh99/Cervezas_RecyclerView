package udemy.fausto.com.Cervezas_RecyclerView


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteException




class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "CervezasDB"
        private val TABLE = "CervezasTable"
        private val COL_ID = "id"
        private val COL_NAME = "nombre"
        private val COL_IMAGE = "imagen"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //creating table with fields
        val CREATE_CERVEZA_TABLE = ("CREATE TABLE " + TABLE + "("
                + COL_ID + " INTEGER PRIMARY KEY UNIQUE," + COL_NAME + " TEXT,"
                + COL_IMAGE + " TEXT" + ")")
        db?.execSQL(CREATE_CERVEZA_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE)
        onCreate(db)
    }


    //method to insert data
    fun addCerveza(cerv: Cerveza):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ID, cerv.id)
        contentValues.put(COL_NAME, cerv.nombre) // CervezaClass Name
        contentValues.put(COL_IMAGE,cerv.imagen ) // CervezaClass Phone
        // Inserting Row
        val success = db.insert(TABLE, null, contentValues)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }

    fun addCervezas(cervezas: ArrayList<Cerveza>): Boolean {
        for (cerveza in cervezas) {
            addCerveza(cerveza)
        }
        return true
    }


    //method to read data
    fun getCervezas():ArrayList<Cerveza>{
        val cervezas = ArrayList<Cerveza>()

        val selectQuery = "SELECT  * FROM $TABLE"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id: Int
        var name: String
        var imagen: String
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                imagen = cursor.getString(cursor.getColumnIndex(COL_IMAGE))
                val cervez= Cerveza(id = id, nombre = name, imagen = imagen)
                cervezas.add(cervez)
            } while (cursor.moveToNext())
        }
        return cervezas
    }

    //method to update data
    fun updateCerveza(cerv: Cerveza):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ID, cerv.id)
        contentValues.put(COL_NAME, cerv.nombre) // CervezaClass Name
        contentValues.put(COL_IMAGE,cerv.imagen ) // CervezaClass Email

        // Updating Row
        val success = db.update(TABLE, contentValues,"id="+cerv.id,null)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }

    //method to delete data
    fun deleteCerveza(cerv: Cerveza):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ID, cerv.id) // CervezaClass UserId
        // Deleting Row
        val success = db.delete(TABLE,"id="+cerv.id,null)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }
}