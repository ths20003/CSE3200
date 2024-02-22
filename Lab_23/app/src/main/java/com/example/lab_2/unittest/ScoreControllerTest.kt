import com.example.lab_2.model.ScoreModel
import com.example.lab_2.controller.ScoreController
import org.junit.Assert.assertEquals
import org.junit.Test

class ScoreControllerTest {

    @Test
    fun testGetScore() {
        val scoreModel = ScoreModel()
        val scoreController = ScoreController(scoreModel)

        val currentScore = scoreController.getScore()

        assertEquals(0, currentScore)
    }

    @Test
    fun testIncrementScore() {
        val scoreModel = ScoreModel()
        val scoreController = ScoreController(scoreModel)

        scoreController.incrementScore()
        val currentScore = scoreController.getScore()

        assertEquals(1, currentScore)
    }

    @Test
    fun testResetScore() {
        val scoreModel = ScoreModel()
        val scoreController = ScoreController(scoreModel)

        scoreController.incrementScore()
        scoreController.incrementScore()
        scoreController.resetScore()
        val currentScore = scoreController.getScore()

        assertEquals(0, currentScore)
    }
}
