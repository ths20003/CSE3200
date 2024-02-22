import com.example.lab_2.model.QuestionsModel
import com.example.lab_2.controller.QuestionsController
import org.junit.Assert.assertEquals
import org.junit.Test

class QuestionsControllerTest {

    @Test
    fun testGetCurrentQuestion() {
        val questionsModel = QuestionsModel(listOf("Question 1", "Question 2", "Question 3"))
        val questionsController = QuestionsController(questionsModel)

        val currentQuestion = questionsController.getCurrentQuestion()

        assertEquals("Question 1", currentQuestion)
    }

    @Test
    fun testMoveToNextQuestion() {
        val questionsModel = QuestionsModel(listOf("Question 1", "Question 2", "Question 3"))
        val questionsController = QuestionsController(questionsModel)

        questionsController.moveToNextQuestion()
        val currentQuestion = questionsController.getCurrentQuestion()

        assertEquals("Question 2", currentQuestion)
    }

    @Test
    fun testResetQuestions() {
        val questionsModel = QuestionsModel(listOf("Question 1", "Question 2", "Question 3"))
        val questionsController = QuestionsController(questionsModel)

        questionsController.moveToNextQuestion()
        questionsController.moveToNextQuestion()
        questionsController.resetQuestions()
        val currentQuestion = questionsController.getCurrentQuestion()

        assertEquals("Question 1", currentQuestion)
    }
}
