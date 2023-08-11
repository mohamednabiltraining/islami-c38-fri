package com.route.IslamiC38Fri.ui.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.IslamiC38Fri.databinding.ActivityChapterDetailsBinding
import com.route.IslamiC38Fri.ui.Constants

class ChapterDetails : AppCompatActivity() {
    lateinit var viewBinding: ActivityChapterDetailsBinding
    lateinit var chapterName: String
    var chapterIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        val verses = readChapterFile("$chapterIndex.txt")
        initRecyclerView(verses)

    }

    lateinit var adapter: VersesAdapter
    private fun initRecyclerView(verses: List<String>) {
        adapter = VersesAdapter(verses)
        viewBinding.content.recyclerView.adapter = adapter
    }

    private fun readChapterFile(fileName: String): List<String> {
        var fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        var lines = fileContent.trim().split("\n");
        return lines
    }

    private fun initViews() {
        chapterName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME) ?: ""
        chapterIndex = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX, 0)
        viewBinding.titleTV.text = chapterName
        setTitle(null)
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()

    }
}