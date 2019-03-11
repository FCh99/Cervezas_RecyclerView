package udemy.fausto.com.ej_4_activity2

import android.content.Context
import android.content.Context.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

/*
Android Kotlin app: el usuaro da de alta sus cervezas favoritas en una Activity, luego se muestran en un RecyclerView. Uso de Picasso, radioButton y CheckBox
 */


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    var cervezas = ArrayList<Cerveza>()
    var spinner: Spinner? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spinner = findViewById(R.id.spinner2)
        if (spinner != null) {
            spinner!!.setOnItemSelectedListener(this)

            val aa = ArrayAdapter.createFromResource(this@MainActivity, R.array.cervezasNombres, android.R.layout.simple_spinner_item )
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner!!.adapter = aa
        }



        button3.setOnClickListener {
            // recoger variables de la Actividad

            var id = idEditText.text.toString().toInt()
            var precio = precioEditText.text.toString().toDouble()
            var nombre = nombreEditText.text.toString()
            var imagen = spinner!!.getSelectedItem().toString()

            var fechaDeFabricacion = "14/01/2019"
            var alcohol = "No"
            var envase = "tercio"

            var cerveza = Cerveza(id, precio, nombre, imagen, fechaDeFabricacion, alcohol, envase)

            cervezas.add(cerveza)

            println("-----------")
            println(cervezas)


        }

        }
    override fun onNothingSelected(parent: AdapterView<*>?) {

        println("Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        println("Selected")

    }


}







