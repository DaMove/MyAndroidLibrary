package com.daryeetey.myandroidlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daryeetey.image_preview.ImagePreview
import com.daryeetey.myandroidlibrary.ui.theme.MyAndroidLibraryTheme

/*
1st create your library code locally

2nd Create a Module ( Android Library Module)and give it a name eg image-preview

3. Cut and paste the Library Code into your library module

4th. Check to make sure your dependencies are included in your libraries module build.gradle

5th try to use your unpublished library code in your app module and you notice that
 the compiler can't find it so you go to the dependencies block of the build'gradle of your app module and type since it's unpublished:

 implementation project(':image-preview') OR  implementation(project(":image-preview"))

 6th Choose your publishing option


 -scroll to the top of your library module's build.gradle and within the plugins block type
  id 'maven-publish' OR     id ("maven-publish")
   and go to the bottom of the page and paste the ff:

   afterEvaluate {
    publishing {
        publications {
            release(MavenPublication) {
                from components.release

                groupId = 'com.github.philipplackner'
                artifactId = 'image-preview-compose'
                version = '1.0'
            }
        }
    }
}

7th switch to the Project view >new > file and name it jitpack.yml
which is meant for the ff config:


 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAndroidLibraryTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ImagePreview(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }

                ImagePreview()
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyAndroidLibraryTheme {
//        ImagePreview("Android")
//    }
//}