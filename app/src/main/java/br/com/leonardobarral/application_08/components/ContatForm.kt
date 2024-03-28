package br.com.leonardobarral.application_08.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_08.database.repositories.ContatoRepository
import br.com.leonardobarral.application_08.models.Contato

@Composable
fun ContatForm(
    id: Long,
    nome: String,
    telefone: String,
    amigo: Boolean,
    updateNome: (String) -> Unit,
    updateTelefone: (String) -> Unit,
    updateAmigo: (Boolean) -> Unit,
    updateContato: () -> Unit

) {
    val context = LocalContext.current




    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Unspecified
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {


            TextFieldElement(
                value = nome,
                onValueChange = { updateNome(it) },
                label = "Nome do contato",
                placeholder = "João Alguma Coisa",
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, color = Color.Gray)),
                keyboardType = KeyboardType.Text,
                isErrorValidation = false,
                visualTransformation = VisualTransformation.None
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldElement(
                value = telefone,
                onValueChange = {
                    updateTelefone(it)
                },
                label = "Telefone do contato",
                placeholder = "(11) 98537-5309",
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, color = Color.Gray)),
                keyboardType = KeyboardType.Phone,
                isErrorValidation = false,
                visualTransformation = VisualTransformation.None
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(checked = amigo, onCheckedChange = {
                    updateAmigo(!amigo)
                })
                Text(text = "Amigo")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val contatoRepository = ContatoRepository(context)

                    val contato = Contato(
                        id = id,
                        nome = nome,
                        telefone = telefone,
                        isAmigo = amigo
                    )

                    if(id.toInt() != 0) {
                        contatoRepository.update(contato)
                    }else{
                        contatoRepository.insert(contato)
                    }

                    updateContato()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1C6EB4)
                )
            ) {
                Text(text = "CADASTRAR", color = Color.White)
            }
        }
    }

}