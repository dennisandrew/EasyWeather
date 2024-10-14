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
fun animateArrow(
    sheetState: BottomSheetState,
): Animatable<Float, AnimationVector1D> {
    val rotation = remember { Animatable(initialValue = 180f) }
    LaunchedEffect(key1 = sheetState.isExpanded) {

        if (sheetState.isExpanded) {
            launch {
                rotation.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = 500
                    )
                )
            }
        } else {
            launch {
                rotation.animateTo(
                    targetValue = 180f,
                    animationSpec = tween(
                        durationMillis = 500
                    )
                )
            }
        }
    }
    return rotation
}
