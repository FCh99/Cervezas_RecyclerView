package udemy.fausto.com.ej_4_activity2

import android.content.Context
import android.content.Context.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

/*
Android Kotlin app: el usuaro da de alta sus cervezas favoritas en una Activity, luego se muestran en un RecyclerView. Uso de Picasso, radioButton y CheckBox
 */


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    var cervezas = ArrayList<Cerveza>()
    var spinner: Spinner? = null
    var checkBox:CheckBox? = null
    var radioGroup:RadioGroup? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox = this.checkBoxAlcohol
        radioGroup = this.radioGroup1
        spinner = this.spinner2

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

            var fechaDeFabricacion = editTextDate.text.toString()
            var alcohol = checkAlcohol(checkBox!!)
            var envase = typeOfEnvase(radioGroup!!) // TODO Problem ¡¡

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

    fun checkAlcohol(mycheck: CheckBox): String {
        var alcoholSi = ""
        alcoholSi = mycheck.isChecked.toString()
        return alcoholSi
    }

    fun typeOfEnvase(radioGroup: RadioGroup): String {
        var idChecked = radioGroup.getCheckedRadioButtonId()

        var tipo = when(idChecked) {
            radioButtonLata.id -> "Lata"
            radioButtonBotellin.id -> "Botellin"
            radioButtonTercio.id -> "Tercio"
            else -> "Error"
        }

        return tipo
    }




}







