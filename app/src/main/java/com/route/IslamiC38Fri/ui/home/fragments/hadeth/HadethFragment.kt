package com.route.IslamiC38Fri.ui.home.fragments.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.IslamiC38Fri.databinding.FragmentHadethBinding
import com.route.IslamiC38Fri.ui.Constants
import com.route.IslamiC38Fri.ui.HadethDetails.HadethDetails
import com.route.IslamiC38Fri.ui.model.Hadeth

class HadethFragment : Fragment() {

    lateinit var binding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    lateinit var adapter: HadethAdapter
    private fun initViews() {
        adapter = HadethAdapter(null)
        adapter.onItemClickListener = HadethAdapter.OnItemClickListener { position, hadeth ->
            startHadethActivity(hadeth)
        }
        binding.recyclerView.adapter = adapter
    }

    private fun startHadethActivity(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetails::class.java)
        intent.putExtra(Constants.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        readHadethFile()
    }

    val hadethList = mutableListOf<Hadeth>()
    fun readHadethFile() {
        var fileContent = requireActivity().assets.open(Constants.HADETH_FILE_NAME)
            .bufferedReader().use { it.readText() }
        var completeHadethList = fileContent.trim().split("#")
        completeHadethList.forEach { item ->
            var singleHadethLines = item.trim().split("\n");
            var title = singleHadethLines[0];
            var content = singleHadethLines.subList(
                fromIndex = 1,
                toIndex = singleHadethLines.size
            ).joinToString("\n");
            hadethList.add(Hadeth(title, content))
        }
        adapter.bindItems(hadethList)
    }
}