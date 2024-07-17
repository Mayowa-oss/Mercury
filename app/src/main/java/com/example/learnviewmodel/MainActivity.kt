package com.example.learnviewmodel

import MessageItem
import MyAdapter
import MyViewModel
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var newRecyclerView: RecyclerView
    //private lateinit var signalAdapter: MyAdapter
    //private lateinit var myViewModel: MyViewModel

   /* private fun getUserdata3(): ArrayList<MessageItem>{
        return arrayListOf(
            MessageItem(R.drawable.cashout,
                "cashout"
            ),
            MessageItem(R.drawable.arrow,
            "arrow"),

            MessageItem(R.drawable.cardwave,
                ""
            ),
            MessageItem(R.drawable.phonewave,
                ""
            ),
        )
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //newRecyclerView.setLayoutManager(LinearLayoutManager(this))
        //newRecyclerView.setHasFixedSize(true)
        //signalAdapter = MyAdapter(getUserdata3())
        //newRecyclerView.setAdapter(signalAdapter)





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}