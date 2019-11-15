package com.example.frasesad

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_quotes.*


class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
    }


    fun toPost(view: View) {
        val uid = FirebaseAuth.getInstance().currentUser?.uid

        val quotes = hashMapOf(
            "user" to uid,
            "autor" to etAutor,
            "frase" to etFrase
        )


        val db = FirebaseFirestore.getInstance()
        db.collection("frases")
            .add(quotes)
            .addOnSuccessListener { it ->
                Log.d("Success", "DocumentSnapshot added with ID: ${it.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Fail", "Error adding document", e)
            }
    }
}
