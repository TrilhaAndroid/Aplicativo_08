package br.com.leonardobarral.application_08.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextFieldElement(
    value:String,
    onValueChange: (String)->Unit,
    label:String,
    placeholder:String,
    modifier: Modifier,
    keyboardType: KeyboardType,
    isErrorValidation:Boolean,
    visualTransformation:VisualTransformation,
) {
     TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label)},
        placeholder =  {Text(text = placeholder)},
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isErrorValidation,
        visualTransformation = visualTransformation
    )
}


