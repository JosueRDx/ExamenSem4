package com.josuerdx.solucion_examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josuerdx.solucion_examen.ui.theme.Solucion_ExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Solucion_ExamenTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Pregunta06()
                }
            }
        }
    }
}


/* Al ejecutar la siguiente función y después de darle click
al control Button ¿Cuál será el valor que almacene la variable "nro"? */
@Composable
fun Pregunta01() {
    var nro: Int by remember { mutableIntStateOf(0) }

    Button(
        onClick = {
            for (i in 0 until 10)
                nro += (i + 1000)

        }
    ) { Text(text = "$nro") }
}

/* Al ejecutar la siguiente función y luego de darle click al
control Button ¿Cuál será el valor que almacene la variable "msg"? */
@Composable
fun Pregunta02() {
    var lista = arrayListOf("Uno", "Dos", "Tres", "Cuatro")
    var msg: String by remember { mutableStateOf(value = "Click Me!") }

    Button(
        onClick = {
            msg = lista[lista.size - 3].substring(startIndex = 1)
        }
    ) {
        Text(msg)
    }
}

/* Al ejecutar la funcion Pregunta03(), el control Text muestra el valor: */
open class A (var a: Int) {
    open fun pget(): Int { return 3 * a }
}

class B(a: Int, var b: Int): A(a) {
    override fun pget(): Int { return super.pget() + b }
}

@Composable
fun Pregunta03() {
    var w: A = B(a = 3, b = 4)
    Text(text = "${w.pget()}")
}


/*
La clase A tiene un constructor de tipo
open class A (var a: Int) {
    open fun pget(): Int { return 3 * a }
}
*/

/*
Elija la declaracion de clase que define una clase descendiente de la clase B

open class A (var a: Int) {
    open fun pget(): Int { return 3 * a }
}

class B(a: Int, var b: Int): A(a) {
    override fun pget(): Int { return super.pget() + b }
}
*/

/* Despues de hacer un unico Click en el Boton.
Indique lo que muestra el control Text de la funcion Etiqueta6: */
@Composable
fun Pregunta06() {
    var valor by remember { mutableStateOf(25) }
    Column {
        Spacer(Modifier.height(30.dp))
        Boton6(valor) { rpta:Int -> valor = rpta }
        Etiqueta6(valor)
    }
}

@Composable
fun Boton6(dato: Int, evento: (Int) -> Unit) {
    Button(onClick = { evento((dato + 1234561) % 5) })
    { Text(text = "Click Me!") }
}

@Composable
fun Etiqueta6(k: Int) = Text(text = "$k")


/*
Indique la sentencia que permite almacenar el valor 125 en la variable answer
val answer = remember { mutableStateOf(0) }
*/
@Composable
fun Pregunta07() {

    val answer = remember { mutableStateOf(0) }
    Column {
        Button(onClick = {
            answer.value = 125
        }) {
            Text(text = "Click me!")
        }
        Text(text = "El valor es: ${answer.value}")
    }
}

/*
Se puede almacenar una imagen en la carpeta _____________ y para poder visualizar
 dicha imagen en JetPack Compose se debe utilizar el control denominado_________.
*/

@Composable
fun Pregunta08() {
    Image(
        painter = painterResource(id = R.drawable.guante),
        contentDescription = "Guante",
        modifier = Modifier.size(200.dp)
    )
}





@Preview(showBackground = true)
@Composable
fun PreguntasPreview() {

    Pregunta01()
    Pregunta02()
    Pregunta03()
    Pregunta06()
    Pregunta07()
    Pregunta08()
}
