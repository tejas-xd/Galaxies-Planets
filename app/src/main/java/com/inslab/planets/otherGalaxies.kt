package com.inslab.planets

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.inslab.planets.planets.Galaxy
import com.inslab.planets.planets.PLanet
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior


@OptIn(ExperimentalSnapperApi::class)
@Composable
fun othergalaxies(
){
    val lazyListState = rememberLazyListState()
    LazyRow( state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(lazyListState),content = {
        item {
            Galaxy(painter = painterResource(id = R.drawable.milk), name = "Milky way", position = "#0", tagline = milkyTag, desc = milkyDes, size = 230)
        }
        item {
            Galaxy(painter = painterResource(id = R.drawable.andromeda), name = "Andromeda Galaxy", position = "#1", tagline = "Has the same size as Milky way", desc = "Andromeda is the closest big galaxy to the Milky Way and is expected to collide with the Milky Way around 4.5 billion years from now. The two will eventually merge into a single new galaxy called Milkdromeda", size = 230)
        }
        item {
            Galaxy(painter = painterResource(id = R.drawable.condor), name = "Conder Galaxy", position = "#2", tagline = "Named after a condor", desc = "The largest known spiral galaxy, it has a diameter of over 665,300 light-years (204.0 kilometer per second) It is tidally disturbed by the smaller galaxy IC, It is named after a type of vulture that is one of the largest flying birds.", size = 250)
        }
        item {
            Galaxy(painter = painterResource(id = R.drawable.cr7), name = "Cosmos Redshift 7", position = "#3", tagline = "Formed 800 million years after the Big Bang", desc = "Galaxy Cosmos Redshift 7 is reported to be the brightest of distant galaxies (z > 6) and to contain some of the earliest first stars (first generation; Population III) that produced the chemical elements needed for the later formation of planets and life as we know it.", size = 230)
        }
        item {
            Galaxy(painter = painterResource(id = R.drawable.large), name = "Magellanic Cloud", position = "#4", tagline = "Named after Ferdinand Magellan", desc = "This is the fourth-largest galaxy in the Local Group, and forms a pair with the SMC, and from recent research, may not be part of the Milky Way system of satellites at all.", size = 230)
        }
        item {
            Galaxy(painter = painterResource(id = R.drawable.mayall_s), name = "Mayall's Object", position = "#5", tagline = "Named after Nicholas Mayall", desc = "Also called VV 32 and Arp 148, this is a very peculiar looking object, and is likely to be not one galaxy, but two galaxies undergoing a collision. Event in images is a spindle shape and a ring shape.", size = 230)
        }
    }
    )
}