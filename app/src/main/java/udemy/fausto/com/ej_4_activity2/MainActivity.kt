package udemy.fausto.com.ej_4_activity2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

/*
Android Kotlin app: el usuaro da de alta sus cervezas favoritas en una Activity, luego se muestran en un RecyclerView. Uso de Picasso, radioButton y CheckBox
 */


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var cervezas = ArrayList<Cerveza>()
    var spinner: Spinner? = null
    var checkBox:CheckBox? = null

    var selectedEnvase = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox = this.checkBoxAlcohol
        spinner = this.spinner2

        if (spinner != null) {
            spinner!!.setOnItemSelectedListener(this)

            val aa = ArrayAdapter.createFromResource(this@MainActivity, R.array.cervezasNombres, android.R.layout.simple_spinner_item )
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner!!.adapter = aa
        }



        buttonAdd.setOnClickListener {
            addCervezaAlArray()


        }

        buttonList.setOnClickListener {
            var intent = Intent(this, ListActivity::class.java)
            var bundle = Bundle()
            bundle.putParcelableArrayList("cervezas", cervezas)
            intent.putExtras(bundle)
            startActivity(intent)



        }

        }



    // -------------   FUNCTIONS -----------------------

    // recoge los datos del formulario y crea un array de Cervezas
    fun addCervezaAlArray () {
        var id: Int = 0
        if (idEditText.text.isNotEmpty()) id = idEditText.text.toString().toInt()

        var precio: Double = 0.00
        if(precioEditText.text.isNotEmpty()) precio = precioEditText.text.toString().toDouble()

        var nombre: String = ""
        if(nombreEditText.text.isNotEmpty()) nombre = nombreEditText.text.toString()

        var imagen: String = ""
        if(spinner!!.getSelectedItem().toString().isNotEmpty()) imagen = spinner!!.getSelectedItem().toString()

        var fechaDeFabricacion: String = "1/1/1111"
        if (editTextDate.text.toString().isNotEmpty()) fechaDeFabricacion = editTextDate.text.toString()

        var alcohol = "No"
        if (checkAlcohol(checkBox!!).isNotEmpty()) alcohol = checkAlcohol(checkBox!!)

        var envase = ""
        if (selectedEnvase.isNotEmpty()) envase = selectedEnvase

        var cerveza = Cerveza(id, precio, nombre, imagen, fechaDeFabricacion, alcohol, envase)
        cervezas.add(cerveza)

        //println("-----------")
        //println(cervezas)
    }



    fun checkAlcohol(mycheck: CheckBox): String {
        var alcoholSi = ""
        alcoholSi = mycheck.isChecked.toString()
        return alcoholSi
    }


    // view es el botón clickado de los varios que tienen este onClick
    fun radioButtonClicked(view: View) {
        var clickedRB = view as RadioButton
        when(clickedRB) {
            radioButtonLata -> selectedEnvase = "Lata"
            radioButtonTercio -> selectedEnvase = "Tercio"
            radioButtonBotellin -> selectedEnvase = "Botellin"
            else -> selectedEnvase = "Error al elegir el envase"
        }



    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        println("Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        println("Selected")
    }



}







