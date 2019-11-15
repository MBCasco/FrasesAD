package com.example.frasesad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import java.util.*


class MainActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onRegistrar(view: View) {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.AnonymousBuilder().build())

            startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN)

    }

    fun toQuotes (view: View){
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null){
            val intent = Intent(this,QuotesActivity::class.java)
            startActivity(intent)

        }

    }

    fun onSingOut(view: View){
        FirebaseAuth.getInstance().signOut()
    }


}
