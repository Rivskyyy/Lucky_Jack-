package com.bitkeep.w

import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bitkeep.w.R
import kotlin.random.Random

class Game : AppCompatActivity() {

    private lateinit var creditsAmount: TextView
    private lateinit var buttonSpin: Button

    private lateinit var imageSlot1: ImageButton
    private lateinit var imageSlot2: ImageButton
    private lateinit var imageSlot3: ImageButton

    private lateinit var imageSlot1Second: ImageButton
    private lateinit var imageSlot2Second: ImageButton
    private lateinit var imageSlot3Second: ImageButton
    private lateinit var imageSlot1Third: ImageButton
    private lateinit var imageSlot2Third: ImageButton
    private lateinit var imageSlot3Third: ImageButton

    private lateinit var linearLayoutSlots: LinearLayout
    private lateinit var linearLayoutSecond: LinearLayout
    private lateinit var linearLayoutThird: LinearLayout

    private var img1 = 156565
    private var img2 = 25656
    private var img3 = 35656
    private var img4 = 4557
    private var img5 = 5454
    private var img6 = 62424
    private var img7 = 7123
    private var img8 = 111
    private var img9 = 111111

    private var monetsAmount = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        window.statusBarColor = getColor(R.color.statusBarColor)
        initViews()
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        val animation_spin: Animation = AnimationUtils.loadAnimation(this, R.anim.spin_anim)

        linearLayoutSlots.startAnimation(animation_spin)
        linearLayoutSecond.startAnimation(animation_spin)
        linearLayoutThird.startAnimation(animation_spin)

        monetsAmount = intent.getIntExtra("credits", -1)
        creditsAmount.text = monetsAmount.toString()
        Log.d("coins", monetsAmount.toString())

        imageSlot1.setOnClickListener {

            img1 = Random.nextInt(1, 6)

            when (img1) {
                1 -> {
                    imageSlot1.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot1.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot1.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot1.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot1.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot1.setImageResource(R.drawable.slot_6)
                }
            }

            if (img1 == img2 || img2 == img3 || img1 == img3) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }


            if (imageSlot1.isClickable || monetsAmount <= 69) {
                imageSlot1.isEnabled = false
            }

            imageSlot1.startAnimation(animation)

        }

        imageSlot2.setOnClickListener {

            img2 = Random.nextInt(1, 6)

            when (img2) {
                1 -> {
                    imageSlot2.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot2.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot2.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot2.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot2.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot2.setImageResource(R.drawable.slot_6)
                }
            }

            if (img1 == img2 || img2 == img3 || img1 == img3) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }

            if (monetsAmount <= 19) {
                imageSlot2.isEnabled = false

            }
            if (imageSlot2.isClickable) {
                imageSlot2.isEnabled = false
            }

            imageSlot2.startAnimation(animation)

        }
        imageSlot3.setOnClickListener {

            img3 = Random.nextInt(1, 6)
            if (monetsAmount <= 99) {
                buttonSpin.isEnabled = false
            }
            when (img3) {
                1 -> {
                    imageSlot3.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot3.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot3.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot3.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot3.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot3.setImageResource(R.drawable.slot_6)
                }
            }

            if (img1 == img2 || img2 == img3 || img1 == img3) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }
            if (imageSlot3.isClickable || monetsAmount <= 19) {
                imageSlot3.isEnabled = false
            }

            imageSlot3.startAnimation(animation)
            Log.d("coin", monetsAmount.toString())
        }

        imageSlot1Second.setOnClickListener {

            img4 = Random.nextInt(1, 6)
            if (monetsAmount <= 99) {
                buttonSpin.isEnabled = false
            }
            when (img4) {
                1 -> {
                    imageSlot1Second.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot1Second.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot1Second.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot1Second.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot1Second.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot1Second.setImageResource(R.drawable.slot_6)
                }
            }

            if (img3 == img4 || img4 == img5 || img5 == img6 || img4 == img6) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }

            if (imageSlot1Second.isClickable || monetsAmount <= 19) {
                imageSlot1Second.isEnabled = false
            }

            imageSlot1Second.startAnimation(animation)
            Log.d("coin", monetsAmount.toString())
        }

        imageSlot2Second.setOnClickListener {

            img5 = Random.nextInt(1, 6)
            if (monetsAmount <= 99) {
                buttonSpin.isEnabled = false
            }
            when (img5) {
                1 -> {
                    imageSlot2Second.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot2Second.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot2Second.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot2Second.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot2Second.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot2Second.setImageResource(R.drawable.slot_6)
                }
            }
            if (img4 == img5 || img5 == img6 || img4 == img6) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }

            if (imageSlot2Second.isClickable || monetsAmount <= 19) {
                imageSlot2Second.isEnabled = false
            }

            imageSlot2Second.startAnimation(animation)

        }
        imageSlot3Second.setOnClickListener {

            img6 = Random.nextInt(1, 6)
            if (monetsAmount <= 99) {
                buttonSpin.isEnabled = false
            }
            when (img6) {
                1 -> {
                    imageSlot3Second.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot3Second.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot3Second.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot3Second.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot3Second.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot3Second.setImageResource(R.drawable.slot_6)
                }
            }

            if (img4 == img5 || img5 == img6 || img4 == img6) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }

            if (imageSlot3Second.isClickable || monetsAmount <= 19) {
                imageSlot3Second.isEnabled = false
            }

            imageSlot3Second.startAnimation(animation)

        }

        imageSlot1Third.setOnClickListener {

            img7 = Random.nextInt(1, 6)
            if (monetsAmount <= 99) {
                buttonSpin.isEnabled = false
            }
            when (img7) {
                1 -> {
                    imageSlot1Third.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot1Third.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot1Third.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot1Third.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot1Third.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot1Third.setImageResource(R.drawable.slot_6)
                }
            }
            if (img6 == img7 || img7 == img8 || img8 == img9 || img7 == img9) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()

            }

            if (imageSlot1Third.isClickable || monetsAmount <= 19) {
                imageSlot1Third.isEnabled = false
            }

            imageSlot1Third.startAnimation(animation)

        }

        imageSlot2Third.setOnClickListener {

            img8 = Random.nextInt(1, 6)
            if (monetsAmount <= 99) {
                buttonSpin.isEnabled = false
            }
            when (img8) {
                1 -> {
                    imageSlot2Third.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot2Third.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot2Third.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot2Third.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot2Third.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot2Third.setImageResource(R.drawable.slot_6)
                }
            }
            if (img7 == img8 || img8 == img9 || img7 == img9) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }

            if (imageSlot2Third.isClickable || monetsAmount <= 19) {
                imageSlot2Third.isEnabled = false
            }

            imageSlot2Third.startAnimation(animation)

        }

        imageSlot3Third.setOnClickListener {

            img9 = Random.nextInt(1, 6)
            if (monetsAmount <= 99) {
                buttonSpin.isEnabled = false
            }
            when (img9) {
                1 -> {
                    imageSlot3Third.setImageResource(R.drawable.slot_1)
                }
                2 -> {
                    imageSlot3Third.setImageResource(R.drawable.slot_2)
                }
                3 -> {
                    imageSlot3Third.setImageResource(R.drawable.slot_3)
                }
                4 -> {
                    imageSlot3Third.setImageResource(R.drawable.slot_4)
                }
                5 -> {
                    imageSlot3Third.setImageResource(R.drawable.slot_5)
                }
                else -> {
                    imageSlot3Third.setImageResource(R.drawable.slot_6)
                }
            }
            if (img7 == img8 || img8 == img9 || img7 == img9) {
                monetsAmount += 100
                creditsAmount.text = monetsAmount.toString()
                Log.d("coins", monetsAmount.toString())
            } else {
                decrem_slot()
            }

            if (imageSlot3Third.isClickable || monetsAmount <= 19) {
                imageSlot3Third.isEnabled = false
            }

            imageSlot3Third.startAnimation(animation)

        }

        buttonSpin.setOnClickListener {
            Log.d("coin_decrement", monetsAmount.toString())


            img1 = 11
            img2 = 12
            img3 = 13
            img4 = 14
            img5 = 15
            img6 = 16
            img7 = 17
            img8 = 18
            img9 = 19


            decrem()
            if ( monetsAmount > 99 ) {
                imageSlot1.setImageResource(0).also {
                    imageSlot1.isEnabled = true
                }
                imageSlot2.setImageResource(0).also {
                    imageSlot2.isEnabled = true
                }
                imageSlot3.setImageResource(0).also {
                    imageSlot3.isEnabled = true
                }

                imageSlot1Second.setImageResource(0).also {
                    imageSlot1Second.isEnabled = true
                }
                imageSlot2Second.setImageResource(0).also {
                    imageSlot2Second.isEnabled = true
                }
                imageSlot3Second.setImageResource(0).also {
                    imageSlot3Second.isEnabled = true
                }

                imageSlot1Third.setImageResource(0).also {
                    imageSlot1Third.isEnabled = true
                }
                imageSlot2Third.setImageResource(0).also {
                    imageSlot2Third.isEnabled = true
                }
                imageSlot3Third.setImageResource(0).also {
                    imageSlot3Third.isEnabled = true
                }

                linearLayoutSlots.startAnimation(animation_spin)
                linearLayoutSecond.startAnimation(animation_spin)
                linearLayoutThird.startAnimation(animation_spin)
            }

        }
    }

    private fun initViews() {

        creditsAmount = findViewById(R.id.textViewCreditsAmount)
        buttonSpin = findViewById(R.id.buttonSpin)
        imageSlot1 = findViewById(R.id.imageSlot1)


        imageSlot2 = findViewById(R.id.imageSlot2)

        imageSlot3 = findViewById(R.id.imageSlot3)

        imageSlot1Second = findViewById(R.id.imageSlot1Second)
        imageSlot2Second = findViewById(R.id.imageSlot2Second)
        imageSlot3Second = findViewById(R.id.imageSlot3Second)
        imageSlot1Third = findViewById(R.id.imageSlot1Third)
        imageSlot2Third = findViewById(R.id.imageSlot2Third)
        imageSlot3Third = findViewById(R.id.imageSlot3Third)

        linearLayoutSlots = findViewById(R.id.linearLayoutSlots)
        linearLayoutSecond = findViewById(R.id.linearLayoutSlotsSecond)
        linearLayoutThird = findViewById(R.id.linearLayoutSlotsThird)

    }

    private fun decrem() {

        if (monetsAmount >= 98) {
            monetsAmount -= 100
            creditsAmount.text = monetsAmount.toString()
            buttonSpin.isEnabled = true
            Log.d("coins", monetsAmount.toString())
        }  else if  (monetsAmount < 97) {
            buttonSpin.isEnabled = false

        }
    }

    private fun decrem_slot() {
        if (monetsAmount > 49) {
            monetsAmount -= 50
            val forDisplaying = monetsAmount.toString()
            creditsAmount.text = forDisplaying
            Log.d("coins", monetsAmount.toString())
        } else {
            imageSlot1.isEnabled = false
            imageSlot2.isEnabled = false
            imageSlot3.isEnabled = false

            imageSlot1Second.isEnabled = false
            imageSlot2Second.isEnabled = false
            imageSlot3Second.isEnabled = false

            imageSlot1Third.isEnabled = false
            imageSlot2Third.isEnabled = false
            imageSlot3Third.isEnabled = false
            Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show()

        }
    }


}
