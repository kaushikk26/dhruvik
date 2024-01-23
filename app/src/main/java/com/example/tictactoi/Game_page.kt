package com.example.tictactoi

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Game_page : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    var btn = ArrayList<Button>()
    private var playerTurn = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)


        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)


        btn.add(btn1)
        btn.add(btn2)
        btn.add(btn3)
        btn.add(btn4)
        btn.add(btn5)
        btn.add(btn6)
        btn.add(btn7)
        btn.add(btn8)
        btn.add(btn9)


        click(0)
        click(1)
        click(2)
        click(3)
        click(4)
        click(5)
        click(6)
        click(7)
        click(8)

        for (i in 0..8) {
            click(i)
        }
    }

    private fun click(i: Int) {
        btn[i].setOnClickListener {
            if (btn[i].text.isEmpty()) {
                if (playerTurn) {
                    btn[i].text = "X"
                } else {
                    btn[i].text = "0"
                }
                playerTurn = !playerTurn
                checkWinner()
            }
        }
    }

    private fun checkWinner() {
        val winningPositions = arrayOf(
            // Winning combinations (indices)
            intArrayOf(0, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8), // Rows
            intArrayOf(0, 3, 6), intArrayOf(1, 4, 7), intArrayOf(2, 5, 8), // Columns
            intArrayOf(0, 4, 8), intArrayOf(2, 4, 6)
        )
        for (positions in winningPositions) {
            val (a, b, c) = positions
            if (btn[a].text == "X" && btn[b].text == "X" && btn[c].text == "X") {
                displayWinner(" X is win ")
                return
            } else if (btn[a].text == "0" && btn[b].text == "0" && btn[c].text == "0") {
                displayWinner(" 0 is win ")
                return
            }
        }

        if (btn.all { it.text.isNotEmpty() }) {
            displayWinner("It's a Draw")
        }
    }

    private fun resetGame() {
        for (button in btn) {
            button.text = ""
        }
    }

    private fun displayWinner(winner: String) {
        val dialogView = layoutInflater.inflate(R.layout.alertdialog, null)
        dialogView.findViewById<TextView>(R.id.winnerText).text = winner
        val dialog = AlertDialog.Builder(this).setView(dialogView).setCancelable(false).create()
        dialog.show()

        val startagain = dialogView.findViewById<Button>(R.id.startagain)
        startagain.setOnClickListener {
            dialog.dismiss()
            resetGame()
        }
    }
}