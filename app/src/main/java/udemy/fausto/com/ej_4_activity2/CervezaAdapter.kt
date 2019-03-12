package udemy.fausto.com.ej_4_activity2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_card_row.view.*

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
        }

        fun bindCerveza(cerveza: Cerveza) {
            this.cerveza = cerveza
            view.textViewName.text = cerveza.nombre
            view.textViewAlcohol.text = cerveza.alcohol
            view.textViewEnvase.text = cerveza.envase
            // Falta la foto


        }


    }
}