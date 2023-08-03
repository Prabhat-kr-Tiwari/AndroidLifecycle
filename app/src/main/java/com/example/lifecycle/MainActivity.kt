package com.example.lifecycle

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var lifecycleAdapter: LifecycleAdapter
    private val lifecycleEventsList = mutableListOf<LifecycleEvent>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initialize RecyclerView and Adapter
        // lifecycleAdapter = LifecycleAdapter(lifecycleEventsList)
        lifecycleAdapter = LifecycleAdapter(LifecycleData.lifecycleEventsList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = lifecycleAdapter
        Toast.makeText(this, "onCreate() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onCreate()")


        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(0)
        }, 100)

        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(lifecycleAdapter.itemCount - 3)
        }, 1000)
        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(lifecycleAdapter.itemCount - 3)
        }, 1000)


        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(lifecycleAdapter.itemCount - 1)
        }, 10000)
        addLifecycleEvent("onCreate()", "First Activity is created")


        /* binding.mainBtn.setOnClickListener {
             // Perform any action here
             // ...

             // Add a new lifecycle event when the button is clicked
             addLifecycleEvent("Custom Event", "Button is clicked")
         }*/

        binding.mainBtn.setOnClickListener {
            intent = Intent(this, Top::class.java)
            startActivity(intent)

        }
    }

    override fun onStart() {

        super.onStart()
       // Toast.makeText(this, "onStart() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onStart()")
        addLifecycleEvent("onStart()", "First Activity is Started")
    }

    override fun onResume() {
        super.onResume()
       // Toast.makeText(this, "onResume() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onResume()")
        addLifecycleEvent("onResume()", "First Activity is Resume")
    }

    override fun onPause() {
        super.onPause()
       // Toast.makeText(this, "onPause() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onPause()")
        addLifecycleEvent("onPause()", "First Activity is Paused")

    }

    override fun onStop() {
        super.onStop()
       // Toast.makeText(this, "onStop() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onStop()")
        addLifecycleEvent("onStop()", "First Activity is Stopped")


    }


    override fun onDestroy() {
        super.onDestroy()
       // Toast.makeText(this, "onDestroy() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onDestroy()")

        addLifecycleEvent("onDestroy()", "First Activity is Destroyed")

    }

    override fun onRestart() {
        super.onRestart()
        //Toast.makeText(this, "onRestart() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onRestart()")
        addLifecycleEvent("onDestroy()", "First Activity is Destroyed")

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        //Toast.makeText(this, "onSaveInstanceState() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat", "MainActivity: onSaveInstanceState()")
        addLifecycleEvent("onSaveInstanceState()", "First Activity is onSaveInstanceState")


    }

    // Add a new lifecycle event to the list
    private fun addLifecycleEvent(eventName: String, eventDescription: String) {
        val lifecycleEvent = LifecycleEvent(eventName, eventDescription)
        val insertPosition = lifecycleEventsList.size
        LifecycleData.lifecycleEventsList.add(lifecycleEvent)

        lifecycleAdapter.notifyItemInserted(insertPosition)
        binding.recyclerView.scrollToPosition(insertPosition)
    }
}