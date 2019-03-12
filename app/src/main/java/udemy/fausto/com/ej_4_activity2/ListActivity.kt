package udemy.fausto.com.ej_4_activity2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    var misCervezas = ArrayList<Cerveza>()
    private lateinit var adapter: CervezaAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var bundle = intent.extras
        if (bundle != null) {
            misCervezas = bundle.getParcelableArrayList("cervezas")
        }

        println("---------")
        println(misCervezas)

        adapter = CervezaAdapter(this, misCervezas)
        recyclerView.adapter = adapter

        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


    }
}
