package com.example.catsanddogs.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsanddogs.R
import com.example.catsanddogs.dashboard.view.ContentAdapter
import com.example.catsanddogs.detail.DetailActivity
import com.example.catsanddogs.home.HomeActivity
import com.example.catsanddogs.models.CatCollection
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment(), ContentAdapter.Listener {
    private val contentAdapter = ContentAdapter()

    companion object {
        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        contentAdapter.bindListener(this)
        rvContent.layoutManager = LinearLayoutManager(context)
        rvContent.adapter = contentAdapter
    }

    override fun onClickItem(catCollection: CatCollection) {
        (context as HomeActivity).startActivity(
            DetailActivity.intent(context, catCollection)
        )
    }

}