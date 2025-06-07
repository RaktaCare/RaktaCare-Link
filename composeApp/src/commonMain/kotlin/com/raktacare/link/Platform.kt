package com.raktacare.link

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun openLinkInNewTab(link: String)