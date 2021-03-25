package com.github.xvar.presentation.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.xvar.presentation.R
import com.github.xvar.presentation.ui.theme.AppTheme

private val buttonPadding = 32.dp

@Composable
fun ChooseTechScreen() {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .width(IntrinsicSize.Max)
        ) {

            ChooseButton(
                resId = R.string.rx_java2) {
                //todo
            }

            ChooseButton(
                enabled = false,
                resId = R.string.rx_java3
            )

            ChooseButton(
                resId = R.string.coroutines
            )

            ChooseButton(
                modifier = Modifier.padding(bottom = buttonPadding),
                enabled = false,
                resId = R.string.flow
            )

        }
    }
}

@Composable
private fun ChooseButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    resId : Int,
    action: () -> Unit = {}
) {
    Button(
        onClick = { action() },
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = buttonPadding, start = buttonPadding, end = buttonPadding)
    ) {
        Text(text = stringResource(id = resId))
    }
}

@Composable
@Preview
private fun ChooseTechScreenPreview() {
    AppTheme {
        ChooseTechScreen()
    }
}
