package br.com.leonardobarral.application_08.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _id = MutableLiveData<Long>()
    val id: LiveData<Long> = _id

    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> = _nome

    private val _telefone = MutableLiveData<String>()
    val telefone: LiveData<String> = _telefone

    private val _amigo = MutableLiveData<Boolean>()
    val amigo: LiveData<Boolean> = _amigo

    private val _contatos = MutableLiveData<List<Contato>>()
    val contatos:LiveData<List<Contato>> = _contatos

    fun updateId(novoValor:Long){
        _id.value = novoValor
    }

    fun updateNome(novoValor:String){
        _nome.value = novoValor
    }
    fun updateTelefone(novoValor:String){
        _telefone.value = novoValor
    }
    fun updateAmigo(novoValor:Boolean){
        _amigo.value = novoValor
    }

    fun updateContatos(novoValor:List<Contato>){

        _contatos.value = novoValor
    }



}