package com.bitkeep.w

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bitkeep.w.R


const val MONETS = "credits"

class CreditsActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var buttonOne: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFive: Button
    private lateinit var buttonSeven: Button
    private lateinit var buttonNine: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)
        window.statusBarColor = getColor(R.color.statusBarColor)

        initView()

        startButton.isEnabled == false

        buttonOne.setOnClickListener {
            startButton.isEnabled == true
            buttonOne.setBackgroundColor(Color.GREEN)
            buttonThree.setBackgroundColor(0)
            buttonFive.setBackgroundColor(0)
            buttonSeven.setBackgroundColor(0)
            buttonNine.setBackgroundColor(0)

            startButton.setOnClickListener {
                val amount = 100
                val intent = Intent(this, Game::class.java)
                intent.putExtra("credits", amount)
                startActivity(intent)
                buttonOne.setBackgroundColor(0)
            }

        }

        buttonThree.setOnClickListener {
            startButton.isEnabled == true
            buttonThree.setBackgroundColor(Color.GREEN)
            buttonOne.setBackgroundColor(0)
            buttonFive.setBackgroundColor(0)
            buttonSeven.setBackgroundColor(0)
            buttonNine.setBackgroundColor(0)

            startButton.setOnClickListener {
                val amount = 300
                val intent = Intent(this, Game::class.java)
                intent.putExtra("credits", amount)
                startActivity(intent)
                buttonOne.setBackgroundColor(0)

            }

        }

        buttonFive.setOnClickListener {
            startButton.isEnabled == true
            buttonFive.setBackgroundColor(Color.GREEN)
            buttonThree.setBackgroundColor(0)
            buttonOne.setBackgroundColor(0)
            buttonSeven.setBackgroundColor(0)
            buttonNine.setBackgroundColor(0)

            startButton.setOnClickListener {
                val amount = 500
                val intent = Intent(this, Game::class.java)
                intent.putExtra("credits", amount)
                startActivity(intent)
                buttonOne.setBackgroundColor(0)

            }
        }

        buttonSeven.setOnClickListener {
            startButton.isEnabled == true
            buttonSeven.setBackgroundColor(Color.GREEN)
            buttonThree.setBackgroundColor(0)
            buttonFive.setBackgroundColor(0)
            buttonOne.setBackgroundColor(0)
            buttonNine.setBackgroundColor(0)

            startButton.setOnClickListener {
                val amount = 700
                val intent = Intent(this, Game::class.java)
                intent.putExtra("credits", amount)
                startActivity(intent)
                buttonOne.setBackgroundColor(0)
            }
        }

        buttonNine.setOnClickListener {
            startButton.isEnabled == true
            buttonNine.setBackgroundColor(Color.GREEN)
            buttonThree.setBackgroundColor(0)
            buttonFive.setBackgroundColor(0)
            buttonSeven.setBackgroundColor(0)
            buttonOne.setBackgroundColor(0)

            startButton.setOnClickListener {
                val amount = 900
                val intent = Intent(this, Game::class.java)
                intent.putExtra("credits", amount)
                startActivity(intent)
                buttonOne.setBackgroundColor(0)

            }
        }

    }

    private fun initView() {

        startButton = findViewById(R.id.buttonStart)
        buttonOne = findViewById(R.id.buttonOne)
        buttonThree = findViewById(R.id.buttonThree)
        buttonFive = findViewById(R.id.buttonFive)
        buttonSeven = findViewById(R.id.buttonSeven)
        buttonNine = findViewById(R.id.buttonNine)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()

    }
}