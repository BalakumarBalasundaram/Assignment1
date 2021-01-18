package com.exercise.assignment

import org.apache.log4j.Logger

object RunChallenge {

  def main(args: Array[String]): Unit ={
    val emptyList: List[String] = List[String]()
    val input = Array("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST", "NORTH")
    println("input directions : " + input.toList)
    val result = Challenge.dirReductionAlgorithm(input.toList, emptyList)
    println("reduced directions : " + result.toList)
  }

}
