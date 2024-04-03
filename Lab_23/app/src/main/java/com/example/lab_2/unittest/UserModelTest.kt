import com.example.lab_2.model.UserModel
import org.junit.Assert.assertEquals
import org.junit.Test

class UserModelTest {

    @Test
    fun testGetUserId() {
        val userModel = UserModel()

        val userId = userModel.getUserId()

        assertEquals("", userId)
    }

    @Test
    fun testSetUserId()  {
        val userModel = UserModel()

        userModel.setUserId("example_user")
        val userId = userModel.getUserId()

        assertEquals("example_user", userId)
    }
}
