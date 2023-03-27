package com.test.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

// Clase MainActivity hereda de AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Declaración de la variable navigation de tipo BottomNavigationView
    lateinit var navigation: BottomNavigationView

    // Creación de un listener para el menú de navegación inferior
    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        // Comprueba qué elemento del menú de navegación fue seleccionado
        when (item.itemId) {
            // Si el primer fragmento es seleccionado
            R.id.item_fragment1 -> {
                // Reemplaza el contenido del contenedor con el PrimerFragment
                supportFragmentManager.commit {
                    replace<PrimerFragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            // Si el segundo fragmento es seleccionado
            R.id.item_fragment2 -> {
                // Reemplaza el contenido del contenedor con el SegundoFragment
                supportFragmentManager.commit {
                    replace<SegundoFragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            // Si el tercer fragmento es seleccionado
            R.id.item_fragment3 -> {
                // Reemplaza el contenido del contenedor con el TercerFragment
                supportFragmentManager.commit {
                    replace<TercerFragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    // Método onCreate que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa la variable navigation
        navigation = findViewById(R.id.nav_menu)
        // Establece el listener para el menú de navegación inferior
        navigation.setOnNavigationItemSelectedListener(mOnNavMenu)

        // Código para que al comienzo ya esté activo un Fragment
        // supportFragmentManager.commit {
        //     replace<PrimerFragment>(R.id.frame_container)
        //     setReorderingAllowed(true)
        //     addToBackStack("replacement")
        // }
    }
}
