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

fun navGraphNodeOf(
    route: String,
    subgraph: List<NavGraphNode> = emptyList(),
    subgraphRoot: String? = null
) = object : NavGraphNode {
    override val route: String = route
    override val subgraph: List<NavGraphNode> = subgraph
    override val subgraphRoot: String? = subgraphRoot
}

val NavGraphNode.isFinal: Boolean get() = subgraph.isEmpty()