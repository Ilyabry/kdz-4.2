const val LIMIT_VK_MONTH = 40000
const val LIMIT_VK_DAY = 15000
const val LIMIT_MASTERCARD_MONTH = 600000
const val LIMIT_MASTERCARD_DAY = 150000
const val LIMIT_MASTERCARD_COMMISSION = 75000
const val MASTERDCARD_COMMISSION = 0.006
const val MORE_COMMISSION_MASTERCARD = 2000.00
const val MIR_OR_VISA_COMMISSION = 0.0075
const val MIR_OR_VISA_LEAST_COMMISSION = 3500.00

fun main() {
    val typeCard = "Mastercard"
    val amountRub = 5555
    val amountKop = amountRub * 100
    val previousAmountRub = 500000

    if (limitsTypeCard(typeCard, previousAmountRub, amountKop.toInt())) {
        val totalCommission = commissionTypeCardKop(typeCard, previousAmountRub, amountKop.toInt())
        val totalAmountRub = (amountKop + totalCommission) / 100

        val totalString = "%.2f".format(totalAmountRub)
        val rub = totalString.substringBefore(",")
        val kop = totalString.substringAfter(",")
        println("Сумма перевода составляет $rub рублей $kop копеек")

    } else println("Ежедневный или ежемесячный лимит исчерпан")
}

fun limitsTypeCard(typeCard: String = "VK", previousAmountRub: Int = 0, amountKop: Int): Boolean {
    return when (typeCard) {
        "Mastercard", " Mir", "Visa" -> when {
            previousAmountRub + amountKop / 100 <= LIMIT_MASTERCARD_MONTH -> when {
                amountKop / 100 <= LIMIT_MASTERCARD_DAY -> true
                else -> false
            }
            else -> false
        }
        "VK" -> when {
            previousAmountRub + amountKop / 100 <= LIMIT_VK_MONTH -> when {
                amountKop / 100 <= LIMIT_VK_DAY -> true
                else -> false
            }
            else -> false
        }
        else -> false
    }
}

fun commissionTypeCardKop(typeCard: String = "VK", previousAmountRub: Int = 0, amountKop: Int): Double {
    return when (typeCard) {
        "Mastercard" -> {
            when {
                previousAmountRub + amountKop / 100 > LIMIT_MASTERCARD_COMMISSION-> amountKop *
                        MASTERDCARD_COMMISSION + MORE_COMMISSION_MASTERCARD
                else -> 0.0
            }
        }
        "Visa", "Mir" -> {
            when {
                amountKop * MIR_OR_VISA_COMMISSION < MIR_OR_VISA_LEAST_COMMISSION -> MIR_OR_VISA_LEAST_COMMISSION
                else -> MIR_OR_VISA_COMMISSION
            }
        }
        else -> 0.0
    }
}