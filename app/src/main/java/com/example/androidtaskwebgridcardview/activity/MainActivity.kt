package com.example.androidtaskwebgridcardview.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidtaskwebgridcardview.R
import com.example.androidtaskwebgridcardview.modal.GridViewModal
import com.example.androidtaskwebgridcardview.service.GridViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var gridView: GridView
    private var list = mutableListOf(
        GridViewModal("Yandex", R.drawable.yandex, "https://ya.ru/"),
        GridViewModal("YouTube", R.drawable.you_tube, "https://www.youtube.com/"),
        GridViewModal("GitHub", R.drawable.github, "https://github.com/"),
        GridViewModal(
            "Urban University",
            R.drawable.urban_university,
            "https://urban-university.ru/"
        )
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        gridView = findViewById(R.id.gridViewGW)
        val adapter = GridViewAdapter(list, this)
        gridView.adapter = adapter
        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(list[position].website)
                    )
                )
            }
    }
}