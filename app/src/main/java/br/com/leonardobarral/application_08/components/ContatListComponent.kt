package br.com.leonardobarral.application_08.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_08.models.Contato

@Composable
fun ContatListCompponent(
    contatos: List<Contato>?,
    updateContato: () -> Unit,
    updateUpdateContato:(Contato) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        if (contatos != null) {
            for (i in contatos) {
                CardComponent(
                    contato = i,
                    updateContato = updateContato,
                    updateUpdateContato
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}
