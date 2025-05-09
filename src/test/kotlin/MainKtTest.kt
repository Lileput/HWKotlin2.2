import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

@Test
 fun calcComissionMastercard() {
  val card = "Mastercard"
  val transfer = 70_000
  val mounthlyTransfer = 10_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(50 ,result)
 }

 @Test
 fun calcComissionMastercard75000() {
  val card = "Mastercard"
  val transfer = 10_000
  val mounthlyTransfer = 80_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(80 ,result)
 }
  @Test
  fun calcComissionErrorCard() {
   val card = "Unknown Card"
   val transfer = 70_000
   val mounthlyTransfer = 10_000

   val result = calcComission(card, transfer, mounthlyTransfer)

   assertEquals(ERROR_TYPE ,result)
  }

 @Test
 fun calcComissionErrorLimit() {
  val card = "Unknown Card"
  val transfer = 70_000
  val mounthlyTransfer = 550_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(ERROR_LIMIT ,result)
 }

 @Test
 fun calcComissionErrorMounth() {
  val card = "Unknown Card"
  val transfer = 70_000
  val mounthlyTransfer = 750_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(ERROR_LIMIT ,result)
 }

 @Test
 fun calcComissionErrorLimitDay() {
  val card = "Unknown Card"
  val transfer = 200_000
  val mounthlyTransfer = 50_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(ERROR_LIMIT ,result)
 }

 @Test
 fun calcComissionVisa() {
  val card = "Visa"
  val transfer = 70_000
  val mounthlyTransfer = 10_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(525 ,result)
 }

 @Test
 fun calcComissionMir() {
  val card = "Мир"
  val transfer = 70_000
  val mounthlyTransfer = 10_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(0 ,result)
 }

 @Test
 fun calcComissionMaestro() {
  val card = "Maestro"
  val transfer = 70_000
  val mounthlyTransfer = 10_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(50 ,result)
 }

 @Test
 fun calcComissionMasterCardNoTax() {
  val card = "Mastercard"
  val transfer = 30_000
  val mounthlyTransfer = 10_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(0 ,result)
 }

 @Test
 fun calcComissionMaestroNoTax() {
  val card = "Maestro"
  val transfer = 30_000
  val mounthlyTransfer = 10_000

  val result = calcComission(card, transfer, mounthlyTransfer)

  assertEquals(0 ,result)
 }
}