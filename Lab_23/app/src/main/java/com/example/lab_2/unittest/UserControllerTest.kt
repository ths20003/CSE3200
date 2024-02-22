import com.example.lab_2.model.UserModel
import com.example.lab_2.controller.UserController
import org.junit.Assert.assertEquals
import org.junit.Test

class UserControllerTest {

    @Test
    fun testGetUserId() {
        val userModel = UserModel()
        val userController = UserController(userModel)

        val userId = userController.getUserId()

        assertEquals("", userId)
    }

    @Test
    fun testSetUserId() {
        val userModel = UserModel()
        val userController = UserController(userModel)

        userController.setUserId("example_user")
        val userId = userController.getUserId()

        assertEquals("example_user", userId)
    }
}
