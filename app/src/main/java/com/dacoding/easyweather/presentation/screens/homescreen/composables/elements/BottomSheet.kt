package com.dacoding.easyweather.presentation.screens.homescreen.composables.elements


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dacoding.easyweather.presentation.WeatherViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    viewModel: WeatherViewModel
) {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
//    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        sheetGesturesEnabled = !viewModel.state.isLoading,
        backgroundColor = Color.Transparent,
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(490.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                collapseBottomSheet(
//                                    scope = scope,
//                                    sheetState = sheetState
//                                )
//                            },
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_bottom_sheet),
//                            contentDescription = null
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(32.dp))
                    WeatherForecast(state = viewModel.state)
                }
            }

        },
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = 150.dp,
        sheetShape = MaterialTheme.shapes.small,
        sheetElevation = 0.dp
    ) {

    }
}

//@OptIn(ExperimentalMaterialApi::class)
//fun collapseBottomSheet(scope: CoroutineScope, sheetState: BottomSheetState) {
//    scope.launch {
//        if (sheetState.isCollapsed)
//            sheetState.expand()
//        else sheetState.collapse()
//    }
//
//}
