package com.example.guidest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import com.example.guidest.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = Firebase.auth

        binding.btnAdd.setOnClickListener{
            DialogSerie( onSubmitClickListener =  { quantity ->
                Toast.makeText(this, "sfsdofs", Toast.LENGTH_SHORT).show()
            }).show(supportFragmentManager, "dialog")
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_salir -> {
                singOut()
            }
            R.id.menu_otro -> {
                Toast.makeText(baseContext, "Autenticación exitosa", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        return
    }

    /*private fun showAddSerieDialog(){
        val addSerieDialog = AddSerieDialog()
        addSerieDialog.set
    }*/

    private fun singOut(){
        firebaseAuth.signOut()
        Toast.makeText(baseContext, "Sesión Cerrada Correctamente", Toast.LENGTH_SHORT).show()
        val i = Intent (this, LoginActivity::class.java)
        startActivity(i)
    }
}