package com.assignment.model

case class Address(street: String, number: String, postalCode: String, city: String, country: String)
case class CreditCard(cardType: CreditCardTypes.CreditCardTypes, name: String, accountNumber: String, secCode: String)
case class Cart(order: Option[BucketList])

case class Customer(firstName: String, lastName: String, birthday: String, user: String, password: String, address: Address, cart: Option[Cart], card: Option[CreditCard])
case class Product(name: String, description: String, itemType: ItemType.ItemType, price: Float)

case class StoreInfo(name: String, link: String, items: Seq[Product], customers: Seq[Customer])

class SuperMarket(storeInfo: StoreInfo) {
  def validate(customer: Customer): Boolean = {
    if (!storeInfo.customers.exists(cust => cust.user == customer.user)) false
    else {
      val maybeOrder = customer.cart.flatMap(_.order)
      val maybeCard = customer.card
      maybeCard.nonEmpty && maybeOrder.nonEmpty
    }
  }
}
