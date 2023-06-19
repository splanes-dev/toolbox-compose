package com.splanes.apps.toolbox.components.navhost

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry

interface NavGraphNode {
    val route: String
    val subgraph: List<NavGraphNode> get() = emptyList()
    val subgraphRoot: String? get() = null

    fun onEnter(initialState: NavBackStackEntry): EnterTransition =
        EnterTransition.None

    fun onExit(targetState: NavBackStackEntry): ExitTransition =
        ExitTransition.None

    fun onPopEnter(initialState: NavBackStackEntry): EnterTransition =
        EnterTransition.None

    fun onPopExit(targetState: NavBackStackEntry): ExitTransition =
        ExitTransition.None
}

val NavGraphNode.isFinal: Boolean get() = subgraph.isEmpty()