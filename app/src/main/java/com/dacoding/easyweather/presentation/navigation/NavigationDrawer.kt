package com.dacoding.easyweather.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.screens.forecastscreen.screen.util.ForecastWeatherViewModel
import com.dacoding.easyweather.presentation.screens.homescreen.screen.util.HomeWeatherViewModel
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(
    navController: NavHostController,
    homeViewModel: HomeWeatherViewModel,
    detailViewModel: ForecastWeatherViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val items = listOf(
        NavigationItem(
            route = "home",
            title = stringResource(id = R.string.navdrawer_home),
            icon = Icons.Default.Home
        ),
        NavigationItem(
            route = "forecast",
            title = stringResource(id = R.string.navdrawer_forecast),
            icon = Icons.Default.ArrowForward
        )
    )
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
//            DrawerHeader()
            DrawerBody(
                items = items,
                onItemClick = {
                    if (it.route != navController.currentDestination!!.route) {
                        when (it.route) {
                            "home" -> navController.navigate(it.route) {
                                popUpTo(it.route) {
                                    inclusive = true
                                }
                            }

                            "forecast" -> navController.navigate(it.route)
                        }
                    }

                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        },

        drawerShape = RoundedCornerShape(0.dp),
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerContentColor = MaterialTheme.colors.onBackground
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            EasyWeatherNavHost(
                navHostController = navController,
                homeViewModel = homeViewModel, forecastViewModel = detailViewModel
            )
            TopBar(
                onIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        }
    }
}


//@Composable
//fun DrawerHeader() {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 64.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Header", fontSize = 60.sp)
//    }
//}

@Composable
fun DrawerBody(
    items: List<NavigationItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = MaterialTheme.typography.h4,
    onItemClick: (NavigationItem) -> Unit
) {
    Column(modifier) {
        Spacer(modifier = Modifier.height(36.dp))
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Icon(imageVector = item.icon, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.title,
                    style = itemTextStyle,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun TopBar(
    onIconClick: () -> Unit,
) {
    val iconTintColor = MaterialTheme.colors.onBackground
//        if (isSystemInDarkTheme()) {
//            MaterialTheme.colors.onBackground
//        } else {
//            if (viewModel.state.weatherInfo?.currentWeatherData == null) {
//                MaterialTheme.colors.onBackground
//            } else {
//                MaterialTheme.colors.primary
//            }
//        }
    TopAppBar(
        modifier = Modifier.padding(top = 32.dp),
        title = {},
        elevation = 0.dp,
        backgroundColor = Color.Transparent.copy(alpha = 0.0f),
        contentColor = MaterialTheme.colors.onBackground,
        navigationIcon =
        {
            IconButton(
                onClick = onIconClick
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = iconTintColor
                )
            }
        }
    )
}