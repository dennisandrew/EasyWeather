package com.dacoding.easyweather.presentation.util.animations

import androidx.compose.animation.core.*
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun animateBottomSheetPeeking(
    sheetState: BottomSheetState,
): Animatable<Float, AnimationVector1D> {
    val peekingHeight = remember { Animatable(initialValue = 200f) }
    LaunchedEffect(key1 = sheetState.isCollapsed) {
        if (sheetState.isCollapsed) {
            launch {
                peekingHeight.animateTo(
                    targetValue = 240f,
                    animationSpec = tween(
                        durationMillis = 1500,
                        easing = EaseInBounce
                    )
                )
//                peekingHeight.animateTo(
//                    targetValue = 160f,
//                    animationSpec = spring(
//                        dampingRatio = Spring.DampingRatioHighBouncy,
//                        stiffness = Spring.StiffnessMedium
//                    )
//                )
                peekingHeight.animateTo(
                    targetValue = 200f,
                    animationSpec = tween(
                        durationMillis = 1500,
                        easing = EaseOutBounce
                    )
                )
//                peekingHeight.animateTo(
//                    targetValue = 144f,
//                    animationSpec = spring(
//                        dampingRatio = Spring.DampingRatioHighBouncy,
//                        stiffness = Spring.StiffnessMedium
//                    )
//                )
            }

        }
    }
    return peekingHeight
}