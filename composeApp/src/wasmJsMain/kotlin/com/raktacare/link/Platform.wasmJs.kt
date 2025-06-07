package com.raktacare.link

import kotlinx.browser.window

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

actual fun openLinkInNewTab(link: String) {
    window.open(link, "_blank")
}