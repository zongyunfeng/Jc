package me.yunfeng.jc

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.graphics.Color
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight

class MainActivity : AppCompatActivity() {
    private val count: CountModel = CountModel();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { content() }
    }

    @Composable
    fun content() = MaterialTheme {
        FlexColumn {
            inflexible {
                TopAppBar<MenuItem>(
                    title = { Text("Jetpack Compose Sample") }
                )
            }
            expanded(1F) {
                Center {
                    Column {
                        Center {
                            Text(
                                text = "You have pushed the button this many times:",
                                style = TextStyle(
                                    fontSize = Sp(15F),
                                    fontWeight = FontWeight.bold
                                )
                            )
                        }
                        Center {
                            Text(
                                text = "${count.cnt}",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = Sp(22F),
                                    fontWeight = FontWeight.bold
                                )
                            )
                        }
                    }
                }
            }
        }
        Align(Alignment.BottomRight) {
            fab()
        }
    }

    @Composable
    fun fab() {
        Row {
            val onAddClick: () -> Unit = {
                count.add()
            }
            Padding(
                padding = EdgeInsets(all = Dp(8F))
            ) {
                FloatingActionButton(
                    color = Color(0xff2196f3),
                    icon = imageFromResource(
                        resources,
                        R.drawable.add
                    ),
                    onClick = onAddClick
                )
            }
        }
    }
}
