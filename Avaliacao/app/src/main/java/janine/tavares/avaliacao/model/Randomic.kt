package janine.tavares.avaliacao.model

class Randomic {

    fun generateRandomic(): Int {

        return (0..100).random()
    }

    override fun toString(): String {
        return "Randomic : ${this.generateRandomic()}"
    }
}
