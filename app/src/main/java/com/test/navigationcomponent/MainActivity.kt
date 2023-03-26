package com.test.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigation : BottomNavigationView

    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId){
            R.id.item_fragment1 -> {
                supportFragmentManager.commit {
                    replace<PrimerFragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.item_fragment2 -> {
                supportFragmentManager.commit {
                    replace<SegundoFragment>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.item_fragment3 -> {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.nav_menu)
        navigation.setOnNavigationItemSelectedListener(mOnNavMenu)

        //supportFragmentManager.commit {
        //    replace<PrimerFragment>(R.id.frame_container)
        //    setReorderingAllowed(true)
        //    addToBackStack("replacement")
        //}
    }
}