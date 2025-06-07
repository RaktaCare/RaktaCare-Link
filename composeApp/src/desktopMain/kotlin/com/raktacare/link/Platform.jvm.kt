package com.raktacare.link

import java.awt.Desktop
import java.net.URI

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun openLinkInNewTab(link: String) {
    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        try {
            Desktop.getDesktop().browse(URI(link))
        } catch (e: Exception) {
            System.err.println("Error opening URL '$link' on desktop: ${e.message}")
            e.printStackTrace()
        }
    } else {
        System.err.println("Desktop browsing is not supported on this JVM environment. Cannot open URL: $link")
    }
}