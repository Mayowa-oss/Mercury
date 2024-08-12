package com.example.learnviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    private fun getUserdata3(): ArrayList<MessageItem>{
        return arrayListOf(
            MessageItem(R.drawable.redarrow,
                "NIP DR/OPA/MAYOWA",
                "-NGN5,000.00",
                ""
            ),
            MessageItem(R.drawable.redarrow,
                "NIP DR/EGP/FEMI",
                "-NGN115,000.00",
                ""

            ),
            MessageItem(R.drawable.greenarrow,
                "NIP CR/EGP/BANKOLE",
                "NGN900,000.00",
                ""

            ),

        )
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        val secondFragment = TransferFragment()
        val thirdFragment = PayBillsFragment()



        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                //
                R.id.home -> {
                    replaceFragment (HomeFragment())
                }
                R.id.transfer -> {
                    replaceFragment (secondFragment)
                }
                else -> {
                    replaceFragment (thirdFragment)
                }

            }
            true
        }



//        newRecyclerView = findViewById(R.id.recyclerview)
//        newRecyclerView.setLayoutManager(LinearLayoutManager(this))
//        newRecyclerView.setHasFixedSize(true)
//        signalAdapter = MyAdapter(getUserdata3())
//        newRecyclerView.setAdapter(signalAdapter)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}