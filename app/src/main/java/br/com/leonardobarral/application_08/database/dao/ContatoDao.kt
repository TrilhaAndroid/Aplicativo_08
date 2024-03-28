package br.com.leonardobarral.application_08.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.leonardobarral.application_08.models.Contato


@Dao
interface ContatoDao {

    @Insert
    fun insert(contato:Contato): Long

    @Update
    fun update(contato:Contato): Int

    @Delete
    fun delete(contato:Contato): Int

    @Query("SELECT * FROM tb_contato WHERE id = :id")
    fun selectId(id:Long): Contato

    @Query("SELECT * FROM tb_contato ORDER BY nome ASC")
    fun selectList(): List<Contato>

}