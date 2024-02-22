import com.example.lab_2.model.QuestionsModel
import org.junit.Assert.assertEquals
import org.junit.Test

class QuestionsModelTest {

    @Test
    fun testGetCurrentQuestion() {
        val questionsModel = QuestionsModel(listOf("Question 1", "Question 2", "Question 3"))

        val currentQuestion = questionsModel.getCurrentQuestion()

        assertEquals("Question 1", currentQuestion)
    }

    @Test
    fun testMoveToNextQuestion() {
        val questionsModel = QuestionsModel(listOf("Question 1", "Question 2", "Question 3"))

        questionsModel.moveToNextQuestion()
        val currentQuestion = questionsModel.getCurrentQuestion()

        assertEquals("Question 2", currentQuestion)
    }

    @Test
    fun testResetQuestions() {
        val questionsModel = QuestionsModel(listOf("Question 1", "Question 2", "Question 3"))

        questionsModel.moveToNextQuestion()
        questionsModel.moveToNextQuestion()
        questionsModel.resetQuestions()
        val currentQuestion = questionsModel.getCurrentQuestion()

        assertEquals("Question 1", currentQuestion)
    }
}
