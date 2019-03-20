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

        // Toolbar, va con Menu y Actions
        setSupportActionBar(toolbar)
        if (getSupportActionBar() != null) {
            getSupportActionBar()
        }



        misCervezas = DataService().cervezas2

        // A la base de datos
        var db = DatabaseHandler(this)
        var xx = db.addCervezas(misCervezas)


        // leer de la base de datos y enchufar al adapter

        var cervList = db.getCervezas()


        adapter = CervezaAdapter(this, cervList)
        recyclerView.adapter = this.adapter



        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager




    }
    // -------------   FUNCTIONS ---------------



    // Toolbar MENU
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    // Toolbar MENU
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
