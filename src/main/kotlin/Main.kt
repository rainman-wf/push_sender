import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream
import java.util.*

fun main() {

    val serviceAccount = FileInputStream("fcm.json")

    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()

    FirebaseApp.initializeApp(options)

//    val message = Message.builder()
//        .putData("action", "LIKE")
//        .putData("content", """{
//            "userId": 1,
//            "userName": "Vasiliy",
//            "postId": 2,
//            "postAuthor": "Netology"
//        }""".trimIndent())
//        .setToken(System.getenv("TOKEN"))
//        .build()

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
            "id": 101,
            "author": "Нетология. Университет интернет-профессий будущего.",
            "authorAvatar": "https://netology.ru/apple-touch-icon.png",
            "published": ${Date().time},
            "content": "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остается с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен! https://youtu.be/b0JEgo176iQ",
            "firstUrl": "https://youtu.be/b0JEgo176iQ",
            "thumbnail_url": "https://i.ytimg.com/vi/b0JEgo176iQ/hqdefault.jpg",
            "thumbnail_width": 480,
            "thumbnail_height": 360
            }""".trimIndent())
        .setToken(System.getenv("TOKEN"))
        .build()

    FirebaseMessaging.getInstance().send(message)

}



