package com.dacoding.easyweather.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dacoding.easyweather.R
import com.dacoding.easyweather.presentation.screens.detailscreen.screen.util.DetailWeatherViewModel
import com.dacoding.easyweather.presentation.screens.forecastscreen.screen.util.ForecastWeatherViewModel
import com.dacoding.easyweather.presentation.screens.homescreen.screen.util.HomeWeatherViewModel
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(
    navController: NavHostController,
    homeViewModel: HomeWeatherViewModel,
    forecastViewModel: ForecastWeatherViewModel,
    detailWeatherViewModel: DetailWeatherViewModel
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
            route = "detail",
            title = stringResource(id = R.string.navdrawer_detail),
            icon = Icons.Default.Menu
        ),
        NavigationItem(
            route = "forecast",
            title = stringResource(id = R.string.navdrawer_forecast),
            icon = Icons.Default.WbSunny
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
                                homeViewModel.loadWeatherInfo()
                                popUpTo(it.route) {
                                    inclusive = true
                                }
                            }

                            "detail" -> navController.navigate(it.route) {
                                detailWeatherViewModel.loadWeatherInfo()
                            }

                            "forecast" -> navController.navigate(it.route) {
                                forecastViewModel.loadWeatherInfo()
                            }
                        }
                    }
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 48.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val gmailLink =
                    "https://mail.google.com/mail/?view=cm&fs=1&to=" +
                            "denisandreev1803@gmail.com" +
                            "&su=SUBJECT&body=BODY&bcc=" +
                            "denisandreev1803@gmail.com"
                Divider()
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_github_mark),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                    HyperlinkText(
                        modifier = Modifier.padding(start = 16.dp),
                        fullText = "https://github.com/dennisandrew",
                        linkText = listOf("https://github.com/dennisandrew"),
                        hyperLinks = listOf("https://github.com/dennisandrew"),
                        fontSize = MaterialTheme.typography.body1.fontSize,
                        linkTextColor = MaterialTheme.colors.onBackground,
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                    HyperlinkText(
                        modifier = Modifier.padding(start = 16.dp),
                        fullText = "denisandreev1803@gmail.com",
                        linkText = listOf("denisandreev1803@gmail.com"),
                        hyperLinks = listOf(gmailLink),
                        fontSize = MaterialTheme.typography.body1.fontSize,
                        linkTextColor = MaterialTheme.colors.onBackground,
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_telegram_mark),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                    HyperlinkText(
                        modifier = Modifier.padding(start = 16.dp),
                        fullText = "@mr_invict",
                        linkText = listOf("@mr_invict"),
                        hyperLinks = listOf("https://t.me/mr_invict"),
                        fontSize = MaterialTheme.typography.body1.fontSize,
                        linkTextColor = MaterialTheme.colors.onBackground,
                    )
                }
            }
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
                homeViewModel = homeViewModel,
                forecastViewModel = forecastViewModel,
                detailWeatherViewModel = detailWeatherViewModel
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

 @Composable
 fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 36.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(128.dp),
            painter = painterResource(
                id = R.drawable.twotone_cloud_24
            ),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground

        )
    }
 }

@Composable
fun DrawerBody(
    items: List<NavigationItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = MaterialTheme.typography.h4,
    onItemClick: (NavigationItem) -> Unit
) {
    Column(
        modifier
            .padding(top = 36.dp)
    ) {
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
