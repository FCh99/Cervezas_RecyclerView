package udemy.fausto.com.Cervezas_RecyclerView.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.recycler_card_row.*
import udemy.fausto.com.Cervezas_RecyclerView.R
import udemy.fausto.com.Cervezas_RecyclerView.seleccionarURL

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var bundle = intent.extras

        if (bundle != null) {
            var imagen = bundle.getString("imagen")
            var nombre = bundle.getString("nombre")
            var precio = bundle.getString("precio")
            var fechaFabricacion = bundle.getString("fecha")


            // TODO
            var urlImagen = seleccionarURL(imagen!!)
            Picasso.get().load(urlImagen).into(imageViewDet)

            textViewNameDet.text = nombre!!
            textViewPriceDet.text = precio!!
            textViewFechaFabDet.text = fechaFabricacion!!

        } else {
            println("------------")
            println("Bundle is null")
        }


    }
}
