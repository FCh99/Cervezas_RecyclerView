package udemy.fausto.com.Cervezas_RecyclerView.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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

        misCervezas = DataService().cerveza2

        /*
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
}
