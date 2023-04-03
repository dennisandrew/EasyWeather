package com.dacoding.easyweather.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
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
import com.dacoding.easyweather.presentation.WeatherViewModel
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(
    navController: NavHostController,
    viewModel: WeatherViewModel
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
            route = "settings",
            title = stringResource(id = R.string.navdrawer_settings),
            icon = Icons.Default.Settings
        )
    )
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
//            DrawerHeader()
            DrawerBody(
                items = items,
                onItemClick = {
                    when (it.route) {
                        "home" -> navController.navigate(it.route)
                        "settings" -> navController.navigate(it.route)
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
            EasyWeatherNavHost(navHostController = navController, viewModel = viewModel)
            TopBar(
                viewModel = viewModel,
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
    viewModel: WeatherViewModel
) {
    val iconTintColor =
        if (isSystemInDarkTheme()) {
            MaterialTheme.colors.onBackground
        } else {
            if (viewModel.state.weatherInfo?.currentWeatherData == null) {
                MaterialTheme.colors.onBackground
            } else {
                MaterialTheme.colors.primary
            }
        }
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