package com.example.superheroe

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.superheroe.data.Superhero
import com.example.superheroe.data.SuperheroeAdapter
import com.example.superheroe.databinding.ActivityMainBinding
import com.example.superheroe.utils.RetrofitProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var adapter: SuperheroeAdapter

    var superheroList = List<Superhero> = emptyList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        // sustituimos esto setContentView(R.layout.activity_main) por el binding

        setContentView(binding.root)

        adapter = SuperheroeAdapter(superheroList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        searchSuperheroes("")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)

        val menuItem = menu?.findItem(
            (R.id.menu_search)!!



    }

    private fun searchSuperheroes(query: String) {
        val service = RetrofitProvider.getRetrofit()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = service.findSuperheroesByName(query)

                CoroutineScope(Dispatchers.Main).launch {
                    if (result.response == "success") {
                        adapter.updateItems(result.results)
                    } else {
                        // TODO: Mostrar mensaje de que no se ha encontrado nada
                    }
                }
            } catch (e: Exception) {
                Log.e("API", e.stackTraceToString())

            }
        }

    }

}
