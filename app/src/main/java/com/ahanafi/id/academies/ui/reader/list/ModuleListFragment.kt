package com.ahanafi.id.academies.ui.reader.list


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahanafi.id.academies.data.ModuleEntity
import com.ahanafi.id.academies.ui.reader.CourseReaderActivity
import com.ahanafi.id.academies.ui.reader.CourseReaderCallback
import com.ahanafi.id.academies.utils.DataDummy

import com.ahanafi.id.academy.R
import kotlinx.android.synthetic.main.fragment_module_list.*

/**
 * A simple [Fragment] subclass.
 */
class ModuleListFragment : Fragment(), MyAdapterClickListener {

    companion object{
        val TAG = ModuleListFragment::class.java.simpleName

        fun newInstance() : ModuleListFragment = ModuleListFragment()
    }

    private lateinit var adapter : ModuleListAdapter
    private lateinit var courseReaderCallback : CourseReaderCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ModuleListAdapter(this)
        populateRecyclerView(DataDummy.generateDummyModules("a14"))

    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        progress_bar.visibility = View.GONE
        adapter.setModules(modules)
        with(rv_module) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapter
        }
        val dividerItemDecoration = DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
        rv_module.addItemDecoration(dividerItemDecoration)
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

}
