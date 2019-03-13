package udemy.fausto.com.Cervezas_RecyclerView.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import udemy.fausto.com.Cervezas_RecyclerView.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var bundle = intent.extras
        var imagen = bundle.getString("imagen")
        var nombre = bundle.getString("nombre")
        var precio = bundle.getString("precio")
        var fechaFabricacion = bundle.getString("fecha")





    }
}
