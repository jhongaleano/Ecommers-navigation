package com.example.paginas.Navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import java.net.NoRouteToHostException

sealed class Routes : NavKey {
    @Serializable
    data object First : Routes()

    @Serializable
    data object  Second : Routes()

    @Serializable
    data object Third : Routes()

    @Serializable
    data object Login : Routes()

    @Serializable
    data object Register : Routes()
    @Serializable
    data object  Error : Routes()
}