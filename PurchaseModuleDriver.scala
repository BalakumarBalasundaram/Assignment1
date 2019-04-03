package com.assignment.main

import scala.collection.Seq

import com.assignment.model.Cart
import com.assignment.model.Customer
import com.assignment.model.BucketList
import com.assignment.model.SuperMarket
import com.assignment.model.StoreInfo
import com.assignment.model.CreditCardTypes
import com.assignment.model.ItemType
import com.assignment.model.ProductsOrderedCount
import com.assignment.model.CreditCard
import com.assignment.model.Product
import com.assignment.model.Address
import com.assignment.model.ItemType.ItemType
import com.assignment.model.PurchaseOrderDao

object PurchaseModuleDriver extends App {

  println("Ordering System. Finding Total Price & Linking Credit Card for purchase!")
  val allItemsCount = Seq(
    ProductsOrderedCount(Product("1001", "dove soap", ItemType.HomeAppliance, 4), 3),
    ProductsOrderedCount(Product("1002", "wollen carpet", ItemType.HomeAppliance, 34), 11),
    ProductsOrderedCount(Product("1003", "pen drive", ItemType.Electronic, 3), 7),
    ProductsOrderedCount(Product("1004", "Mobile Headset", ItemType.MobileAccessories, 10), 36))
  val productsOrdered = BucketList(allItemsCount)
  val orderTotalPrice = PurchaseOrderDao.getTotalAmount(productsOrdered)
  println("Total Amount is: " + orderTotalPrice)

  val productsList = Seq(
    Product("1001", "dove soap", ItemType.HomeAppliance, 6),
    Product("1002", "wollen carpet", ItemType.HomeAppliance, 56),
    Product("1003", "pen drive", ItemType.Electronic, 31),
    Product("1004", "Mobile Headset", ItemType.MobileAccessories, 19))
  val cart = Cart(Some(productsOrdered))
  val customer = Customer("Joe", "Smith", "20.01.2000", "joe", "898",
    Address("Street 1", "31C", "71912", "Belfast", "CatLand"),
    Some(cart), Some(CreditCard(CreditCardTypes.Visa, "joe", "abc", "982")))
  val storeInfo = StoreInfo("BollywoodStore", "www.bollywoodstore.com", productsList, Seq(customer))
  val store = new SuperMarket(storeInfo)
  println("Validate Store: " + store.validate(customer))
  
}
