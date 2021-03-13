package com.vb.test_task.ui.main.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vb.test_task.R
import com.vb.test_task.databinding.FragmentListBinding
import com.vb.test_task.ui.main.MainActivity

class ListFragment : Fragment(R.layout.fragment_list), RecyclerItemClickListener {

    private val listBinding by lazy { FragmentListBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setSupportActionBar(listBinding.listToolbar)
        initListRecycler()
    }

    private fun initListRecycler() {
        (activity as MainActivity).mainVM.posts.observe(viewLifecycleOwner) {
            if (listBinding.listProgresssIndicator.visibility != View.GONE)
                listBinding.listProgresssIndicator.visibility = View.GONE
            listBinding.listRec.layoutManager = LinearLayoutManager(requireContext())
            listBinding.listRec.adapter = ListRecAdapter(requireContext(), it, this)
        }
    }

    override fun onItemClicked(
        imageUrl: String?,
        header: String,
        body: String,
        videoUrl: String?,
        authorInfo: String
    ) {
        val bundle = Bundle()
        bundle.putString("header", header)
        bundle.putString("body", body)
        bundle.putString("image", imageUrl)
        bundle.putString("video", videoUrl)
        bundle.putString("authorInfo", authorInfo)
        findNavController().navigate(
            R.id.action_listFragment_to_detailsFragment,
            bundle
        )
    }
}