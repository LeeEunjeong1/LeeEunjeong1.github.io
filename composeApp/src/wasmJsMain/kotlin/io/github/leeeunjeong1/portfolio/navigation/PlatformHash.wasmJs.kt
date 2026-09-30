@file:OptIn(kotlin.js.ExperimentalWasmJsInterop::class)

package io.github.leeeunjeong1.portfolio.navigation

@JsFun("() => window.location.hash")
private external fun readHash(): String

@JsFun("(hash) => { window.location.hash = hash; }")
private external fun writeHash(hash: String)

actual fun currentLocationHash(): String = readHash()

actual fun updateLocationHash(hash: String) = writeHash(hash)
