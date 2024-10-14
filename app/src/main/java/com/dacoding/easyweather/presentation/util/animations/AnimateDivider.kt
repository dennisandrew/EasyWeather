package com.dacoding.easyweather.presentation.util.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.material.BottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import kotlinx.coroutines.launch

@Composable
fun animateDivider(
    sheetState: BottomSheetState,
): Animatable<Float, AnimationVector1D> {
    val dividerAlpha = remember { Animatable(initialValue = 0f) }
    LaunchedEffect(key1 = sheetState.isExpanded) {
        if (sheetState.isExpanded) {
            launch {
                dividerAlpha.animateTo(
                    targetValue = 0.5f,
                    animationSpec = tween(
                        durationMillis = 2500
                    )
                )
            }
        } else {
            launch {
                dividerAlpha.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = 500
                    )
                )
            }
        }
    }
    return dividerAlpha
}
