package com.example.guidest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.guidest.databinding.ActivityRecordarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecordarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecordarBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val txtemail: TextView = findViewById(R.id.txtEmailCambio)
        val btnCambiar: Button = findViewById(R.id.btnCambiar)

        btnCambiar.setOnClickListener{
            sendPasswordReset(txtemail.text.toString())
        }

        firebaseAuth = Firebase.auth
    }

    private fun sendPasswordReset (email : String){
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful){
                    Toast.makeText(baseContext, "Correo de cambido de contraseña enviado", Toast.LENGTH_SHORT).show()
                    onBackPressed()
                }
                else{
                    Toast.makeText(baseContext, "Error, no se puedo completar el proceso", Toast.LENGTH_SHORT).show()

                }
            }
    }
}