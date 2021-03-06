package com.ahanafi.id.academies.ui.reader.content


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahanafi.id.academies.data.ContentEntity

import com.ahanafi.id.academy.R
import kotlinx.android.synthetic.main.fragment_module_content.*

/**
 * A simple [Fragment] subclass.
 */
class ModuleContentFragment : Fragment() {

    companion object{
        val TAG = ModuleContentFragment::class.java.simpleName

        fun newInstance() : ModuleContentFragment = ModuleContentFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null) {
            val content = ContentEntity("<h3 class=\\\"fr-text-bordered\\\"> Contoh Content</h3><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
            populateWebView(content)
        }
    }

    private fun populateWebView(content: ContentEntity) {
        web_view.loadData(content.content, "text/html", "UTF-8")
    }


}
