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

        val stringLong = "Históricamente la cerveza fue desarrollada por los antiguos pueblos elamitas, egipcios y sumerios. Las evidencias más antiguas de la producción de cerveza datan de alrededor de IV milenio a. C. fueron halladas en Godin Tepe, en el antiguo Elam (actual Irán). Algunos la ubican conjuntamente con la aparición del pan entre 10 000 a. C. y 6000 a. C. ya que tiene una parecida preparación agregando más o menos agua. Parece ser que las cervezas primitivas eran más densas que las actuales, similares al actual pombe africano, de culturas igualmente primitivas. Según la receta más antigua conocida, el Papiro de Zósimo de Panópolis (siglo III), los egipcios elaboraban la cerveza a partir de panes de cebada poco cocidos que dejaban fermentar en agua. Su cerveza fue conocida como zythum, que es palabra griega, pero en una fase más tardía. Antiguamente en Oriente se usaba arroz y también bambú. Del bambú, lo mismo que de la caña de azúcar, lo que se fermenta es su savia; pero no su fruto. Tal es el ulanzi propio de Tanzania. No puede ser considerado un fermentado alcohólico de cereal. Las bebidas alcohólicas más antiguas quizá sean derivadas de la leche. Michael Jackson, en su Michael Jackson's Beer Companion,11\u200B recoge la opinión del profesor de la Universidad de Pensilvania Salomon Katz, que data la aparición de una bebida de cebada fermentada alcohólicamente en la Mesopotamia del año 4000 a. C. con el nombre de sikaru, pero señala que se hacía con pan de cebada; es decir, se trataba de lo que hoy llamamos kuas, que no es considerado propiamente cerveza, aunque es un fermentado alcohólico proveniente de cereal. La cerveza propiamente dicha aparece en Europa en el siglo XIII, en la medida en que el concepto de cerveza incluye el amargor propio del lúpulo. El malteado ya se había inventado antes. En el primer capítulo de sus Études sur la bière, Pasteur hace notar que cuando se dice que en el siglo IV a. C. ya Teofrasto hablaba de «cerveza», en realidad no hablaba de cerveza, ni de cervoise, ni de beer, sino de vino de cebada, de οίνος εκ κριθεόν. Atribuir un origen muy antiguo a la cerveza se hace sobre la base de proporcionar un concepto muy amplio de lo que haya de entenderse por cerveza.\n" +
                "\n" +
                "Los restos arqueológicos más antiguos de producción de cerveza en Europa fueron descubiertos en 1999 en el yacimiento de la Cova de Can Sadurní en el término municipal de Begas (Barcelona, España) los restos hallados eran del neolítico en una estratificación de entre 5500 a. C.-4000 a. C., por Manel Edo Benaiges,12\u200B Pepa Villalba Ibáñez y Anna Blasco Olivares,13\u200B de la Universidad de Barcelona (UB). Sin duda alguna este hallazgo14\u200B desplazó el que hasta ese momento se creía como más antiguo descubrimiento de elaboración de cerveza en Europa en el yacimiento del valle de Ambrona, dentro del término municipal de Miño de Medinaceli, (Soria, España) y que databan de alrededor de siglo XXV a. C., según el trabajo arqueológico del equipo dirigido por el profesor Manuel Ángel Rojo Guerra, de la Universidad de Valladolid.15\u200B16\u200B17\u200B También se han encontrado evidencias arqueológicas de elaboración de cerveza en el yacimiento de Genó, en Aitona (Lérida, España), tras los trabajos de investigación arqueológica, dirigidos por el profesor José Luis Maya González, que han establecido que estos restos arqueológicos databan de alrededor de siglo XII a. C.\n" +
                "\n" +
                "Los celtas conocían la elaboración de la cerveza y llevaron consigo este conocimiento cuando se extendieron por la península ibérica, donde su uso y su elaboración se desarrolló muy pronto.\n" +
                "\n" +
                "Con el paso de los siglos, sobre todo a partir de la romanización, la mediterránea se consolidó como una zona básicamente vinícola mientras que la cerveza se producía en el norte y centro de Europa y adquiría la forma de lo que entendemos hoy por cerveza. De esta manera, se extiende el uso de la malta como ingrediente principal y también se empieza a introducir el uso del lúpulo como aromatizante. Esta planta cannabáceas confiere a la cerveza su sabor amargo característico, a la vez que favorece la conservación."

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

        if (textViewLong != null)
        textViewLong.text = stringLong

    }
}
