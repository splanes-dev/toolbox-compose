package com.splanes.apps.toolbox.components.navhost

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedNavHost(
    navController: NavHostController,
    graph: NavGraph,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    builder: @Composable (NavGraphNode) -> Unit
) {
    com.google.accompanist.navigation.animation.AnimatedNavHost(
        modifier = modifier,
        navController = navController,
        startDestination = graph.root,
        contentAlignment = contentAlignment
    ) {
        buildGraph(graph.nodes, builder)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.buildGraph(nodes: List<NavGraphNode>, builder: @Composable (NavGraphNode) -> Unit) {
    nodes.forEach { node ->
        if (node.isFinal) {
            composable(
                route = node.route,
                enterTransition = { node.onEnter(initialState) },
                exitTransition = { node.onExit(targetState) },
                popEnterTransition = { node.onPopEnter(initialState) },
                popExitTransition = { node.onPopExit(targetState) },
            ) {
                builder(node)
            }
        } else {
            navigation(
                route = node.route,
                startDestination = node.subgraphRoot ?: error("Sub graph start destination cannot be null")
            ) {
                buildGraph(node.subgraph, builder)
            }
        }
    }
}