package com.vb.test_task.ui.main

import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vb.test_task.domain.repository.RedditRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityVM(private val redditRepo: RedditRepo) : ViewModel() {

    val posts = liveData(Dispatchers.IO) { emit(redditRepo.getPost()) }

    fun initAuthorData(username: String, dataTextView: TextView) {
        viewModelScope.launch(Dispatchers.IO) {
            val authorInfo = redditRepo.getAuthorData(username)
            withContext(Dispatchers.Main) {
                dataTextView.text = authorInfo.authorInfo
            }
        }
    }
}