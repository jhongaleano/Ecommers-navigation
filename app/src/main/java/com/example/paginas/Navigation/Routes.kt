package com.example.paginas.Navigation

import androidx.navigation3.runtime.NavKey
import com.example.paginas.Models.ProductItem
import kotlinx.serialization.Serializable
import java.net.NoRouteToHostException

sealed class Routes : NavKey {
    @Serializable
    data object First : Routes()
    /*@Serializable
    data object Second: Routes()
*/
    @Serializable
    data class Second(
        val product : ProductItem
    ) : Routes()

    @Serializable
    data class Third(
        val product : ProductItem
    ) : Routes()
    @Serializable
    data object Cart : Routes()

    @Serializable
    data object Login : Routes()

    @Serializable
    data object Register : Routes()
    @Serializable
    data object  Error : Routes()

    @Serializable
    data class CapturarDatos(
        var pass: String,
        var user : String
    ): Routes()
}