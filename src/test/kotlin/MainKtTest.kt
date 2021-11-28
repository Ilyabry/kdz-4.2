import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun limitsTypeCard_VK_limit_month_is_not_exhausted() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 0
        val amountKop: Int = 200000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_VK_limit_month_reached() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 40_000
        val amountKop: Int = 200000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_VK_limit_day_is_not_exhausted() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 14000
        val amountKop: Int = 15000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_VK_limit_Day_reached() {
        val typeCard: String = "VK"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_600_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_month_is_not_exhausted() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 15_000
        val amountKop: Int = 200000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_month_reached() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 550_000
        val amountKop: Int = 5_100_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_day_is_not_exhausted() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 14000
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_Visa_limit_Day_reached() {
        val typeCard: String = "Visa"
        val previousAmountRub: Int = 14000
        val amountKop: Int = 15_000_100

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_non_existent_card() {
        val typeCard: String = "Test"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_typeCard_default() {
        val previousAmountRub: Int = 5
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )

        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_previousAmountRub_default() {

        val typeCard: String = "Mastercard"
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            amountKop = amountKop
        )
        assertEquals(true, result)
    }

    @Test
    fun limitsTypeCard_Mir_limit_Day_reached() {

        val typeCard: String = "Mir"
        val previousAmountRub: Int = 0
        val amountKop: Int = 100_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )
        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Mir_limit_Month_reached() {

        val typeCard: String = "Mir"
        val previousAmountRub: Int = 600_000
        val amountKop: Int = 10_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )
        assertEquals(false, result)
    }

    @Test
    fun limitsTypeCard_Mastercard() {

        val typeCard: String = "Mastercard"
        val previousAmountRub: Int = 0
        val amountKop: Int = 1_000_000

        val result = limitsTypeCard(
            typeCard = typeCard,
            previousAmountRub = previousAmountRub,
            amountKop = amountKop
        )
        assertEquals(true, result)
    }
}