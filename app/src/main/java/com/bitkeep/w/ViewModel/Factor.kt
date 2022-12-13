package com.bitkeep.w.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitkeep.w.Apps
import com.bitkeep.w.MainApplication
import kotlinx.coroutines.flow.Flow

class Factor(private val app : MainApplication,
             private val appsFlow: Flow<Apps?>,
             private val deepflow : Flow<String>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModel(app, appsFlow, deepflow) as T
    }


}