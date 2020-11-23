package janine.tavares.what_movie_is_it_.model

import android.content.Context
import android.media.MediaPlayer
import janine.tavares.what_movie_is_it_.R


class QuizManegement {

    companion object {

        lateinit var mediaPlayer: MediaPlayer
        var questionArray = ArrayList<Question>()
        var context: Context? = null

//        init {
//            generateQuestions()
//            shuffleQuestions()
//        }

        fun generateQuestions() {
            questionArray.add(
                Question(
                    context!!.getString(R.string.question1),
                    context!!.getString(R.string.saw),
                    context!!.getString(R.string.godFather),
                    context!!.getString(R.string.matrix),
                    context!!.getString(R.string.shawShank),
                    context!!.getString(R.string.shawShank)


                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question2),
                    context!!.getString(R.string.godFather),
                    context!!.getString(R.string.faceOff),
                    context!!.getString(R.string.amadeus),
                    context!!.getString(R.string.alien),
                    context!!.getString(R.string.godFather)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question3),
                    context!!.getString(R.string.bastards),
                    context!!.getString(R.string.amadeus),
                    context!!.getString(R.string.darkKnight),
                    context!!.getString(R.string.saw),
                    context!!.getString(R.string.saw)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question4),
                    context!!.getString(R.string.matrix),
                    context!!.getString(R.string.joker),
                    context!!.getString(R.string.pulp),
                    context!!.getString(R.string.inception),
                    context!!.getString(R.string.pulp)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question5),
                    context!!.getString(R.string.saw),
                    context!!.getString(R.string.godFather),
                    context!!.getString(R.string.inception),
                    context!!.getString(R.string.shawShank),
                    context!!.getString(R.string.inception)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question6),
                    context!!.getString(R.string.godFather),
                    context!!.getString(R.string.faceOff),
                    context!!.getString(R.string.matrix),
                    context!!.getString(R.string.alien),
                    context!!.getString(R.string.matrix)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question7),
                    context!!.getString(R.string.bastards),
                    context!!.getString(R.string.amadeus),
                    context!!.getString(R.string.joker),
                    context!!.getString(R.string.lambs),
                    context!!.getString(R.string.joker)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question8),
                    context!!.getString(R.string.bastards),
                    context!!.getString(R.string.shining),
                    context!!.getString(R.string.joker),
                    context!!.getString(R.string.lambs),
                    context!!.getString(R.string.shining)

                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question9),
                    context!!.getString(R.string.matrix),
                    context!!.getString(R.string.joker),
                    context!!.getString(R.string.jurassic),
                    context!!.getString(R.string.inception),
                    context!!.getString(R.string.jurassic)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question10),
                    context!!.getString(R.string.mad),
                    context!!.getString(R.string.joker),
                    context!!.getString(R.string.jurassic),
                    context!!.getString(R.string.renevant),
                    context!!.getString(R.string.mad)

                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question11),
                    context!!.getString(R.string.matrix),
                    context!!.getString(R.string.joker),
                    context!!.getString(R.string.jurassic),
                    context!!.getString(R.string.renevant),
                    context!!.getString(R.string.renevant)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question12),
                    context!!.getString(R.string.bastards),
                    context!!.getString(R.string.faceOff),
                    context!!.getString(R.string.gladiator),
                    context!!.getString(R.string.footLoose),
                    context!!.getString(R.string.gladiator)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question13),
                    context!!.getString(R.string.godFather),
                    context!!.getString(R.string.alien),
                    context!!.getString(R.string.amadeus),
                    context!!.getString(R.string.footLoose),
                    context!!.getString(R.string.alien)
                )
            )
            questionArray.add(
                Question(
                    context!!.getString(R.string.question14),
                    context!!.getString(R.string.matrix),
                    context!!.getString(R.string.godFather),
                    context!!.getString(R.string.toy),
                    context!!.getString(R.string.amadeus),
                    context!!.getString(R.string.toy)
                )
            )

        }


        fun markAsRepeated() {
            questionArray.get(0).repeatedQuestion = true
        }


//        fun shuffleQuestions() {
//            while(questionArray.get(0).repeatedQuestion) {
//                questionArray.shuffle()
//            }
//                markAsRepeated()
//        }


        fun finalResult(context: Context) {
            if(QuizManegement.checkAverageScore() >= 70.0){
                QuizManegement.playAudio(R.raw.finalgood, context!!) }
            else {
                QuizManegement.playAudio(R.raw.finalsad, context!!)
            }
        }


        fun shuffleQuestions() {
            questionArray.shuffle()
        }

        fun showScore(): Int {
                var score = 0
                for (questions in questionArray) {
                    if (questions.correctAnswer) {
                        score++
                    }
                }
                return score
        }

        fun isCorrect(answer: String): Boolean {
                if (answer.equals(questionArray.get(0).correctOption)) {
                    questionArray.get(0).correctAnswer = true
                    return true
                } else {
                    return false
                }

        }

        fun checkAverageScore(): Double {
                return (showScore() / 7.0) * 100
        }

        fun playAudio(audio: Int, context: Context) {
                mediaPlayer = MediaPlayer.create(context, audio)
                mediaPlayer.start()

        }


        fun stopMedia() {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.stop()
                }
        }

        fun showCorrects(): String {
                return "${R.string.correctAnswers}/14"
        }

        fun clear() {
            questionArray.clear()
            generateQuestions()

        }


        }


    }












