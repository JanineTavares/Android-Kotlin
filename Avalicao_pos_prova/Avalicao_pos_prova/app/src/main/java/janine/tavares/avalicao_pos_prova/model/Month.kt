package janine.tavares.avalicao_pos_prova.model

import android.content.Context
import janine.tavares.avalicao_pos_prova.R

class Month(val monthNumber: Int, val context: Context) {


        fun showChosenMonth(): String {
            when (monthNumber) {
                    1 -> return context.getString(R.string.chose_january)
                    2 -> return context.getString(R.string.chose_february)
                    3 -> return context.getString(R.string.chose_march)
                    4 -> return context.getString(R.string.chose_april)
                    5 -> return context.getString(R.string.chose_may)
                    6 -> return context.getString(R.string.chose_june)
                    7 -> return context.getString(R.string.chose_july)
                    8 -> return context.getString(R.string.chose_august)
                    9 -> return context.getString(R.string.chose_september)
                    10 -> return context.getString(R.string.chose_october)
                    11 -> return context.getString(R.string.chose_november)
                    12 -> return context.getString(R.string.chose_december)
                    else -> {
                        return context.getString(R.string.wrongNumber)
                    }
                }
            }

        }

