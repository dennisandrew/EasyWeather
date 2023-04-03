package com.dacoding.easyweather.presentation.util.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
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