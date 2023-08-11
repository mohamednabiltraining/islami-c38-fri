package com.route.IslamiC38Fri.ui.HadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.IslamiC38Fri.databinding.ActivityHadethDetailsBinding
import com.route.IslamiC38Fri.ui.Constants
import com.route.IslamiC38Fri.ui.model.Hadeth

class HadethDetails : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()

    }

    var hadeth: Hadeth? = null
    private fun initViews() {
        // hadeth = intent.getSerializableExtra(Constants.EXTRA_HADETH) as Hadeth?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(
                Constants.EXTRA_HADETH,
                Hadeth::class.java
            )
        } else {
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH)
        }
        viewBinding.titleTV.text = hadeth?.title
        viewBinding.content.content.text = hadeth?.content
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
