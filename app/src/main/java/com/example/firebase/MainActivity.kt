package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var c = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef = database.reference

        binding.boton.setOnClickListener{
            myRef.child("movies").get().addOnSuccessListener { response ->
                Log.d("firebaserespondse", response.children.count().toString())
                myRef.child("movies").child((response.children.count() + 1).toString()).setValue(Movie(binding.txtPoster.text.toString(), binding.txtTitulo.text.toString(), binding.txtYear.text.toString().toInt(), binding.txtId.text.toString(), binding.txtGenere.text.toString()))

                myRef.child("movies").child((response.children.count() + 1).toString()).child("poster").get().addOnSuccessListener { response ->
                    Log.d("firebaserespondse", response.value.toString())
                    binding.aaa.setText(response.value.toString())
                }.addOnFailureListener{
                    Log.e("firebaserespondse", "Error", it)

                }
                myRef.child("movies").child((response.children.count() + 1).toString()).child("titulo").get().addOnSuccessListener { response ->
                    Log.d("firebaserespondse", response.value.toString())
                    binding.nombre.setText(response.value.toString())
                }.addOnFailureListener{
                    Log.e("firebaserespondse", "Error", it)
                }

                myRef.child("movies").child((response.children.count() + 1).toString()).child("year").get().addOnSuccessListener { response ->
                    Log.d("firebaserespondse", response.value.toString())
                    binding.nombreA.setText(response.value.toString())
                }.addOnFailureListener{
                    Log.e("firebaserespondse", "Error", it)
                }

                myRef.child("movies").child((response.children.count() + 1).toString()).child("id").get().addOnSuccessListener { response ->
                    Log.d("firebaserespondse", response.value.toString())
                    binding.nombreB.setText(response.value.toString())
                }.addOnFailureListener{
                    Log.e("firebaserespondse", "Error", it)
                }

                myRef.child("movies").child((response.children.count() + 1).toString()).child("genere").get().addOnSuccessListener { response ->
                    Log.d("firebaserespondse", response.value.toString())
                    binding.usuario.setText(response.value.toString())
                }.addOnFailureListener{
                    Log.e("firebaserespondse", "Error", it)
                }

            }.addOnFailureListener{
                Log.e("firebaserespondse", "Error", it)
            }


        }

    }
}