package com.dacoding.easyweather.presentation.screens.homescreen.screen.composables.elements


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
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.screens.homescreen.screen.util.HomeWeatherViewModel
import com.dacoding.easyweather.presentation.util.animations.animateArrow
import com.dacoding.easyweather.presentation.util.animations.animateBottomSheetPeeking
import com.dacoding.easyweather.presentation.util.animations.animateDivider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    viewModel: HomeWeatherViewModel
) {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()

    val arrowAnimation = animateArrow(sheetState = sheetState)

    val sheetPeekHeight = animateBottomSheetPeeking(sheetState = sheetState)

    val dividerAlpha = animateDivider(sheetState = sheetState)

    BottomSheetScaffold(
        sheetGesturesEnabled = !viewModel.state.isLoading,
        backgroundColor = Color.Transparent,
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(34.dp))
                    Divider(
                        modifier = Modifier
                            .width(192.dp)
                            .alpha(dividerAlpha.value),
                        color = MaterialTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp)
                            .clickable {
                                collapseBottomSheet(
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
                                .rotate(arrowAnimation.value),
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
//                            .padding(bottom = 8.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        WeatherForecast(state = viewModel.state)
                        HomeTempChart(state = viewModel.state)
                    }
                }
            }
        },
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = sheetPeekHeight.value.dp,
        sheetShape = MaterialTheme.shapes.small,
        sheetElevation = 0.dp
    ) {

    }
}

@OptIn(ExperimentalMaterialApi::class)
fun collapseBottomSheet(scope: CoroutineScope, sheetState: BottomSheetState) {
    scope.launch {
        if (sheetState.isCollapsed)
            sheetState.expand()
        else sheetState.collapse()
    }

}
