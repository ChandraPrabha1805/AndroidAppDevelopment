package com.malviyastudio.kotlinmvvmretrofit

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malviyastudio.kotlinmvvmretrofit.Adapter.FlowerLIST
import com.malviyastudio.kotlinmvvmretrofit.Model.FlowerModel
import com.malviyastudio.kotlinmvvmretrofit.ViewModel.MainActivityViewModel
import com.malviyastudio.kotlinmvvmretrofit.ui.theme.KotlinMVVMRetrofitTheme
import okhttp3.internal.notify

class MainActivity : ComponentActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: FlowerLIST? = null
    var layoutManager: LinearLayoutManager? = null
    //var dialog :AlertDialog?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinMVVMRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
            mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
            recyclerView=findViewById(R.id.flowerName)
            recyclerView!!.setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this)
            recyclerView!!.layoutManager=layoutManager

            mainActivityViewModel!!.getFlowerList.observe(this){ FlowerModel->
            Log.e("MainActivity","FlowerList "+ FlowerModel!!.get(0).name)
                if (FlowerModel !=null)
                    adapter= FlowerLIST(this,FlowerModel)
                    adapter!!.notifyDataSetChanged()
                    recyclerView!!.adapter=adapter
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinMVVMRetrofitTheme {
        Greeting("Android")
        }
    }
