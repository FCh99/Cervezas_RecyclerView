package udemy.fausto.com.Cervezas_RecyclerView.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_add.*
import udemy.fausto.com.Cervezas_RecyclerView.Cerveza
import udemy.fausto.com.Cervezas_RecyclerView.DataService
import udemy.fausto.com.Cervezas_RecyclerView.DatabaseHandler
import udemy.fausto.com.Cervezas_RecyclerView.R
import kotlin.collections.ArrayList

/*
Android Kotlin app: el usuaro da de alta sus cervezasAdd favoritas en una Activity, luego se muestran en un RecyclerView. Uso de Picasso, radioButton y CheckBox
 */


class AddActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // las que entren aqui hay que llevarlas a la base de datos
    var cervezasAdd = ArrayList<Cerveza>()



    var spinner: Spinner? = null
    var checkBox:CheckBox? = null

    var selectedEnvase = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        // ---------- UI ----------
        checkBox = this.checkBoxAlcohol
        spinner = this.spinner2

        if (spinner != null) {
            spinner!!.setOnItemSelectedListener(this)

            val aa = ArrayAdapter.createFromResource(this@AddActivity,
                R.array.cervezasNombres, android.R.layout.simple_spinner_item )
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner!!.adapter = aa
        }

        // --------------- BUTTONS ------------------

        // buttonAdd > añadir ese item al Array  OK
        buttonAdd.setOnClickListener {
            addCervezaAlArray()
            println(cervezasAdd)

        }

        // TODO buttonList > 1. añadir array a Base de datos y 2. ir a ListActivity
        buttonList.setOnClickListener {

            var db = DatabaseHandler(this)
            var bool: Boolean = db.addCervezas(cervezasAdd)
            println("---------Add ----->")
            println(bool)
            var intent = Intent(this, ListActivity::class.java)
            startActivity(intent)

        }

        }



    // -------------   FUNCTIONS -----------------------

    fun getCervezas2() {
        this.cervezasAdd = DataService().cervezasInicial
    }


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

        var cerveza =
            Cerveza(id, precio, nombre, imagen, fechaDeFabricacion, alcohol, envase)
        cervezasAdd.add(cerveza)


    }



    fun checkAlcohol(mycheck: CheckBox): String {
        return if (mycheck.isChecked) "Si" else "No"
    }

    // TODO: hacer excluyentes los botones


    // view es el botón clickado de los varios que tienen este onClick
    fun radioButtonClicked(view: View) {
        var clickedRB = view as RadioButton
        selectedEnvase = when(clickedRB) {
            radioButtonLata -> "Lata"
            radioButtonTercio -> "Tercio"
            radioButtonBotellin -> "Botellin"
            else -> "Error al elegir el envase"
        }



    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        println("Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        println("Selected")
    }



}







