package janine.tavares.avaliacao.model

class Calculator (var number1: Double,  var number2:Double) {

    fun toMultiplicate(): Double {
       return this.number1 * this.number2
    }

    fun toDivise(): Double {
        return this.number1 / this.number2
    }

    fun toAdd():Double {
       return  this.number1 + this.number2
    }

    fun toSubtracte():Double {
        return this.number1 - this.number2
    }
}