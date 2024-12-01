package `2024`

fun main(args: Array<String>) {
  val path = "/Users/bozho/source/advent-of-code/src/main/resources/2024/01.txt"

  val hh =  HistorianHysteria()
  val ids = hh.readIds(path)

  println(hh.findDistance(ids.first, ids.second))
  println(hh.findSimilarity(ids.first, ids.second))
}