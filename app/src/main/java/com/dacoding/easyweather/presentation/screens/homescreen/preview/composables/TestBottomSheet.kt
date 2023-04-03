package com.dacoding.easyweather.presentation.screens.homescreen.preview.composables


import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.screens.homescreen.preview.util.TestHomeWeatherState
import com.dacoding.easyweather.presentation.ui.theme.EasyWeatherTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TestBottomSheet(state: TestHomeWeatherState) {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()

    val rotation = remember { Animatable(initialValue = 180f) }

    val peekingHeight = remember { Animatable(initialValue = 200f) }

    val dividerAlpha = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(key1 = sheetState.isExpanded) {

        if (sheetState.isExpanded) {
            launch {
                rotation.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = 1000
                    )
                )
            }
        } else {
            launch {
                rotation.animateTo(
                    targetValue = 180f,
                    animationSpec = tween(
                        durationMillis = 1000
                    )
                )
            }
        }
    }

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
        }
        else {
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



    BottomSheetScaffold(
        sheetGesturesEnabled = !state.isLoading,
        backgroundColor = Color.Transparent,
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(34.dp))
                    Divider(
                        modifier = Modifier
                            .width(192.dp)
                            .alpha(dividerAlpha.value),
                        color = MaterialTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.height(25.dp))
//                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp)
                            .clickable {
                                testCollapseBottomSheet(
                                    scope = scope,
                                    sheetState = sheetState
                                )
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .alpha(0.5f)
                                .rotate(rotation.value),
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    }
//                    Spacer(modifier = Modifier.height(32.dp))
                    TestWeatherForecast(
                        state = TestHomeWeatherState()
                    )
                }
            }
        },
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = peekingHeight.value.dp,
        sheetShape = MaterialTheme.shapes.small,
        sheetElevation = 0.dp
    ) {

    }
}

@OptIn(ExperimentalMaterialApi::class)
fun testCollapseBottomSheet(scope: CoroutineScope, sheetState: BottomSheetState) {
    scope.launch {
        if (sheetState.isCollapsed)
            sheetState.expand()
        else sheetState.collapse()
    }

}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun TestBottomSheetPreview() {
    EasyWeatherTheme {
        TestBottomSheet(state = TestHomeWeatherState())
    }
}