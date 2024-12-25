package com.example.dz16androidnavigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dz16androidnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ButtonSwitcher {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Тулбар
        var toolbarMain = binding.toolbarMain
        setSupportActionBar(toolbarMain)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = " Светофор"
        toolbarMain.subtitle = "  Версия 1.Главная страница"
        toolbarMain.setLogo(R.drawable.pleer)
    }

    override fun switchUpButton(status: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(status)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    //Меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenuMain -> {
                Toast.makeText(applicationContext, "Автор Ефремов О.В. Создан 26.12.2024",
                    Toast.LENGTH_LONG).show()
            }
            R.id.exitMenuMain ->{
                Toast.makeText(applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}