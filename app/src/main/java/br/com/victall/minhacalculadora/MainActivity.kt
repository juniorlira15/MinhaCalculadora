package br.com.victall.minhacalculadora

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.victall.minhacalculadora.R

class MainActivity : AppCompatActivity() {

    // Result and operation TextViews
    private lateinit var resultText: TextView
    private lateinit var operationText: TextView

    // Calculator buttons
    private lateinit var acButton: Button
    private lateinit var plusMinusButton: Button
    private lateinit var percentageButton: Button
    private lateinit var divideButton: Button
    private lateinit var sevenButton: Button
    private lateinit var eightButton: Button
    private lateinit var nineButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var fourButton: Button
    private lateinit var fiveButton: Button
    private lateinit var sixButton: Button
    private lateinit var minusButton: Button
    private lateinit var oneButton: Button
    private lateinit var twoButton: Button
    private lateinit var threeButton: Button
    private lateinit var plusButton: Button
    private lateinit var zeroButton: Button
    private lateinit var decimalButton: Button
    private lateinit var equalsButton: Button
    private lateinit var backSpaceButton: ImageButton
    private lateinit var listabuttons: List<Button>
    private lateinit var operationButtons: List<Button>


    // GridLayout for the buttons
    private lateinit var buttonGrid: GridLayout

    private var currentOperation: String? = null
    private var firstOperand: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        clear()

        acButton.setOnClickListener {
            clear()
        }

        backSpaceButton.setOnClickListener {
            val operation = operationText.text.toString()
            if (operation.isNotEmpty()) {
                operationText.text = operation.substring(0, operation.length - 1)
            }
        }

        listabuttons = listOf(
            sevenButton, eightButton, nineButton, fourButton, fiveButton, sixButton,
            oneButton, twoButton, threeButton, zeroButton, decimalButton
        )

        operationButtons = listOf(
            plusMinusButton, percentageButton, divideButton, multiplyButton, minusButton, plusButton
        )

        for (button in listabuttons) {
            button.setOnClickListener {
                operationText.text = operationText.text.toString() + button.text
                enableOperationButtons(true)
            }
        }

        for (button in operationButtons) {
            button.setOnClickListener {
                if (operationText.text.isNotEmpty()) {
                    firstOperand = operationText.text.toString().toDouble()
                    currentOperation = button.text.toString()
                    operationText.text = operationText.text.toString() + button.text
                    enableOperationButtons(false)
                }
            }
        }

        equalsButton.setOnClickListener {
            if (operationText.text.isNotEmpty() && currentOperation != null && firstOperand != null) {
                val secondOperand = operationText.text.toString().toDouble()
                val result = performOperation(firstOperand!!, secondOperand, currentOperation!!)
                resultText.text = result.toString()
                operationText.text = ""
                firstOperand = null
                currentOperation = null
                enableOperationButtons(false)
            }
        }


    }


    private fun performOperation(a: Double, b: Double, operation: String): Double {
        return when (operation) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b == 0.0) throw UnsupportedOperationException("Cannot divide by zero") else a / b
            else -> 0.0
        }
    }

    private fun enableOperationButtons(enable: Boolean) {
        for (button in operationButtons) {
            button.isEnabled = enable
        }
    }

    private fun initializeViews() {
        // Initialize TextViews
        resultText = findViewById(R.id.resultText)
        operationText = findViewById(R.id.operationText)

        // Initialize Buttons
        acButton = findViewById(R.id.acButton)
        plusMinusButton = findViewById(R.id.plusMinusButton)
        percentageButton = findViewById(R.id.percentageButton)
        divideButton = findViewById(R.id.divideButton)
        sevenButton = findViewById(R.id.sevenButton)
        eightButton = findViewById(R.id.eightButton)
        nineButton = findViewById(R.id.nineButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        fourButton = findViewById(R.id.fourButton)
        fiveButton = findViewById(R.id.fiveButton)
        sixButton = findViewById(R.id.sixButton)
        minusButton = findViewById(R.id.minusButton)
        oneButton = findViewById(R.id.oneButton)
        twoButton = findViewById(R.id.twoButton)
        threeButton = findViewById(R.id.threeButton)
        plusButton = findViewById(R.id.plusButton)
        zeroButton = findViewById(R.id.zeroButton)
        decimalButton = findViewById(R.id.decimalButton)
        equalsButton = findViewById(R.id.equalsButton)
        backSpaceButton = findViewById(R.id.backSpaceButton)

        // Initialize GridLayout
        buttonGrid = findViewById(R.id.buttonGrid)
    }

    private fun clear() {
        resultText.text = "0"
        operationText.text = ""
    }

}
