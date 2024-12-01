package `2024`

import java.io.File
import java.util.HashMap
import kotlin.math.abs

class HistorianHysteria {
  fun findDistance(lOne: List<Long>, lTwo: List<Long>): Long {
    return lOne.sorted().zip(lTwo.sorted()).sumOf { pair ->
      abs(pair.first - pair.second)
    }
  }

  fun findSimilarity(lOne: List<Long>, lTwo: List<Long>): Long {
    val accumulated: Map<Long, Long> = lTwo.foldRight(HashMap<Long, Long>()) { next, acc ->
      acc[next] = acc.getOrDefault(next, 0L) + 1
      acc
    }

    return lOne.sumOf { id -> id * accumulated.getOrElse(id) { 0 } }
  }

  fun readIds(filePath: String): Pair<List<Long>, List<Long>> {
    val firstColumn = mutableListOf<Long>()
    val secondColumn = mutableListOf<Long>()

    File(filePath).forEachLine { line ->
      val columns = line.split("\\s+".toRegex())
      if (columns.size == 2) {
        firstColumn.add(columns[0].toLong())
        secondColumn.add(columns[1].toLong())
      }
    }

    return Pair(firstColumn, secondColumn)
  }
}