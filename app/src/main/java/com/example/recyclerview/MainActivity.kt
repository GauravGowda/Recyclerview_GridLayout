package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//const val base_url1 = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity(),PhotoAdapter.OnItemClickListener {


    private lateinit var  photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()
    var myArray= arrayOf("Ajay","Gaurav","Sanjay","Ajay","Prakash","Shivam","Rushikesh","Rahul","Sournanil","Nitin","Hrishikesh")
    var myImage = arrayOf(R.drawable.boysmall,R.drawable.boybig,R.drawable.signin,R.drawable.boysmall,R.drawable.boybig,R.drawable.signin,R.drawable.boysmall,R.drawable.boybig,R.drawable.signin)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //initiate the grid  view
        //in this case I make row grid in a row
        //if you want to change that change the number

        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        photoAdapter = PhotoAdapter(applicationContext,this)
        recyclerView.adapter = photoAdapter



        //add data
        for (i in 1..9) {
            dataList.add(DataModel("User" + " " + i , myArray[i-1], myImage[i-1]))
        }
/*        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))
        dataList.add(DataModel("Title","Desc",R.drawable.ic_launcher_background))*/


        photoAdapter.setDataList(dataList)


    }




    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,HomeActivity::class.java)
        intent.putExtra("user_message","Item $position clicked")
        intent.putExtra("arrayuser",myArray)

        startActivity(intent)
    }
}