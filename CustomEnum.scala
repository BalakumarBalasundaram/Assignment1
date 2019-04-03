package com.assignment.model

object CreditCardTypes extends Enumeration {
  type CreditCardTypes = Value
  val Visa, MasterCard, Maestro = Value
}

object ItemType extends Enumeration {
  type ItemType = Value
  val HomeAppliance, Electronic,  MobileAccessories = Value
}

object PurchaseResult extends Enumeration {
  type PurchaseResult = Value
  val PurchaseSuccessful, PurchaseFailure = Value
}
