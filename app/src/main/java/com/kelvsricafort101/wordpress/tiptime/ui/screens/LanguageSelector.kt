package com.kelvsricafort101.wordpress.tiptime.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kelvsricafort101.wordpress.tiptime.R
import com.kelvsricafort101.wordpress.tiptime.data.AppLanguage
import com.kelvsricafort101.wordpress.tiptime.ui.theme.TipTimeTheme

@Composable
fun LanguageSelector(
    selectedLanguage: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = stringResource(selectedLanguage.displayName),
            onValueChange = {},
            readOnly = true,
            label = {
                Text(
                    text = stringResource(R.string.language)
                )
            },
            leadingIcon = {
                Image(
                    painter = painterResource(selectedLanguage.flagRes),
                    contentDescription = stringResource(selectedLanguage.displayName),
                    modifier = Modifier.size(
                        width = 24.dp,
                        height = 18.dp
                    )
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .menuAnchor(
                    ExposedDropdownMenuAnchorType.PrimaryNotEditable
                )
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            AppLanguage.entries.forEach { language ->
                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.vertical_arrangement))
                        ) {
                            Image(
                                painter = painterResource(language.flagRes),
                                contentDescription = stringResource(language.displayName),
                                modifier = Modifier.size(width = 24.dp, height = 18.dp)
                            )
                            Text(
                                text = stringResource(language.displayName)
                            )
                        }
                    },
                    onClick = {
                        onLanguageSelected(language)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectorPreview() {
    TipTimeTheme(darkTheme = false) {
        Surface {
            LanguageSelector(
                selectedLanguage = AppLanguage.ENGLISH,
                onLanguageSelected = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectorDarkPreview() {
    TipTimeTheme(darkTheme = true) {
        Surface {
            LanguageSelector(
                selectedLanguage = AppLanguage.ENGLISH,
                onLanguageSelected = {}
            )
        }
    }
}