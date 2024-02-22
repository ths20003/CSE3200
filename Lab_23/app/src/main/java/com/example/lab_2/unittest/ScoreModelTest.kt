import com.example.lab_2.model.ScoreModel
import org.junit.Assert.assertEquals
import org.junit.Test

class ScoreModelTest {

    @Test
    fun testGetScore() {
        val scoreModel = ScoreModel()

        val currentScore = scoreModel.getScore()

        assertEquals(0, currentScore)
    }

    @Test
    fun testIncrementScore() {
        val scoreModel = ScoreModel()

        scoreModel.incrementScore()
        val currentScore = scoreModel.getScore()

        assertEquals(1, currentScore)
    }

    @Test
    fun testResetScore() {
        val scoreModel = ScoreModel()

        scoreModel.incrementScore()
        scoreModel.incrementScore()
        scoreModel.resetScore()
        val currentScore = scoreModel.getScore()

        assertEquals(0, currentScore)
    }
}
