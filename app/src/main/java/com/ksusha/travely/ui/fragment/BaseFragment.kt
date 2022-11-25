package com.ksusha.travely.ui.fragment

import androidx.fragment.app.Fragment
import com.ksusha.travely.arch.AttractionsViewModel
import com.ksusha.travely.ui.MainActivity

abstract class BaseFragment: Fragment() {

    protected val navController by lazy {
        (activity as MainActivity).navController
    }

    protected val activityViewModel: AttractionsViewModel
        get() = (activity as MainActivity).viewModel
}