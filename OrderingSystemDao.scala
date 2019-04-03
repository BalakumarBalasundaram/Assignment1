package com.assignment.model

case class ProductsOrderedCount(item: Product, count: Int)
case class BucketList(orderItems: Seq[ProductsOrderedCount])

object PurchaseOrderDao {
  def getTotalAmount(order: BucketList): Double = {
    order.orderItems.foldLeft(0F) { case (acc, orderItem) => acc + orderItem.item.price * orderItem.count }
  }
}
