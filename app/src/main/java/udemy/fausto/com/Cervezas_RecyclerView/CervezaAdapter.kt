package udemy.fausto.com.Cervezas_RecyclerView

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list.view.*
import kotlinx.android.synthetic.main.recycler_card_row.view.*
import udemy.fausto.com.Cervezas_RecyclerView.Activity.DetailActivity

class CervezaAdapter (val context: Context, var cervezas: ArrayList<Cerveza>) : RecyclerView.Adapter<CervezaAdapter.CervezaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CervezaHolder {
        val inflatedView = LayoutInflater.from(context).inflate(R.layout.recycler_card_row, parent, false)
        return CervezaHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return cervezas.count()
    }

    override fun onBindViewHolder(holder: CervezaHolder, position: Int) {
        val itemCerveza = cervezas[position]
        holder.bindCerveza(itemCerveza)
    }


    class CervezaHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var cerveza: Cerveza? = null

        //3
        init {
            view.setOnClickListener(this)
        }
        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            // Intent a Activity detalle

            var bundle = Bundle()
            bundle.putString("nombre", cerveza!!.nombre)
            bundle.putString("precio", cerveza!!.precio.toString())
            bundle.putString("fecha", cerveza!!.fechaFabricacion)
            bundle.putString("imagen", cerveza!!.imagen)

            var intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtras(bundle)

            startActivity(view.context, intent, bundle!!)


        }

        fun bindCerveza(cerveza: Cerveza) {
            this.cerveza = cerveza
            view.textViewName.text = cerveza.nombre

            val alcoholString = if(cerveza.alcohol == "Si") "Con Alcohol" else "Sin Alcohol"
            view.textViewAlcohol.text = alcoholString

            view.textViewEnvase.text = "El envase tipo es ${cerveza.envase}"

            // Falta la foto
            var marca = cerveza.imagen
            var url: String = seleccionarURL(marca)
            Picasso.get().load(url).resize(400, 400).into(view.imageView2)

        }


    }
}

/*

/*
Coronita
https://abarrotesdonacuca.com/303-large_default/cerveza-corona-355ml-grupo-modelo.jpg
Mahou
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/1800x/040ec09b1e35df139433887a97daa66f/2/4/2441.jpg
San Miguel
https://www.lomejordelmercado.com/4279-tm_thickbox_default/botellin-de-cerveza-san-miguel.jpg
Woll-Damn
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/3/1/3107.jpg
Cruzcampo
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/3/2/3271.jpg
Estrella de Galicia
https://www.comprar-bebidas.com/media/catalog/product/cache/5/image/767x1021/9df78eab33525d08d6e5fb8d27136e95/2/4/2448.jpg
 */

 */