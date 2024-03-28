package br.com.leonardobarral.application_08.database.repositories

import android.content.Context
import androidx.room.Query
import br.com.leonardobarral.application_08.database.dao.ContatoDB
import br.com.leonardobarral.application_08.models.Contato

class ContatoRepository (context: Context){

    var db = ContatoDB.getDatabase(context).ContatoDao()

    fun insert(contato:Contato): Long{
        return db.insert(contato = contato)
    }

    fun update(contato: Contato): Int{
        return db.update(contato = contato)
    }

    fun delete(contato: Contato): Int{
        return db.delete(contato = contato)
    }

    fun selectId(id:Long): Contato{
        return db.selectId(id = id)
    }

    fun selectList():List<Contato>{
        return db.selectList()
    }


}
