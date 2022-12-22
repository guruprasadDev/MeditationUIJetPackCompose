package com.example.meditationui.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.Feature
import com.example.meditationui.R
import com.example.meditationui.standardQuadFromTo
import com.example.meditationui.ui.theme.*


@Preview
@Composable
fun SleepMediationUi(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(top = 30.dp, start = 5.dp, end = 5.dp)
                .weight(1f, fill = false)
        ) {
            OnClickBackAndFeaturedIcon(
                backIcon = R.drawable.ic_arrow_back,
                fav = R.drawable.ic_star
            )
            PracticeMediation()
            FeatureSections(
                feature = listOf(
                    Feature(
                        "",
                        R.drawable.ic_headphone,
                        BlueViolet1, BlueViolet2, BlueViolet3
                    )
                )
            )
            WatchTime()
            Description()
            SavedStarsAndLeste()
            DividerLine()
            FeatureSection(
                modifier = modifier.height(300.dp),
                feature = listOf(
                    Feature(
                        title = "Sleep Mediation",
                        R.drawable.ic_headphones,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_headphones,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night Island",
                        R.drawable.ic_headphones,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphones,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Sleeping Mediation",
                        R.drawable.ic_headphones,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Sleeping Mediation",
                        R.drawable.ic_headphones,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                ), title = "Related"
            )
        }
    }
}


@Composable
fun OnClickBackAndFeaturedIcon(
    @DrawableRes backIcon: Int,
    @DrawableRes fav: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Icon(
            painter = painterResource(id = backIcon),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
        Icon(
            painter = painterResource(id = fav),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(30.dp)

        )
    }
}

@Composable
fun PracticeMediation() {
    Column(modifier = Modifier.padding(all = 16.dp)) {
        Text(
            text = "Sleep Mediation",
            style = MaterialTheme.typography.h4,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Best practice mediation",
            style = MaterialTheme.typography.body1,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 10.dp),
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSections(feature: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
        ) {
            items(feature.size) {
                FeatureItems(feature = feature[it])
            }
        }
    }
}

@Composable
fun FeatureItems(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .aspectRatio(1.5f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)

    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.4f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint4.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = mediumColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Icon(
                painter = painterResource(id = feature.iconId), contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(40.dp)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 10.dp, horizontal = 20.dp)
            )
        }
    }
}

@Composable
fun WatchTime() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp, top = 20.dp)
    ) {
        Text(
            "Sleep music",
            Modifier.padding(end = 10.dp),
            color = Color.LightGray,
            20.sp,
        )
        Text(" • 45 min", Modifier.padding(start = 5.dp), color = Color.LightGray, 20.sp)
    }
}

@Composable
fun Description() {
    Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
        Text(
            "Ease the mind into a restful nights sleep\nwith these deep, amblent tones.",
            Modifier.padding(1.dp),
            color = Color.LightGray,
            18.sp
        )
    }
}

@Composable
fun SavedStarsAndLeste() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(16.dp, top = 30.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(30.dp)
        )
        Text(
            text = "12,542 Saved",
            Modifier.padding(start = 6.dp, end = 10.dp),
            color = Color.LightGray,
            17.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_headphone),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(start = 40.dp)
        )
        Text(
            text = "43,453 Lessening",
            Modifier.padding(start = 8.dp),
            color = Color.LightGray,
            17.sp
        )
    }
}

@Composable
fun DividerLine() {
    Row(modifier = Modifier.padding(16.dp, top = 30.dp, bottom = 10.dp, end = 5.dp)) {
        Divider(color = Color(0XFF172b61), thickness = 2.dp)
    }
}


