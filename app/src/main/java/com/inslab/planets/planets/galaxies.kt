package com.inslab.planets.planets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inslab.planets.ui.theme.Satoshi

@Composable
fun Galaxy(painter: Painter, name: String, position: String, tagline: String, desc: String, size: Int) {
    val wid = LocalConfiguration.current.screenWidthDp;
    LazyColumn( Modifier
        .fillMaxHeight()
        .width(wid.dp)
        .background(color = Color(0xFF1A1A1A)),
        content = {
            item {
                Card(
                    Modifier.fillMaxWidth()
                ) {
                    Box(
                    ) {
                        Image(
                            painter = painter,
                            contentDescription = name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(wid.dp/2)
                        )
                        Text(
                            text = position,
                            style = TextStyle(
                                fontSize = wid.sp / 4,
                                fontFamily = Satoshi,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                }
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 54.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight.Black,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .graphicsLayer(alpha = 0.99f)
                        .drawWithCache {
                            val brush = Brush.horizontalGradient(listOf(Color(0xFFff930f), Color(0xFFfff95b)))
                            onDrawWithContent {
                                drawContent()
                                drawRect(brush, blendMode = BlendMode.SrcAtop)
                            }
                        }
                )
                Text(
                    text = tagline,
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFEEEDF0),
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = desc,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF9B9EA9),
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        })}