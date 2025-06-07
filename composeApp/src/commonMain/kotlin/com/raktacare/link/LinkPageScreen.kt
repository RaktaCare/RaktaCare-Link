package com.raktacare.link

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.Interests
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import raktacarelink.composeapp.generated.resources.Res
import raktacarelink.composeapp.generated.resources.app_logo


/**
 * Represents a single link button on the page.
 * @param icon The icon to display next to the text.
 * @param text The label for the button.
 * @param url The destination URL for the link.
 */
data class LinkData(
    val icon: ImageVector,
    val text: String,
    val url: String
)

/**
 * The main screen, which is responsive to different screen sizes.
 */
@Composable
fun LinkPageScreen() {

    val raktaCareSocials = remember {
        listOf(
            LinkData(Icons.Default.Business, "LinkedIn", "https://www.linkedin.com/showcase/raktacare/"),
            LinkData(Icons.Default.Facebook, "Facebook", "https://www.facebook.com/profile.php?id=61572642484411"),
            LinkData(Icons.Default.CameraAlt, "Instagram", "https://instagram.com/raktacare"),
            LinkData(Icons.Default.Close, "X (Twitter)", "https://x.com/raktacare"),
            LinkData(Icons.Default.Code, "GitHub", "https://github.com/RaktaCare"),
            LinkData(Icons.Default.PlayCircle, "YouTube", "https://youtube.com/@RaktaCare"),
            LinkData(Icons.Default.Forum, "Threads", "https://threads.net/@raktacare"),
            LinkData(Icons.Default.Interests, "Pinterest", "https://pinterest.com/raktacare")
        )
    }

    val innoveloperSocials = remember {
        listOf(
            LinkData(Icons.Default.Business, "LinkedIn", "https://www.linkedin.com/company/innoveloper"),
            LinkData(Icons.Default.Facebook, "Facebook", "https://www.facebook.com/profile.php?id=61572629983165"),
            LinkData(Icons.Default.CameraAlt, "Instagram", "https://www.instagram.com/innoveloper/"),
            LinkData(Icons.Default.Close, "X (Twitter)", "https://x.com/Innoveloper"),
            LinkData(Icons.Default.Code, "GitHub", "https://github.com/Innoveloper"),
            LinkData(Icons.Default.PlayCircle, "YouTube", "https://www.youtube.com/@Innoveloper"),
            LinkData(Icons.Default.Forum, "Threads", "https://www.threads.net/@innoveloper"), // Using a generic icon
            LinkData(Icons.Default.Interests, "Pinterest", "https://in.pinterest.com/innoveloper")
        )
    }

    val projectLinks = remember {
        listOf(
            LinkData(Icons.Default.Description, "Wiki", "https://innoveloper.atlassian.net/wiki/spaces"),
            LinkData(Icons.Default.Checklist, "Task", "https://innoveloper.atlassian.net/jira/software/projects/RC/summary"),
            LinkData(Icons.Default.Draw, "Figma", "https://www.figma.com/file/sO12Xs4ETrJc2QUkvLBhg6/RaktaCare"),
            LinkData(Icons.Default.MonetizationOn, "Revenue Model", "https://www.figma.com/board/9ETW3s7Wx0XLJDRj5eISlQ/App-Revenue-Model?t=WMwBSfBJuwILcRGT-0"),
            LinkData(Icons.Default.AccountTree, "App Flow", "https://whimsical.com/app-flow-VoB5FcrbN9C1KgajyZRjud"),
            LinkData(Icons.Default.Storage, "Database", "https://app.eraser.io/workspace/6vjEBmlI6sQwICBZsgbO")
        )
    }

    // Use BoxWithConstraints to get the available screen size and adapt the layout.
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF0F2F5))
    ) {
        val contentWidth = if (maxWidth > 600.dp) {
            Modifier.width(580.dp)
        } else {
            Modifier.fillMaxWidth().padding(horizontal = 24.dp)
        }

        LazyColumn(
            modifier = Modifier.align(Alignment.TopCenter).then(contentWidth),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 40.dp)
        ) {
            // --- Profile Section ---
            item {
                ProfileSection(
                    name = "RaktaCare",
                    bio = "Connecting blood donors with those in need. Powered by Innoveloper."
                )
                Spacer(Modifier.height(16.dp))
            }

            // --- Project Links Section ---
            item {
                Spacer(Modifier.height(16.dp))
                SectionHeader("Project Resources")
            }
            items(projectLinks) { link ->
                LinkButton(link) { openLinkInNewTab(link.url) }
            }

            // --- RaktaCare Socials Section ---
            item { SectionHeader("RaktaCare Socials") }
            items(raktaCareSocials) { link ->
                LinkButton(link) { openLinkInNewTab(link.url) }
            }

            // --- Innoveloper Socials Section ---
            item {
                Spacer(Modifier.height(16.dp))
                SectionHeader("Innoveloper Socials")
            }
            items(innoveloperSocials) { link ->
                LinkButton(link) { openLinkInNewTab(link.url) }
            }
        }
    }
}

/**
 * Displays the profile picture, name, and biography.
 */
@Composable
fun ProfileSection(name: String, bio: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painterResource(Res.drawable.app_logo), // Heart icon for blood donation theme
            contentDescription = "RaktaCare Logo",
            modifier = Modifier.size(120.dp).clip(CircleShape)
        )

        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = bio,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

/**
 * A simple text header for different sections of links.
 */
@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

/**
 * A styled button for a single link.
 */
@Composable
fun LinkButton(link: LinkData, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp, pressedElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(link.icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.width(16.dp))
            Text(
                text = link.text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f)
            )
            Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, modifier = Modifier.size(16.dp))
        }
    }
}