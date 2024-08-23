package com.example.chatbot.compo

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChatFooter(onClick: (text: String)-> Unit)
{
    var inputText:String by remember {
        mutableStateOf("")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(10.dp)
    ){

        OutlinedTextField(value =inputText , onValueChange = {inputText=it},
            placeholder= @androidx.compose.runtime.Composable {Text(text= "Type here!",)},
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .background(Color.Gray))
//IconButton
            IconButton(onClick = {

                onClick(inputText)
                inputText = ""
            })
            {
                Icon(
                Icons.Rounded.Send, contentDescription = null,
                modifier = Modifier

                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(8.dp) , tint = Color.White
                    )
                }

            }
   }

