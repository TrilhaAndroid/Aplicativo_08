package br.com.leonardobarral.application_08.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_08.components.ContatForm
import br.com.leonardobarral.application_08.components.ContatListCompponent
import br.com.leonardobarral.application_08.database.repositories.ContatoRepository
import br.com.leonardobarral.application_08.models.Contato
import br.com.leonardobarral.application_08.models.HomeViewModel

fun ContatListCompponent(contatos: List<Contato>, updateUpdateContato: (Contato) -> Unit) {

}

@Composable
fun HomeView(homeViewModel: HomeViewModel) {

    val id by homeViewModel.id.observeAsState(initial = 0)
    val nome by homeViewModel.nome.observeAsState(initial = "")
    val telefone by homeViewModel.telefone.observeAsState(initial = "")
    val amigo by homeViewModel.amigo.observeAsState(initial = false)

    val context = LocalContext.current
    val contatoRepository = ContatoRepository(context)
    val contatosCadastrados by homeViewModel.contatos.observeAsState(contatoRepository.selectList())




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        var newContato = Contato(
            id = id,
            nome = nome,
            telefone = telefone,
            isAmigo = amigo
        )





        Column {
            Text(
                text = "Cadastro de contatos",
                color = Color.Red,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }
        ContatForm(
            id = id,
            nome = nome,
            telefone = telefone,
            amigo = amigo,
            updateAmigo = { homeViewModel.updateAmigo(it) },
            updateNome = { homeViewModel.updateNome(it) },
            updateTelefone = { homeViewModel.updateTelefone(it) },
            updateContato = { homeViewModel.updateContatos(contatoRepository.selectList()) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ContatListCompponent(
            contatosCadastrados,
            updateUpdateContato = {
                homeViewModel.updateNome(it.nome)
                homeViewModel.updateAmigo(it.isAmigo)
                homeViewModel.updateTelefone(it.telefone)
                homeViewModel.updateId(it.id)
            },
            updateContato = { homeViewModel.updateContatos(contatoRepository.selectList()) },
        )
    }
}