package br.com.leonardobarral.application_08.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_08.R
import br.com.leonardobarral.application_08.database.repositories.ContatoRepository
import br.com.leonardobarral.application_08.models.Contato

@Composable
fun CardComponent(
    contato: Contato,
    updateContato: () -> Unit,
    updateUpdateContato: (Contato) -> Unit,

    ) {
    val context = LocalContext.current


    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = contato.nome,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color(0xff000000)
                )
                Text(
                    text = contato.telefone,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xff000000)
                )
                Text(
                    text = if (contato.isAmigo) "Amigo" else "Contato",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xff000000)
                )
            }
            Column {
                IconButton(
                    onClick = {
                        updateUpdateContato(contato)

                    },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_edit_24),
                            contentDescription = "Icone"
                        )
                    }
                )
                IconButton(
                    onClick = {
                        val contatoRepository = ContatoRepository(context)
                        contatoRepository.delete(contato)
                        updateContato()
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_restore_from_trash_24),
                            contentDescription = "Icone"
                        )
                    }
                )

            }
        }
    }
}