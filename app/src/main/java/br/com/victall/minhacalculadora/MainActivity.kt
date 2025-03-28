package br.com.victall.minhacalculadora

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

        clearAll()

        listabuttons = listOf(sevenButton, eightButton, nineButton, fourButton, fiveButton, sixButton, oneButton, twoButton, threeButton, zeroButton, decimalButton)

        operationButtons = listOf(plusButton, minusButton, multiplyButton, divideButton)

        clear()

        for (button in listabuttons) {
            button.setOnClickListener {
                val currentText = operationText.text.toString()
                operationText.text = currentText + button.text
            }
        }

    }

    private fun clear() {
        backSpaceButton.setOnClickListener() {
            val currentText = operationText.text.toString()
            if (currentText.isNotEmpty()) {
                operationText.text = currentText.dropLast(1)
            }
        }
    }

    private fun clearAll() {
        acButton.setOnClickListener {
            resultText.text = "0"
            operationText.text = ""
        }
    }

    private fun initializeViews() {
        resultText = findViewById(R.id.resultText)
        operationText = findViewById(R.id.operationText)
        acButton = findViewById(R.id.acButton)
        buttonGrid = findViewById(R.id.buttonGrid)
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
        divideButton = findViewById(R.id.divideButton)

    }


}
