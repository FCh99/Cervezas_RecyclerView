package udemy.fausto.com.Cervezas_RecyclerView.Activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*
import udemy.fausto.com.Cervezas_RecyclerView.Cerveza
import udemy.fausto.com.Cervezas_RecyclerView.CervezaAdapter
import udemy.fausto.com.Cervezas_RecyclerView.DataService
import udemy.fausto.com.Cervezas_RecyclerView.R

class ListActivity : AppCompatActivity() {

    var misCervezas = ArrayList<Cerveza>()
    private lateinit var adapter: CervezaAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        setSupportActionBar(toolbar)

        if (getSupportActionBar() != null) {
            getSupportActionBar()
        }



        // ---------

        misCervezas = DataService().cerveza2

        /*
        --------------
        var bundle = intent.extras
        if (bundle != null) {
            misCervezas = bundle.getParcelableArrayList("cervezas")
        }
        */

        println("---------")
        println(misCervezas)

        adapter = CervezaAdapter(this, misCervezas)
        recyclerView.adapter = adapter

        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager




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
