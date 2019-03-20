package udemy.fausto.com.Cervezas_RecyclerView.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*
import udemy.fausto.com.Cervezas_RecyclerView.*

class ListActivity : AppCompatActivity() {

    var misCervezas = ArrayList<Cerveza>()
    private lateinit var adapter: CervezaAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Toolbar
        setSupportActionBar(toolbar)
        if (getSupportActionBar() != null) {
            getSupportActionBar()
        }

        // meter en la base de datos las cervezas y chequear que están metidas







        // Data cervezas del arraylist DataService
        misCervezas = DataService().cervezas2

        //println("---------")
        //println(misCervezas)




        // adapter y LinearLayoutManager

        adapter = CervezaAdapter(this, misCervezas)
        recyclerView.adapter = adapter

        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager




    }
    // -------------   FUNCTIONS ---------------

    //SELECT ID, Titulo, Descripcion FROM Notas Where (Titulo like ?) ORDER BY Titulo

    fun cargarQuery(nombre: String) {
        var baseDatos = DBManager(this)
        val columnas = arrayOf(DBManager.columnaID, DBManager.columnaPrecio, DBManager.columnaNombre, DBManager.columnaImagen, DBManager.columnaFecha, DBManager.columnaAlcohol, DBManager.columnaEnvase)
        val selectionArgs = arrayOf(nombre)

        val cursor = baseDatos.query(columnas, "Nombre like ?", selectionArgs, DBManager.dbNombre)


        misCervezas.clear()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(DBManager.columnaID))
                val precio = cursor.getDouble(cursor.getColumnIndex(DBManager.columnaPrecio))
                val nombre = cursor.getString(cursor.getColumnIndex(DBManager.columnaNombre))
                val imagen  = cursor.getString(cursor.getColumnIndex(DBManager.columnaImagen))
                val fecha  = cursor.getString(cursor.getColumnIndex(DBManager.columnaFecha))
                val alcohol  = cursor.getString(cursor.getColumnIndex(DBManager.columnaAlcohol))
                val envase  = cursor.getString(cursor.getColumnIndex(DBManager.columnaEnvase))


                misCervezas.add(Cerveza(id, precio, nombre, imagen, fecha, alcohol, envase))

            } while (cursor.moveToNext())
        }

        adapter = CervezaAdapter(this, misCervezas)
        recyclerView.adapter = adapter
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == R.id.list) {
            Toast.makeText(this, "List", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.add) {
            Toast.makeText(this, "Add", Toast.LENGTH_LONG).show()
            var intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
            return true
        } else {
            Toast.makeText(this, "Error ????", Toast.LENGTH_LONG).show()

        }

        return super.onOptionsItemSelected(item)

    }
}
