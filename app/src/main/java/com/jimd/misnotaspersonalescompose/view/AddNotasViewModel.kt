package com.jimd.misnotaspersonalescompose.view

import androidx.lifecycle.ViewModel
import com.jimd.misnotaspersonalescompose.data.domain.NotasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNotasViewModel @Inject constructor(
    private val repository: NotasRepository
):ViewModel(){



}